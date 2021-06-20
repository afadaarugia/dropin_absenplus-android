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

	public void setGajiPokok(Object gajiPokok){
		this.gajiPokok = gajiPokok;
	}

	public Object getGajiPokok(){
		return gajiPokok;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public void setLevelsId(int levelsId){
		this.levelsId = levelsId;
	}

	public int getLevelsId(){
		return levelsId;
	}

	public void setTunjJabatan(Object tunjJabatan){
		this.tunjJabatan = tunjJabatan;
	}

	public Object getTunjJabatan(){
		return tunjJabatan;
	}

	@Override
 	public String toString(){
		return 
			"NamePosisions{" + 
			"gaji_pokok = '" + gajiPokok + '\'' + 
			",nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",levels_id = '" + levelsId + '\'' + 
			",tunj_jabatan = '" + tunjJabatan + '\'' + 
			"}";
		}
}