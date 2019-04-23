package com.whgc.pojo;

public class User {
	private int id;
	private String name;
	private String email;
	private String github;
	private String avatarURL;
	private String password;
	
	public String getAvatarURL() {
		return avatarURL;
	}
	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
