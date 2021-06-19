package com.britech.absendulu.model.cekAbsen;

import com.google.gson.annotations.SerializedName;

public class ResponseCekAbsen{

	@SerializedName("data")
	private CekAbsen data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(CekAbsen cekAbsen){
		this.data = cekAbsen;
	}

	public CekAbsen getData(){
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
			"ResponseCekAbsen{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}