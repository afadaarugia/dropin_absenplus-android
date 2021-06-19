package com.britech.absendulu.model.uploadRecognition;

import com.google.gson.annotations.SerializedName;

public class ResponseMyFoto{

	@SerializedName("data")
	private MyFotoRecog myFotoRecog;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public MyFotoRecog getData(){
		return myFotoRecog;
	}

	public boolean isSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}
}