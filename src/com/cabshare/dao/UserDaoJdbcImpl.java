package com.cabshare.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.cabshare.constant.ApplicationConstants.*;

import com.cabshare.entity.User;

@Repository(value="userDao")
public class UserDaoJdbcImpl implements UserDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean register(User user) {

		try{
			
			jdbcTemplate.update(INSERT_INTO_USER_DETAILS, new Object[]{
					user.getUsername(), user.getPassword(),
					user.getEmail(),user.getType()
					});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean login(String username, String password, String type) {

		try{
			int count = jdbcTemplate.queryForInt(USER_LOGIN_CHECK, new Object[]{username,password, type});
			System.out.println(count);
			if(count==1)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePassword(String username, String password) {

		try{
			jdbcTemplate.update(CHANGE_PASSWORD, new Object[]{username,password});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validateUsername(String username) {

		System.out.println("UserDaoJdbcImpl.validateUsername()");
		try{
			int count = jdbcTemplate.queryForInt(CHECK_USERNAME, username);
			System.out.println(count);
			if(count>0)
				return false;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(12);
		}
		return true;
	}
	
	@Override
	public boolean updateDetails(User user) {

		try{
			jdbcTemplate.update(UPDATE_DETAILS, new Object[]{user.getName(), user.getAge(),
															user.getGender(), user.getMobNo(),
															user.getUsername()
															});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
