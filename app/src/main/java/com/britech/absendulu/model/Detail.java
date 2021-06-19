package com.britech.absendulu.model;

import com.google.gson.annotations.SerializedName;

public class Detail{

	@SerializedName("no_telp_kel")
	private String noTelpKel;

	@SerializedName("kontrak_ke")
	private int kontrakKe;

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("tgl_mulai_kerja")
	private String tglMulaiKerja;

	@SerializedName("pendidikans")
	private Pendidikans pendidikans;

	@SerializedName("sektors_id")
	private int sektorsId;

	@SerializedName("nomor_kartu_keluarga")
	private String nomorKartuKeluarga;

	@SerializedName("users_id")
	private int usersId;

	@SerializedName("id")
	private int id;

	@SerializedName("banks_id")
	private int banksId;

	@SerializedName("awal_kontrak")
	private String awalKontrak;

	@SerializedName("sektor")
	private Sektor sektor;

	@SerializedName("banks")
	private Banks banks;

	@SerializedName("foto_ktp")
	private String fotoKtp;

	@SerializedName("jurusan")
	private String jurusan;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("statuses_id")
	private int statusesId;

	@SerializedName("foto")
	private String foto;

	@SerializedName("cost_center")
	private String costCenter;

	@SerializedName("nama_ayah")
	private String namaAyah;

	@SerializedName("statuses")
	private Statuses statuses;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("ukuran_seragam")
	private String ukuranSeragam;

	@SerializedName("atas_nama")
	private String atasNama;

	@SerializedName("jumlah_anak")
	private String jumlahAnak;

	@SerializedName("akhir_kontrak")
	private String akhirKontrak;

	@SerializedName("foto_kk")
	private String fotoKk;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("gol_darahs")
	private GolDarahs golDarahs;

	@SerializedName("units")
	private Units units;

	@SerializedName("jen_kel")
	private String jenKel;

	@SerializedName("nomor_npwp")
	private String nomorNpwp;

	@SerializedName("kota_lahir")
	private String kotaLahir;

	@SerializedName("nik_ta")
	private int nikTa;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("no_ktp")
	private String noKtp;

	@SerializedName("agamas")
	private Agamas agamas;

	@SerializedName("nama_lembaga")
	private String namaLembaga;

	@SerializedName("email")
	private String email;

	@SerializedName("pendidikans_id")
	private int pendidikansId;

	@SerializedName("no_rek")
	private long noRek;

	@SerializedName("name_posisions_id")
	private int namePosisionsId;

	@SerializedName("agamas_id")
	private int agamasId;

	@SerializedName("no_bpjs_ketenagakerjaan")
	private String noBpjsKetenagakerjaan;

	@SerializedName("gol_darahs_id")
	private int golDarahsId;

	@SerializedName("tgl_lahir")
	private String tglLahir;

	@SerializedName("keterangan_aktif")
	private String keteranganAktif;

	@SerializedName("nama_keluarga")
	private String namaKeluarga;

	@SerializedName("name_posisions")
	private NamePosisions namePosisions;

	@SerializedName("nama_ibu_kandung")
	private String namaIbuKandung;

	@SerializedName("units_id")
	private int unitsId;

	@SerializedName("nik_bistel")
	private int nikBistel;

	@SerializedName("suku")
	private String suku;

	@SerializedName("status_pernikahan")
	private String statusPernikahan;

	@SerializedName("no_bpjs_kesehatan")
	private String noBpjsKesehatan;

	public void setNoTelpKel(String noTelpKel){
		this.noTelpKel = noTelpKel;
	}

	public String getNoTelpKel(){
		return noTelpKel;
	}

	public void setKontrakKe(int kontrakKe){
		this.kontrakKe = kontrakKe;
	}

	public int getKontrakKe(){
		return kontrakKe;
	}

	public void setNamaLengkap(String namaLengkap){
		this.namaLengkap = namaLengkap;
	}

	public String getNamaLengkap(){
		return namaLengkap;
	}

	public void setTglMulaiKerja(String tglMulaiKerja){
		this.tglMulaiKerja = tglMulaiKerja;
	}

	public String getTglMulaiKerja(){
		return tglMulaiKerja;
	}

	public void setPendidikans(Pendidikans pendidikans){
		this.pendidikans = pendidikans;
	}

	public Pendidikans getPendidikans(){
		return pendidikans;
	}

	public void setSektorsId(int sektorsId){
		this.sektorsId = sektorsId;
	}

	public int getSektorsId(){
		return sektorsId;
	}

	public void setNomorKartuKeluarga(String nomorKartuKeluarga){
		this.nomorKartuKeluarga = nomorKartuKeluarga;
	}

