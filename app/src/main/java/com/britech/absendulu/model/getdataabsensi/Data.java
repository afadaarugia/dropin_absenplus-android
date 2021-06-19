package com.britech.absendulu.model.getdataabsensi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data{

	@SerializedName("total_sakit")
	private int totalSakit;

	@SerializedName("total_time_in")
	private int totalTimeIn;

	@SerializedName("absensi")
	private List<AbsensiItem> absensi;

	@SerializedName("total_time_out")
	private int totalTimeOut;

	@SerializedName("total_cuti")
	private int totalCuti;

	@SerializedName("total_absen")
	private int totalAbsen;

	public void setTotalSakit(int totalSakit){
		this.totalSakit = totalSakit;
	}

	public int getTotalSakit(){
		return totalSakit;
	}

	public void setTotalTimeIn(int totalTimeIn){
		this.totalTimeIn = totalTimeIn;
	}

	public int getTotalTimeIn(){
		return totalTimeIn;
	}

	public void setAbsensi(List<AbsensiItem> absensi){
		this.absensi = absensi;
	}

	public List<AbsensiItem> getAbsensi(){
		return absensi;
	}

	public void setTotalTimeOut(int totalTimeOut){
		this.totalTimeOut = totalTimeOut;
	}

	public int getTotalTimeOut(){
		return totalTimeOut;
	}

	public void setTotalCuti(int totalCuti){
		this.totalCuti = totalCuti;
	}

	public int getTotalCuti(){
		return totalCuti;
	}

	public void setTotalAbsen(int totalAbsen){
		this.totalAbsen = totalAbsen;
	}

	public int getTotalAbsen(){
		return totalAbsen;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"total_sakit = '" + totalSakit + '\'' + 
			",total_time_in = '" + totalTimeIn + '\'' + 
			",absensi = '" + absensi + '\'' + 
			",total_time_out = '" + totalTimeOut + '\'' + 
			",total_cuti = '" + totalCuti + '\'' + 
			",total_absen = '" + totalAbsen + '\'' + 
			"}";
		}
}