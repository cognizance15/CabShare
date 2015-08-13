package com.cabshare.dao;

import com.cabshare.entity.User;
import com.cabshare.entity.Driver;

public class DriverDaoJdbcImpl extends UserDaoJdbcImpl implements DriverDao{

	@Override
	public boolean beginRide(User user, Driver driver) {
		
		return false;
	}

	@Override
	public boolean endRide(User user, Driver driver) {
		
		return false;
	}

	@Override
	public boolean setPosition(String position, Driver driver) {
		
		return false;
	}
}
