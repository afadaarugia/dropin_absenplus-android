package com.britech.absendulu.model.postdataabsen;

import com.google.gson.annotations.SerializedName;

public class ResponseDataAbsen{

	@SerializedName("data")
	private DataAbsen data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(DataAbsen data){
		this.data = data;
	}

	public DataAbsen getData(){
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

	@Override
 	public String toString(){
		return 
			"ResponseDataAbsen{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}