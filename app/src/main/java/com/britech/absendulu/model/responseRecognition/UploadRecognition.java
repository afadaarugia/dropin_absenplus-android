package com.britech.absendulu.model.responseRecognition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadRecognition {

	@SerializedName("foto_recognition")
	private String fotoRecognition;

	@SerializedName("users_id")
	private String usersId;

	@SerializedName("foto_upload")
	private String fotoUpload;

	@SerializedName("msg")
	private String msg;

	@SerializedName("similiarity")
	private String similiarity;

	@SerializedName("tes")
	private String tes;

	public String getOk() {
		return tes;
	}

	public void setOk(String ok) {
		this.tes = ok;
	}


	public void setFotoRecognition(String fotoRecognition){
		this.fotoRecognition = fotoRecognition;
	}

	public String getFotoRecognition(){
		return fotoRecognition;
	}

//	public void setRecognition(Recognition recognition){
//		this.recognition = recognition;
//	}
//
//	public Recognition getRecognition(){
//		return recognition;
//	}

	public void setUsersId(String usersId){
		this.usersId = usersId;
	}

	public String getUsersId(){
		return usersId;
	}

	public void setFotoUpload(String fotoUpload){
		this.fotoUpload = fotoUpload;
	}

	public String getFotoUpload(){
		return fotoUpload;
	}

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