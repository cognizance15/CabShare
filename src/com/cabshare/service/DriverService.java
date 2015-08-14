package com.cabshare.service;

import com.cabshare.dao.DriverDaoJdbcImpl;
import com.cabshare.entity.Driver;

public class DriverService {
	private DriverDaoJdbcImpl driverDaoJdbcImpl;
	public DriverService() {
		driverDaoJdbcImpl = new DriverDaoJdbcImpl();
	}

	public boolean nextPosition(int position, Driver driver) {
		try {
			driverDaoJdbcImpl.nextPosition(position, driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return false;
	}
	
	public boolean setPosition(int position, Driver driver) {
		try {
			driverDaoJdbcImpl.setPosition(position, driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return false;
	}
}
