package com.cabshare.service;

import com.cabshare.entity.Passenger;
import com.cabshare.entity.User;

public interface PassengerService extends UserService{
	public boolean joinRide(User user);
	public boolean updateFare(Passenger passenger);
	public boolean takeRide(Passenger passenger);
	
}
