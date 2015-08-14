package com.cabshare.entity;

public class User {

	private String name;
	private String username;
	private String password;
	private String email;
	private int mobNo;
	private int age;
	private String gender;
	private String type;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	public User(String name, String username, String password, String email,
			int mobNo, int age, String gender) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobNo = mobNo;
		this.age = age;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobNo() {
		return mobNo;
	}

	public void setMobNo(int mobNo) {
		this.mobNo = mobNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password="
				+ password + ", email=" + email + ", mobNo=" + mobNo + ", age="
				+ age + ", gender=" + gender + "]";
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
}
