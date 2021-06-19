package com.britech.absendulu.model.bixbox;

import com.google.gson.annotations.SerializedName;

public class ResponseGetSendMessage{

	@SerializedName("date-deliver")
	private String dateDeliver;

	@SerializedName("code")
	private String code;

	@SerializedName("status")
	private String status;

	public void setDateDeliver(String dateDeliver){
		this.dateDeliver = dateDeliver;
	}

	public String getDateDeliver(){
		return dateDeliver;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGetSendMessage{" + 
			"date-deliver = '" + dateDeliver + '\'' + 
			",code = '" + code + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}