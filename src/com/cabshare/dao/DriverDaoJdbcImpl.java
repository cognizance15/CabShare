package com.cabshare.dao;

import com.cabshare.entity.User;

public class DriverDaoJdbcImpl extends UserDaoJdbcImpl implements DriverDao{

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setPosition(String position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean beginRide(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean endRide(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
