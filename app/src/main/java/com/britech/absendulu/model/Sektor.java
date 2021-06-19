package com.britech.absendulu.model;

import com.google.gson.annotations.SerializedName;

public class Sektor{

	@SerializedName("sektors_id")
	private int sektorsId;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("longtitude")
	private double longtitude;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	public int getSektorsId(){
		return sektorsId;
	}

	public String getNama(){
		return nama;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public double getLatitude(){
		return latitude;
	}

	public double getLongtitude(){
		return longtitude;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}
}