package com.britech.absendulu.model.getdataabsensi;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class AbsensiItem{

	@SerializedName("karyawans_id")
	private int karyawansId;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("latitude")
	private Object latitude;

	@SerializedName("time_in")
	private Date timeIn;

	@SerializedName("longtitude")
	private Object longtitude;

	@SerializedName("created_at")
	private Date createdAt;

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

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setLatitude(Object latitude){
		this.latitude = latitude;
	}

	public Object getLatitude(){
		return latitude;
	}

	public void setTimeIn(Date timeIn){
		this.timeIn = timeIn;
	}

	public Date getTimeIn(){
		return timeIn;
	}

	public void setLongtitude(Object longtitude){
		this.longtitude = longtitude;
	}

	public Object getLongtitude(){
		return longtitude;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
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
			"AbsensiItem{" + 
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