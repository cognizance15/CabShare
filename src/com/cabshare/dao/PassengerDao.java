package com.cabshare.dao;

import com.cabshare.entity.Passenger;
import com.cabshare.entity.User;

public interface PassengerDao extends UserDao{
	public boolean  joinRide(User user);
	public boolean updateFare(Passenger passenger);
	public boolean takeRide(Passenger passenger);
	
}
