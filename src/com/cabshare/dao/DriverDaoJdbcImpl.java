package com.cabshare.dao;

import static com.cabshare.constant.ApplicationConstants.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cabshare.entity.Driver;

@Repository(value="driverDao")
public class DriverDaoJdbcImpl extends UserDaoJdbcImpl implements DriverDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "deprecation", "unused"})
	@Override
	public boolean nextPosition(int position, Driver driver) {
		try {
			//Update current location
			jdbcTemplate.update(DRIVER_NEXT_LOCATION, new Object[]{position, driver.getUsername()});
			
			//Ending rides
			//Query for available seats
			int seatsAvailable = jdbcTemplate.queryForInt(DRIVER_GET_AVAILABLE_SEATS, new Object[]{driver.getUsername()});
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
					
					seatsAvailable += size;
					jdbcTemplate.update(DRIVER_UPDATE_SEATS, new Object[]{seatsAvailable});
				}
			}
			
//			//Query for available seats
//			seatsAvailable = jdbcTemplate.queryForInt(DRIVER_GET_AVAILABLE_SEATS, new Object[]{driver.getUsername()});
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setPosition(int position, Driver driver) {
		try {
			jdbcTemplate.update(DRIVER_SET_LOCATION, new Object[]{position, driver.getSeats(), driver.getUsername()});
//			//Query for available seats
//			seatsAvailable = jdbcTemplate.queryForInt(DRIVER_GET_AVAILABLE_SEATS, new Object[]{driver.getUsername()});
			//Adding passengers
			int seatsAvailable = driver.getSeats();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Map<String, Object>> getStops() {

		List<Map<String, Object>> allStops = jdbcTemplate.queryForList(GET_ALL_STOPS);
		return allStops;
	}

	public List<Map<String, Object>> getRideInfo(Driver driver) {
		List<Map<String, Object>> rides = jdbcTemplate.queryForList(GET_RIDE_INFO, new Object[]{driver.getUsername()});
		return rides;
	}

}
