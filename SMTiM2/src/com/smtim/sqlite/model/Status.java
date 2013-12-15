package com.smtim.sqlite.model;

public class Status {
	int id;
	String uid,status,last_update;
	
	//Constructor
	public Status(){
		
	}
	
	public Status(String uid, String status, String last_update){
		this.uid = uid;
		this.status = status;
		this.last_update = last_update;
	}
	
	public Status(int id, String uid, String status, String last_update){
		this.id = id;
		this.uid = uid;
		this.status = status;
		this.last_update = last_update;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	
	
}
