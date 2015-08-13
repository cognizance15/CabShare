package com.cabshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cabshare.dao.PassengerDao;
import com.cabshare.entity.User;

public class PassengerServiceImpl extends UserServiceImpl implements PassengerService {

	@Autowired
	@Qualifier(value="passDao")
	PassengerDao passengerDao;

	@Override
	public boolean joinRide(User user) {
		return passengerDao.joinRide(user);
	}

	@Override
	public boolean takeRide(User user) {
		return passengerDao.takeRide(user);
	}

	@Override
	public boolean updateFare(User user) {
		return passengerDao.updateFare(user);
	}
	
	
}
