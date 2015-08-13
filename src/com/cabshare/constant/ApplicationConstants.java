package com.cabshare.constant;

public class ApplicationConstants {

	public static final String INSERT_INTO_USER_DETAILS="insert into userDetails"
			+ "(name,username, password,age,gender,email,mobile)"
			+ " values(?,?,?,?,?,?,?)";
	
	public static final String INSERT_INTO_USER_RIDE="insert into userride"
			+ "(username,source,destination,size)"
			+ " values(?,?,?,?)";
	
	public static final String USER_LOGIN_CHECK = "select count(*) from userDetails where username=? and password=?";
	
	public static final String VALIDATE_USERNAME = "select count(*) from userDetails where username=?";
	
	public static final String CHANGE_PASSWORD = "update userDetails set password=:password where username=?)";
	
	public static final String CHECK_USERNAME = "select count(*) from userDetails where username=?";
}
