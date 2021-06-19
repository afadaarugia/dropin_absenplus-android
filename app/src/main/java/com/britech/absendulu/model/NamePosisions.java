package com.britech.absendulu.model;

import com.google.gson.annotations.SerializedName;

public class NamePosisions{

	@SerializedName("gaji_pokok")
	private Object gajiPokok;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("levels_id")
	private int levelsId;

	@SerializedName("tunj_jabatan")
	private Object tunjJabatan;

	public Object getGajiPokok(){
		return gajiPokok;
	}

	public String getNama(){
		return nama;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public int getLevelsId(){
		return levelsId;
	}

	public Object getTunjJabatan(){
		return tunjJabatan;
	}
}