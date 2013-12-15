package com.smtim.sqlite.model;

public class User {
	int id,jumlah_orang;
	String uid,gcm_regid,email,nama,tgl_register;
	
	//Constructor
	public User(){
		
	}
	
	public User(String uid, String gcm_reqid, String email, String nama, int jumlah_orang, String tgl_register){
		this.uid = uid;
		this.gcm_regid = gcm_reqid;
		this.email = email;
		this.nama = nama;
		this.jumlah_orang = jumlah_orang;
		this.tgl_register = tgl_register;
	}

	public User(int id, String uid, String gcm_reqid, String email, String nama, int jumlah_orang, String tgl_register){
		this.id = id;
		this.uid = uid;
		this.gcm_regid = gcm_reqid;
		this.email = email;
		this.nama = nama;
		this.jumlah_orang = jumlah_orang;
		this.tgl_register = tgl_register;
	}
	
	//Setter
	public void setId(int id){
		this.id = id;
	}
	
	public void setUid(String uid){
		this.uid = uid;
	}
	
	public void setGcmRegId(String gcm_reqid){
		this.gcm_regid = gcm_reqid;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setNama(String nama){
		this.nama = nama;
	}
	
	public void setJumlahOrang(int jumlah_orang){
		this.jumlah_orang = jumlah_orang;
	}
	
	public void setTanggalRegister(String tgl_register){
		this.tgl_register = tgl_register;
	}
	
	//Getter
	public long getId(){
		return this.id;
	}
	
	public String getUid(){
		return this.uid;
	}
	
	public String getGcmRegId(){
		return this.gcm_regid;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getNama(){
		return this.nama;
	}
	
	public int getJumlahOrang(){
		return this.jumlah_orang;
	}
	
	public String getTanggalRegister(){
		return this.tgl_register;
	}
}
