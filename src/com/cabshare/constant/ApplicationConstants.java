package com.cabshare.constant;

public class ApplicationConstants {

	public static final String INSERT_INTO_USER_DETAILS="insert into userDetails"
			+ "(username, password,email,usertype)"
			+ " values(?,?,?,?)";
	
	public static final String UPDATE_DETAILS = "update userDetails set name=?, age=?, gender=?, mobile=?"
			+ " where username=?";

public static final int FARE_RATE = 10;
	
	
	
	public static final String INSERT_INTO_USER_RIDE="insert into userride"
			+ "(username,source,destination,shareable,size)"
			+ " values(?,?,?,?,?)";
	
	public static final String GET_FARE = "select fare from userride where username=?";
	
	public static final String USER_LOGIN_CHECK = "select count(*) from userDetails where username=? and password=? and userType=?";
	
	public static final String VALIDATE_USERNAME = "select count(*) from userDetails where username=?";
	
	public static final String CHANGE_PASSWORD = "update userDetails set password=:? where username=?)";
	
	public static final String CHECK_USERNAME = "select count(*) from userDetails where username=?";

	public static final String DRIVER_NEXT_LOCATION = "update cabride set location=? where drivername=?";
	
	public static final String DRIVER_SET_LOCATION = "update cabride set location=?, source=NULL, destination=NULL, shareable=NULL, seatsavailable=? where drivername=?";
	
	public static final String DRIVER_GET_AVAILABLE_SEATS = "select seatsavailable from cabride where drivername=?";
	
	public static final String DRIVER_CHECK_WAITING_PASSENGERS = "select count(*) from userride where source=? and shareable=true and drivername=NULL and size <= ?";
	
	public static final String DRIVER_COUNT_PASSENGER_SIZE = "select urid, size from userride where source=? and shareable=true and drivername=NULL and size <= ?";
	
	public static final String DRIVER_NEW_RIDE = "update cabride set source=? where drivername=?";

	public static final String DRIVER_UPDATE_SEATS = "update cabride set seatsavailable=? where drivername=?";
	
	public static final String DRIVER_UPDATE_USER = "update userride set drivername=?, location=?, fare=0 where urid=?";
	
	public static final String DRIVER_CHECK_END_OF_RIDE = "select count(*) from userride where destination=? and drivername=? and fare=0";
	
	public static final String DRIVER_PASSENGERS_LEAVING = "select urid, username, source, size from userride where destination=? and drivername=? and fare=0";
	
	public static final String GET_STOP_DETAILS = "select distance from stops where sid=?";
	
	public static final String DRIVER_UPDATE_USER_FARE = "update userride set fare=? where urid=?";
}
