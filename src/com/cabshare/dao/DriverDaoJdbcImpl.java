package com.cabshare.dao;

import static com.cabshare.constant.ApplicationConstants.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cabshare.entity.User;
import com.cabshare.entity.Driver;

public class DriverDaoJdbcImpl extends UserDaoJdbcImpl implements DriverDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean beginRide(User user, Driver driver) {
		
		return false;
	}

	@Override
	public boolean endRide(User user, Driver driver) {
		
		return false;
	}

	@SuppressWarnings({ "deprecation"})
	@Override
	public boolean nextPosition(int position, Driver driver) {
		try {
			//Update current location
			jdbcTemplate.update(DRIVER_NEXT_LOCATION, new Object[]{position, driver.getUsername()});
			
			//Query for available seats
			int seatsAvailable = jdbcTemplate.queryForInt(DRIVER_GET_AVAILABLE_SEATS, new Object[]{driver.getUsername()});
			//Adding passengers
			if (seatsAvailable > 0 /*&& seatsAvailable == driver.getSeats()*/) {   //Confused entity. Shareable???
				int passengerCount = jdbcTemplate.queryForInt(DRIVER_CHECK_WAITING_PASSENGERS, new Object[]{position, seatsAvailable});
				if (passengerCount > 0) {
					//FCFS
					List<Map<String, Object>> rows = jdbcTemplate.queryForList(DRIVER_COUNT_PASSENGER_SIZE, new Object[]{position, seatsAvailable});
					for (Map<String, Object> row : rows) {						
						int urid = Integer.parseInt(String.valueOf(row.get("urid")));
						int size = Integer.parseInt(String.valueOf(row.get("size")));
						
						if (seatsAvailable >= size) {
						
							if (seatsAvailable == driver.getSeats()) {	//New Ride
								jdbcTemplate.update(DRIVER_NEW_RIDE, new Object[]{position, driver.getUsername()});
							}
							jdbcTemplate.update(DRIVER_UPDATE_SEATS, new Object[]{seatsAvailable - size, driver.getUsername()});
							seatsAvailable -= size;
							jdbcTemplate.update(DRIVER_UPDATE_USER, new Object[]{driver.getUsername(), position, urid});
						}
					}

				}
				
			}
			
			//Ending rides
			//Querying if destination reached
			int passengersToLeave = jdbcTemplate.queryForInt(DRIVER_CHECK_END_OF_RIDE, new Object[]{position, driver.getUsername()});
			if (passengersToLeave > 0) {		//People deboarding
				//Querying the passengers to leave
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(DRIVER_PASSENGERS_LEAVING, new Object[]{position, driver.getUsername()});
				for (Map<String, Object> row : rows) {						
					int urid = Integer.parseInt(String.valueOf(row.get("urid")));
					String passenger = String.valueOf(row.get("username"));
					int source = Integer.parseInt(String.valueOf(row.get("source")));
					int size = Integer.parseInt(String.valueOf(row.get("size")));
					
					int seatsShared = driver.getSeats() - jdbcTemplate.queryForInt(DRIVER_GET_AVAILABLE_SEATS, new Object[]{driver.getUsername()});
					
					//Querying distances
					int sourceDistance = jdbcTemplate.queryForInt(GET_STOP_DETAILS, new Object[]{source});
					int destinationDistance = jdbcTemplate.queryForInt(GET_STOP_DETAILS, new Object[]{position});
					
					int fare = FARE_RATE * size * (destinationDistance - sourceDistance) / seatsShared;
					
					jdbcTemplate.update(DRIVER_UPDATE_USER_FARE, new Object[]{fare, urid});
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
