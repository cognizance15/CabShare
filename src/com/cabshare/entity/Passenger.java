package com.cabshare.entity;

public class Passenger extends User{
	private String source;
	private String Destination;
	private int fare;
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String name, String username, String password,
			String email, int mobNo, int age, String gender) {
		super(name, username, password, email, mobNo, age, gender);
		// TODO Auto-generated constructor stub
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
}
