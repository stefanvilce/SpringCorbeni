package com.irisoft.corbeni.model;

public class User {
	private int id;  
    private String username;
    private String password;
    private int activ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getActiv() {
		return activ;
	}
	public void setActiv(int activ) {
		this.activ = activ;
	}
}
