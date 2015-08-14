package com.cabshare.dao;

import static com.cabshare.constant.ApplicationConstants.GET_FARE;
import static com.cabshare.constant.ApplicationConstants.INSERT_INTO_USER_RIDE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cabshare.entity.Passenger;
import com.cabshare.entity.User;


@Repository(value="passDao")
public class PassengerDaoJdbcImpl extends UserDaoJdbcImpl implements PassengerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public boolean joinRide(User user) {
		return false;
		
	}

	

	@SuppressWarnings("unused")
	@Override
	public boolean updateFare(Passenger passenger) {
		try{
			int fare=jdbcTemplate.queryForInt(GET_FARE, new Object[]{
					passenger.getUsername()});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean takeRide(Passenger passenger) {
		try{
			
			jdbcTemplate.update(INSERT_INTO_USER_RIDE, new Object[]{
					passenger.getUsername(),passenger.getSource(),passenger.getDestination(),"1",passenger.getSize()});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
}
