package com.britech.absendulu.model.responseRecognition;

import com.google.gson.annotations.SerializedName;

public class Recognition{

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