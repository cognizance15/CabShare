package com.cabshare.dao;

import java.util.List;
import java.util.Map;

import com.cabshare.entity.Driver;

public interface DriverDao extends UserDao{
	boolean setPosition(int position, Driver driver);
	boolean nextPosition(int position, Driver driver);
	List<Map<String, Object>>  getStops();
	List<Map<String, Object>> getRideInfo(Driver driver);
}
