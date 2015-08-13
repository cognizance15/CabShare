package com.cabshare.dao;

import static com.cabshare.constant.ApplicationConstants.INSERT_INTO_USER_RIDE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cabshare.entity.User;
@Repository(value="passDao")
public class PassengerDaoJdbcImpl extends UserDaoJdbcImpl implements PassengerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public boolean joinRide(User user) {
		return false;
		
	}

	@Override
	public boolean takeRide(String username,int source,int destination,int size) {
		try{
			
			jdbcTemplate.update(INSERT_INTO_USER_RIDE, new Object[]{
					username,source,destination,size});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;	}

	@Override
	public boolean updateFare(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
