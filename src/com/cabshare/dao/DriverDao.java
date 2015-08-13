package com.cabshare.dao;

import com.cabshare.entity.User;

public interface DriverDao extends UserDao{
	boolean beginRide(User user);
	boolean endRide(User user);
	boolean setPosition(String position);
}
