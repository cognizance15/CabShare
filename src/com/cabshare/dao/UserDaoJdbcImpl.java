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
					user.getName(),user.getUsername(), user.getPassword(),
					user.getAge(),user.getGender(),user.getEmail(),user.getMobNo()});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) {

		try{
			int count = jdbcTemplate.queryForInt(USER_LOGIN_CHECK, new Object[]{username,password});
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
