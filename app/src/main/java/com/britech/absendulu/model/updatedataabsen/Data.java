package com.britech.absendulu.model.updatedataabsen;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("time_in")
	private String timeIn;

	@SerializedName("id")
	private int id;

	public void setTimeIn(String timeIn){
		this.timeIn = timeIn;
	}

	public String getTimeIn(){
		return timeIn;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"time_in = '" + timeIn + '\'' +
			",id = '" + id + '\'' +
			"}";
		}
}