package com.cabShare.dao;

import com.cabShare.entity.User;

public interface UserDao {

	public boolean register(User user);
	public boolean login(String uname, String password);
	public boolean changePassword(String username, String password);
	public boolean updateDetails(User user);
	public boolean validateUsername(String username);
	//public boolean logout();
}