	public String getNomorKartuKeluarga(){
		return nomorKartuKeluarga;
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

	public void setBanksId(int banksId){
		this.banksId = banksId;
	}

	public int getBanksId(){
		return banksId;
	}

	public void setAwalKontrak(String awalKontrak){
		this.awalKontrak = awalKontrak;
	}

	public String getAwalKontrak(){
		return awalKontrak;
	}

	public void setSektor(Sektor sektor){
		this.sektor = sektor;
	}

	public Sektor getSektor(){
		return sektor;
	}

	public void setBanks(Banks banks){
		this.banks = banks;
	}

	public Banks getBanks(){
		return banks;
	}

	public void setFotoKtp(String fotoKtp){
		this.fotoKtp = fotoKtp;
	}

	public String getFotoKtp(){
		return fotoKtp;
	}

	public void setJurusan(String jurusan){
		this.jurusan = jurusan;
	}

	public String getJurusan(){
		return jurusan;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
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

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setCostCenter(String costCenter){
		this.costCenter = costCenter;
	}

	public String getCostCenter(){
		return costCenter;
	}

	public void setNamaAyah(String namaAyah){
		this.namaAyah = namaAyah;
	}

	public String getNamaAyah(){
		return namaAyah;
	}

	public void setStatuses(Statuses statuses){
		this.statuses = statuses;
	}

	public Statuses getStatuses(){
		return statuses;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setUkuranSeragam(String ukuranSeragam){
		this.ukuranSeragam = ukuranSeragam;
	}

	public String getUkuranSeragam(){
		return ukuranSeragam;
	}

	public void setAtasNama(String atasNama){
		this.atasNama = atasNama;
	}

	public String getAtasNama(){
		return atasNama;
	}

	public void setJumlahAnak(String jumlahAnak){
		this.jumlahAnak = jumlahAnak;
	}

	public String getJumlahAnak(){
		return jumlahAnak;
	}

	public void setAkhirKontrak(String akhirKontrak){
		this.akhirKontrak = akhirKontrak;
	}

	public String getAkhirKontrak(){
		return akhirKontrak;
	}

	public void setFotoKk(String fotoKk){
		this.fotoKk = fotoKk;
	}

	public String getFotoKk(){
		return fotoKk;
	}

	public void setCreatedAt(Object createdAt){
		this.createdAt = createdAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public void setGolDarahs(GolDarahs golDarahs){
		this.golDarahs = golDarahs;
	}

	public GolDarahs getGolDarahs(){
		return golDarahs;
	}

	public void setUnits(Units units){
		this.units = units;
	}

	public Units getUnits(){
		return units;
	}

	public void setJenKel(String jenKel){
		this.jenKel = jenKel;
	}

	public String getJenKel(){
		return jenKel;
	}

	public void setNomorNpwp(String nomorNpwp){
		this.nomorNpwp = nomorNpwp;
	}

	public String getNomorNpwp(){
		return nomorNpwp;
	}

	public void setKotaLahir(String kotaLahir){
		this.kotaLahir = kotaLahir;
	}

	public String getKotaLahir(){
		return kotaLahir;
	}

	public void setNikTa(int nikTa){
		this.nikTa = nikTa;
	}

	public int getNikTa(){
		return nikTa;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNoKtp(String noKtp){
		this.noKtp = noKtp;
	}

	public String getNoKtp(){
		return noKtp;
	}

	public void setAgamas(Agamas agamas){
		this.agamas = agamas;
	}

	public Agamas getAgamas(){
		return agamas;
	}

	public void setNamaLembaga(String namaLembaga){
		this.namaLembaga = namaLembaga;
	}

	public String getNamaLembaga(){
		return namaLembaga;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPendidikansId(int pendidikansId){
		this.pendidikansId = pendidikansId;
	}

	public int getPendidikansId(){
		return pendidikansId;
	}

	public void setNoRek(long noRek){
		this.noRek = noRek;
	}

	public long getNoRek(){
		return noRek;
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

	public void setNoBpjsKetenagakerjaan(String noBpjsKetenagakerjaan){
		this.noBpjsKetenagakerjaan = noBpjsKetenagakerjaan;
	}

	public String getNoBpjsKetenagakerjaan(){
		return noBpjsKetenagakerjaan;
	}

	public void setGolDarahsId(int golDarahsId){
		this.golDarahsId = golDarahsId;
	}

	public int getGolDarahsId(){
		return golDarahsId;
	}

	public void setTglLahir(String tglLahir){
		this.tglLahir = tglLahir;
	}

	public String getTglLahir(){
		return tglLahir;
	}

	public void setKeteranganAktif(String keteranganAktif){
		this.keteranganAktif = keteranganAktif;
	}

	public String getKeteranganAktif(){
		return keteranganAktif;
	}

	public void setNamaKeluarga(String namaKeluarga){
		this.namaKeluarga = namaKeluarga;
	}

	public String getNamaKeluarga(){
		return namaKeluarga;
	}

	public void setNamePosisions(NamePosisions namePosisions){
		this.namePosisions = namePosisions;
	}

	public NamePosisions getNamePosisions(){
		return namePosisions;
	}

	public void setNamaIbuKandung(String namaIbuKandung){
		this.namaIbuKandung = namaIbuKandung;
	}

	public String getNamaIbuKandung(){
		return namaIbuKandung;
	}

	public void setUnitsId(int unitsId){
		this.unitsId = unitsId;
	}

	public int getUnitsId(){
		return unitsId;
	}

	public void setNikBistel(int nikBistel){
		this.nikBistel = nikBistel;
	}

	public int getNikBistel(){
		return nikBistel;
	}

	public void setSuku(String suku){
		this.suku = suku;
	}

	public String getSuku(){
		return suku;
	}

	public void setStatusPernikahan(String statusPernikahan){
		this.statusPernikahan = statusPernikahan;
	}

	public String getStatusPernikahan(){
		return statusPernikahan;
	}

	public void setNoBpjsKesehatan(String noBpjsKesehatan){
		this.noBpjsKesehatan = noBpjsKesehatan;
	}

	public String getNoBpjsKesehatan(){
		return noBpjsKesehatan;
	}
}