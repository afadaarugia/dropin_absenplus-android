package com.britech.absendulu.model.updatedataabsen;

import com.google.gson.annotations.SerializedName;

public class ResponseUpdateDataAbsen{

	@SerializedName("data")
	private DataUpdate data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(DataUpdate data){
		this.data = data;
	}

	public DataUpdate getData(){
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
			"ResponseUpdateDataAbsen{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}