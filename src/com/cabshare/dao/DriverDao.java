package com.cabshare.dao;

import java.util.List;
import java.util.Map;

import com.cabshare.entity.Driver;

public interface DriverDao extends UserDao{
	public boolean setPosition(int position, Driver driver);
	public boolean nextPosition(int position, Driver driver);
	public int getLastStop();
	public List<Map<String, Object>>  getStops();
	public List<Map<String, Object>> getRideInfo(Driver driver);
}
