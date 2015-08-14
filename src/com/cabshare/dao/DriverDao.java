package com.cabshare.dao;

import com.cabshare.entity.Driver;

public interface DriverDao extends UserDao{
	boolean setPosition(int position, Driver driver);
	boolean nextPosition(int position, Driver driver);
}
