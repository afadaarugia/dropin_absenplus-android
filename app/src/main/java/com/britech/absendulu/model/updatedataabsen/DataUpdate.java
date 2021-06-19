package com.britech.absendulu.model.updatedataabsen;

import com.google.gson.annotations.SerializedName;

public class DataUpdate {

	@SerializedName("karyawans_id")
	private int karyawansId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("time_in")
	private String timeIn;

	@SerializedName("longtitude")
	private double longtitude;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("time_out")
	private String timeOut;

	public void setKaryawansId(int karyawansId){
		this.karyawansId = karyawansId;
	}

	public int getKaryawansId(){
		return karyawansId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setTimeIn(String timeIn){
		this.timeIn = timeIn;
	}

	public String getTimeIn(){
		return timeIn;
	}

	public void setLongtitude(double longtitude){
		this.longtitude = longtitude;
	}

	public double getLongtitude(){
		return longtitude;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setTimeOut(String timeOut){
		this.timeOut = timeOut;
	}

	public String getTimeOut(){
		return timeOut;
	}

	@Override
 	public String toString(){
		return 
			"DataUpdate{" +
			"karyawans_id = '" + karyawansId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",time_in = '" + timeIn + '\'' + 
			",longtitude = '" + longtitude + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",time_out = '" + timeOut + '\'' + 
			"}";
		}
}