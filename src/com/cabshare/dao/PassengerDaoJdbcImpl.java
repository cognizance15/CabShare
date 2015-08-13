package com.cabshare.dao;

import static com.cabshare.constant.ApplicationConstants.INSERT_INTO_USER_DETAILS;

import java.util.HashMap;
import java.util.Map;

import com.cabshare.entity.User;

public class PassengerDaoJdbcImpl extends UserDaoJdbcImpl implements PassengerDao {

	@Override
	public boolean joinRide(User user) {
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", user.getName());
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean takeRide(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFare(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
