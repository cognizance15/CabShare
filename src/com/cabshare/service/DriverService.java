package com.cabshare.service;

import java.util.List;
import java.util.Map;

import com.cabshare.entity.Driver;

public interface DriverService {

	public boolean nextPosition(int position, Driver driver);
	public boolean setPosition(int position, Driver driver);
	public List<Map<String, Object>> getStops();
	public List<Map<String, Object>> getRideInfo(Driver driver);
}
