package com.cabshare.entity;

public class Passenger extends User{
	private int source;
	private int Destination;
	private int fare;
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String name, String username, String password,
			String email, int mobNo, int age, String gender) {
		super(name, username, password, email, mobNo, age, gender);
		// TODO Auto-generated constructor stub
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source2) {
		this.source = source2;
	}

	public int getDestination() {
		return Destination;
	}

	public void setDestination(int destination2) {
		Destination = destination2;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
}
