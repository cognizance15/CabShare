package com.cabshare.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.cabshare.constant.ApplicationConstants.*;

import com.cabshare.entity.User;

@Repository
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean register(User user) {

		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", user.getName());
			params.put("username", user.getUsername());
			params.put("password", user.getPassword());
			params.put("age", user.getAge());
			params.put("gender", user.getGender());
			params.put("email", user.getEmail());
			params.put("mobNo", user.getMobNo());
			jdbcTemplate.update(INSERT_INTO_USER_DETAILS, params);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) {

		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			params.put("password", password);
			int count = jdbcTemplate.queryForInt(USER_LOGIN_CHECK, params);
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
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			params.put("password", password);
			jdbcTemplate.update(CHANGE_PASSWORD, params);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validateUsername(String username) {

		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			int count = jdbcTemplate.queryForInt(CHECK_USERNAME, params);
			if(count==0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateDetails(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
