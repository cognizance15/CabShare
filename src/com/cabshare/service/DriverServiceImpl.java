package com.cabshare.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cabshare.dao.DriverDao;
import com.cabshare.dao.DriverDaoJdbcImpl;
import com.cabshare.entity.Driver;

@Service(value="driverService")
public class DriverServiceImpl implements DriverService {
	@Autowired
	@Qualifier("driverDao")
	private DriverDao driverDao;
	
	public boolean nextPosition(int position, Driver driver) {
		try {
			driverDao.nextPosition(position, driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean setPosition(int position, Driver driver) {
		try {
			driverDao.setPosition(position, driver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getStops() {
		return driverDao.getStops();
	}

	@Override
	public List<Map<String, Object>> getRideInfo(Driver driver) {
		return driverDao.getRideInfo(driver);
	}
	
}
