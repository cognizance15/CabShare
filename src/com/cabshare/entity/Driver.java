package com.cabshare.entity;

public class Driver extends User {
	
	private String position;
	private int seats;
	
	public Driver() {

	}

	public Driver(String name, String username, String password, String email,
			int mobNo, int age, String gender) {
		super(name, username, password, email, mobNo, age, gender);
	}

	public Driver(String name, String username, String password, String email,
			int mobNo, int age, String gender, String position, int seats) {
		super(name, username, password, email, mobNo, age, gender);
		this.position = position;
		this.seats = seats;
	}

	public String getPosition() {
		return position;
	}

	public int getSeats() {
		return seats;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	

}
