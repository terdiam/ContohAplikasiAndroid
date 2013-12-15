package com.smtim.sqlite.model;

public class Team {

	int id;
	String nama,anggota,ketua;
	
	//Constructor
	public Team(){
		
	}
	
	public Team(String nama, String anggota, String ketua){
		this.nama = nama;
		this.anggota = anggota;
		this.ketua = ketua;
	}
	
	public Team(int id, String nama, String anggota, String ketua){
		this.id = id;
		this.nama = nama;
		this.anggota = anggota;
		this.ketua = ketua;
	}
	
	//Setter
	public void setId(int id){
		this.id = id;
	}
	
	public void setNama(String nama){
		this.nama = nama;
	}
	
	public void setAnggota(String anggota){
		this.anggota = anggota;
	}
	
	public void setKetua(String ketua){
		this.ketua = ketua;
	}
	
	//Getter
	public long getId(){
		return this.id;
	}
	
	public String getNama(){
		return this.nama;
	}
	
	public String getAnggota(){
		return this.anggota;
	}
	
	public String getKetua(){
		return this.ketua;
	}
	
}
