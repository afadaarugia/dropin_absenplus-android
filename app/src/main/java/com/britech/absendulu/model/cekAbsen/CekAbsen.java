package com.britech.absendulu.model.cekAbsen;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CekAbsen {

	@SerializedName("karyawans_id")
	private int karyawansId;

	@SerializedName("keterangan")
	private Object keterangan;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("time_in")
	private Date timeIn;

	@SerializedName("longtitude")
	private double longtitude;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("time_out")
	private Date timeOut;

	public void setKaryawansId(int karyawansId){
		this.karyawansId = karyawansId;
	}

	public int getKaryawansId(){
		return karyawansId;
	}

	public void setKeterangan(Object keterangan){
		this.keterangan = keterangan;
	}

	public Object getKeterangan(){
		return keterangan;
	}

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setTimeIn(Date timeIn){
		this.timeIn = timeIn;
	}

	public Date getTimeIn(){
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

	public void setTimeOut(Date timeOut){
		this.timeOut = timeOut;
	}

	public Date getTimeOut(){
		return timeOut;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"karyawans_id = '" + karyawansId + '\'' + 
			",keterangan = '" + keterangan + '\'' + 
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