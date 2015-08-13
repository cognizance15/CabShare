package com.cabshare.dao;

import com.cabshare.entity.Driver;
import com.cabshare.entity.User;

public interface DriverDao extends UserDao{
	boolean beginRide(User user, Driver driver);
	boolean endRide(User user, Driver driver);
	boolean nextPosition(int position, Driver driver);
}
