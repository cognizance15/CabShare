package com.cabshare.dao;

import java.util.Map;

import com.cabshare.entity.User;

public interface UserDao {

	public boolean register(User user);
	public boolean login(Map<String, String> userdetails);
	public boolean changePassword(String username, String password);
	public boolean updateDetails(User user);
}
