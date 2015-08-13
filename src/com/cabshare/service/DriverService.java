package com.cabshare.service;

import com.cabshare.dao.DriverDaoJdbcImpl;
import com.cabshare.entity.User;

public class DriverService {
	private DriverDaoJdbcImpl driverDaoJdbcImpl;
	public DriverService() {
		driverDaoJdbcImpl = new DriverDaoJdbcImpl();
	}

	public boolean setPosition(String position) {
		try {
			driverDaoJdbcImpl.setPosition(position);
			return true;
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return false;
	}
	
	public boolean beginRide(User user){
		try {
			driverDaoJdbcImpl.beginRide(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean endRide(User user) {
		try {
			driverDaoJdbcImpl.endRide(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
