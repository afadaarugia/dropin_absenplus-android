package com.britech.absendulu.model.jamAbsen;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Data{
	@SerializedName("awal_pagi_akhir")
	private Date awalPagiAkhir;

	@SerializedName("awal_sore_awal")
	private Date awalSoreAwal;

	@SerializedName("awal_pagi_awal")
	private Date awalPagiAwal;

	@SerializedName("awal_sore_akhir")

	private Date awalSoreAkhir;

	public Date getAwalPagiAkhir(){
		return awalPagiAkhir;
	}

	public Date getAwalSoreAwal(){
		return awalSoreAwal;
	}

	public Date getAwalPagiAwal(){
		return awalPagiAwal;
	}

	public Date getAwalSoreAkhir(){
		return awalSoreAkhir;
	}

	public void setAwalPagiAkhir(Date awalPagiAkhir) {
		this.awalPagiAkhir = awalPagiAkhir;
	}

	public void setAwalSoreAwal(Date awalSoreAwal) {
		this.awalSoreAwal = awalSoreAwal;
	}

	public void setAwalPagiAwal(Date awalPagiAwal) {
		this.awalPagiAwal = awalPagiAwal;
	}

	public void setAwalSoreAkhir(Date awalSoreAkhir) {
		this.awalSoreAkhir = awalSoreAkhir;
	}
}