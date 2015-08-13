package com.cabshare.dao;

import com.cabshare.entity.User;

public interface PassengerDao extends UserDao{
	public boolean  joinRide(User user);
	public boolean  takeRide(String username,int source,int destination,int size);
	public boolean updateFare(User user);
	
}
