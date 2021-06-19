package com.britech.absendulu.model.bixbox;

import com.google.gson.annotations.SerializedName;

public class ResponseSendMessages{

	@SerializedName("code")
	private String code;

	@SerializedName("msgid")
	private String msgid;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setMsgid(String msgid){
		this.msgid = msgid;
	}

	public String getMsgid(){
		return msgid;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
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
			"ResponseSendMessages{" + 
			"code = '" + code + '\'' + 
			",msgid = '" + msgid + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}