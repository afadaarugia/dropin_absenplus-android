package com.britech.absendulu.model.responseRecognition;

import com.google.gson.annotations.SerializedName;

public class ResponseRecognition{

	@SerializedName("data")
	private UploadRecognition data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(UploadRecognition uploadRecognition){
		this.data = uploadRecognition;
	}

	public UploadRecognition getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}