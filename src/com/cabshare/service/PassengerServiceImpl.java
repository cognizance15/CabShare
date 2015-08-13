package com.cabshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cabshare.dao.PassengerDao;
import com.cabshare.entity.User;
@Service(value="passService")
public class PassengerServiceImpl extends UserServiceImpl implements PassengerService {

	@Autowired
	@Qualifier(value="passDao")
	PassengerDao passengerDao;

	@Override
	public boolean joinRide(User user) {
		return passengerDao.joinRide(user);
	}

	
	@Override
	public boolean updateFare(User user) {
		return passengerDao.updateFare(user);
	}


	@Override
	public boolean takeRide(String username,int source, int destination,int size) {
		return passengerDao.takeRide(username, source, destination, size);
	}
	
	
}
