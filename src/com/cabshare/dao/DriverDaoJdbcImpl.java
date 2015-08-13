package com.cabshare.dao;

import static com.cabshare.constant.ApplicationConstants.*;

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

	@Override
	public boolean nextPosition(int position, Driver driver) {
		try {
			//Update current location
			jdbcTemplate.update(DRIVER_NEXT_LOCATION, new Object[]{position, driver.getUsername()});
			
			//Query for available seats
			int seatsAvailable = jdbcTemplate.queryForInt(DRIVER_NEXT_LOCATION, new Object[]{position, driver.getUsername()});
			if (seatsAvailable > 0) {
				int passengercount = jdbcTemplate.queryForInt(DRIVER_CHECK_WAITING_PASSENGERS, new Object[]{position, seatsAvailable});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
