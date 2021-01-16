package com.escola.model;

public class User {
	
	private String login;
	private String name;
	private String pwd;
	
	public User(String login, String name, String pwd) {
		super();
		this.login = login;
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
