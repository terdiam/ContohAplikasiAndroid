package com.smtim.sqlite.model;

public class Pesan {
	int id;
	String pengirim,pesan;
	
	//Constructor
	public Pesan(){
		
	}
	
	public Pesan(String pengirim, String pesan){
		this.pengirim = pengirim;
		this.pesan = pesan;
	}
	
	public Pesan(int id, String pengirim, String pesan){
		this.id = id;
		this.pengirim = pengirim;
		this.pesan = pesan;
	}
	
	//Setter
	public void setId(int id){
		this.id = id;
	}
	
	public void setPengirim(String pengirim){
		this.pengirim = pengirim;
	}
	
	public void setPesan(String pesan){
		this.pesan = pesan;
	}
	
	//Getter
	public long getId(){
		return this.id;
	}
	
	public String getPengirim(){
		return this.pengirim;
	}
	
	public String getPesan(){
		return this.pesan;
	}
}
