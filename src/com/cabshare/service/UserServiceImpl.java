package com.cabshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cabshare.dao.UserDao;
import com.cabshare.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@Override
	public boolean register(User user) {
		return userDao.register(user);
	}

	@Override
	public boolean login(String uname, String password, String type) {
		return userDao.login(uname, password, type);
	}

	@Override
	public boolean changePassword(String username, String password) {
		return userDao.changePassword(username, password);
	}

	@Override
	public boolean updateDetails(User user) {
		return userDao.updateDetails(user);
	}
	
	@Override
	public boolean validateUsername(String username) {
		System.out.println("UserServiceImpl.validateUsername()");
		return userDao.validateUsername(username);
	}

}
