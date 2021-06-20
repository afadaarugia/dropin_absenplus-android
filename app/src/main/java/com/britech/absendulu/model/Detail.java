package com.britech.absendulu.model;

import com.google.gson.annotations.SerializedName;

public class Detail{

	@SerializedName("sektor")
	private Sektor sektor;

	@SerializedName("name_posisions_id")
	private int namePosisionsId;

	@SerializedName("agamas_id")
	private int agamasId;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("jen_kel")
	private String jenKel;

	@SerializedName("tgl_lahir")
	private String tglLahir;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("statuses_id")
	private int statusesId;

	@SerializedName("nik")
	private int nik;

	@SerializedName("kota_lahir")
	private String kotaLahir;

	@SerializedName("keterangan_aktif")
	private String keteranganAktif;

	@SerializedName("sektors_id")
	private int sektorsId;

	@SerializedName("foto")
	private String foto;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name_posisions")
	private NamePosisions namePosisions;

	@SerializedName("units_id")
	private int unitsId;

	@SerializedName("users_id")
	private int usersId;

	@SerializedName("id")
	private int id;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("agamas")
	private Agamas agamas;

	@SerializedName("email")
	private String email;

	public void setSektor(Sektor sektor){
		this.sektor = sektor;
	}

	public Sektor getSektor(){
		return sektor;
	}

	public void setNamePosisionsId(int namePosisionsId){
		this.namePosisionsId = namePosisionsId;
	}

	public int getNamePosisionsId(){
		return namePosisionsId;
	}

	public void setAgamasId(int agamasId){
		this.agamasId = agamasId;
	}

	public int getAgamasId(){
		return agamasId;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
	}

	public void setCreatedAt(Object createdAt){
		this.createdAt = createdAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setJenKel(String jenKel){
		this.jenKel = jenKel;
	}

	public String getJenKel(){
		return jenKel;
	}

	public void setTglLahir(String tglLahir){
		this.tglLahir = tglLahir;
	}

	public String getTglLahir(){
		return tglLahir;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setStatusesId(int statusesId){
		this.statusesId = statusesId;
	}

	public int getStatusesId(){
		return statusesId;
	}

	public void setNik(int nik){
		this.nik = nik;
	}

	public int getNik(){
		return nik;
	}

	public void setKotaLahir(String kotaLahir){
		this.kotaLahir = kotaLahir;
	}

	public String getKotaLahir(){
		return kotaLahir;
	}

	public void setKeteranganAktif(String keteranganAktif){
		this.keteranganAktif = keteranganAktif;
	}

	public String getKeteranganAktif(){
		return keteranganAktif;
	}

	public void setSektorsId(int sektorsId){
		this.sektorsId = sektorsId;
	}

	public int getSektorsId(){
		return sektorsId;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNamePosisions(NamePosisions namePosisions){
		this.namePosisions = namePosisions;
	}

	public NamePosisions getNamePosisions(){
		return namePosisions;
	}

	public void setUnitsId(int unitsId){
		this.unitsId = unitsId;
	}

	public int getUnitsId(){
		return unitsId;
	}

	public void setUsersId(int usersId){
		this.usersId = usersId;
	}

	public int getUsersId(){
		return usersId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setAgamas(Agamas agamas){
		this.agamas = agamas;
	}

	public Agamas getAgamas(){
		return agamas;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Detail{" + 
			"sektor = '" + sektor + '\'' + 
			",name_posisions_id = '" + namePosisionsId + '\'' + 
			",agamas_id = '" + agamasId + '\'' + 
			",nama_lengkap = '" + namaLengkap + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",jen_kel = '" + jenKel + '\'' + 
			",tgl_lahir = '" + tglLahir + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",statuses_id = '" + statusesId + '\'' + 
			",nik = '" + nik + '\'' + 
			",kota_lahir = '" + kotaLahir + '\'' + 
			",keterangan_aktif = '" + keteranganAktif + '\'' + 
			",sektors_id = '" + sektorsId + '\'' + 
			",foto = '" + foto + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",name_posisions = '" + namePosisions + '\'' + 
			",units_id = '" + unitsId + '\'' + 
			",users_id = '" + usersId + '\'' + 
			",id = '" + id + '\'' + 
			",no_telp = '" + noTelp + '\'' + 
			",agamas = '" + agamas + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}