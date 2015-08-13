package com.cabshare.service;

import com.cabshare.entity.User;

public interface PassengerService extends UserService{
	public boolean joinRide(User user);
	public boolean updateFare(User user);
	boolean takeRide(String username, int source, int destination, int size);
	
}
