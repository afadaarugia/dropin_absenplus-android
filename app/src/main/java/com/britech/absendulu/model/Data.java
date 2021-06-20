package com.britech.absendulu.model;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("path")
	private Path path;

	@SerializedName("expires")
	private int expires;

	@SerializedName("detail")
	private Detail detail;

	@SerializedName("user")
	private User user;

	@SerializedName("token")
	private String token;

	public void setPath(Path path){
		this.path = path;
	}

	public Path getPath(){
		return path;
	}

	public void setExpires(int expires){
		this.expires = expires;
	}

	public int getExpires(){
		return expires;
	}

	public void setDetail(Detail detail){
		this.detail = detail;
	}

	public Detail getDetail(){
		return detail;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"path = '" + path + '\'' + 
			",expires = '" + expires + '\'' + 
			",detail = '" + detail + '\'' + 
			",user = '" + user + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}