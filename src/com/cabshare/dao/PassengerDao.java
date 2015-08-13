package com.cabshare.dao;

public interface PassengerDao extends UserDao{
	boolean  joinRide();
	boolean  takeRide();
	boolean updateFare();
	
}
