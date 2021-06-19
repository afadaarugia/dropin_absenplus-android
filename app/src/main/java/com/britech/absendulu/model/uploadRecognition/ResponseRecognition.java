package com.britech.absendulu.model.uploadRecognition;

import com.google.gson.annotations.SerializedName;

public class ResponseRecognition{

	@SerializedName("msg")
	private String msg;

	@SerializedName("similiarity")
	private String similiarity;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setSimiliarity(String similiarity){
		this.similiarity = similiarity;
	}

	public String getSimiliarity(){
		return similiarity;
	}
}