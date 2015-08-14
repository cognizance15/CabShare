package com.cabshare.entity;

public class DatabaseParameters {

	private String dcn;
	private String url;
	private String user;
	private String password;
	
	public DatabaseParameters() {
		// TODO Auto-generated constructor stub
	}

	public DatabaseParameters(String dcn, String url, String user,
			String password) {
		super();
		this.dcn = dcn;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String getDcn() {
		return dcn;
	}

	public void setDcn(String dcn) {
		this.dcn = dcn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
