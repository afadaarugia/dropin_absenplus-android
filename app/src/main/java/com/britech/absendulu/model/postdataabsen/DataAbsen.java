package com.britech.absendulu.model.postdataabsen;

import com.google.gson.annotations.SerializedName;

public class DataAbsen {

	@SerializedName("karyawans_id")
	private int karyawansId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("longtitude")
	private double longtitude;

	@SerializedName("time_in")
	private String timeIn;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

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

	public void setLongtitude(double longtitude){
		this.longtitude = longtitude;
	}

	public double getLongtitude(){
		return longtitude;
	}

	public void setTimeIn(String timeIn){
		this.timeIn = timeIn;
	}

	public String getTimeIn(){
		return timeIn;
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

	@Override
 	public String toString(){
		return 
			"DataAbsen{" +
			"karyawans_id = '" + karyawansId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",longtitude = '" + longtitude + '\'' + 
			",time_in = '" + timeIn + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}