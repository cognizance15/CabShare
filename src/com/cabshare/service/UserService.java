package com.cabshare.service;

import com.cabshare.entity.User;

public interface UserService {

	public boolean register(User user);
	public boolean login(String uname, String password);
	public boolean changePassword(String username, String password);
	public boolean updateDetails(User user);
}
