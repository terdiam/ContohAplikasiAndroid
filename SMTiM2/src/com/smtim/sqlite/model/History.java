package com.smtim.sqlite.model;

public class History {
	int id;
	String tanggal;
	double latitude, longitude;
	
	//Constructor
	public History(){
		
	}
	
	public History(String tanggal, double latitude, double longitude){
		this.tanggal = tanggal;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public History(int id, String tanggal, double latitude, double longitude){
		this.id = id;
		this.tanggal = tanggal;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
}
