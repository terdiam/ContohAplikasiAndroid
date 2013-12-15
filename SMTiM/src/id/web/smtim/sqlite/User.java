package id.web.smtim.sqlite;

public class User {
	int _id,_jml_org;
	String _uid,_regId,_email,_nama,_tgl_register,_last_akses;
	
	// Constructor
	public User(){
		
	}
	
	public User(String uid,String regId,String email, String nama, int jml_org, String tgl_register, String last_akses){
		this._uid = uid;
		this._regId = regId;
		this._email = email;
		this._nama = nama;
		this._jml_org = jml_org;
		this._tgl_register = tgl_register;
		this._last_akses = last_akses;
	}
	
	public User(int id,String uid,String regId,String email, String nama, int jml_org, String tgl_register, String last_akses){
		this._id = id;
		this._uid = uid;
		this._regId = regId;
		this._email = email;
		this._nama = nama;
		this._jml_org = jml_org;
		this._tgl_register = tgl_register;
		this._last_akses = last_akses;
	}
	
	//Setter
	public void setId(int id){
		this._id = id;
	}
	
	public void setUid(String uid){
		this._uid = uid;
	}
	
	public void setRegId(String regId){
		this._regId = regId;
	}
	
	public void setEmail(String email){
		this._email = email;
	}
	
	public void setNama(String nama){
		this._nama = nama;
	}
	
	public void setJumlahOrang(int jumlah_orang){
		this._jml_org = jumlah_orang;
	}
	
	public void setTambahOrang(int tambah){
		this._jml_org = this._jml_org + tambah;
	}
	
	public void setTanggalRegister(String tanggal_register){
		this._tgl_register = tanggal_register;
	}
	
	public void setLastAkses(String last_akses){
		this._last_akses = last_akses;
	}
	
	// Getter
	public long getId(){
		return this._id;
	}
	
	public String getUid(){
		return this._uid;
	}
	
	public String getRegId(){
		return this._regId;
	}
	
	public String getEmail(){
		return this._email;
	}
	
	public String getNama(){
		return this._nama;
	}
	
	public int getJumlahOrang(){
		return this._jml_org;
	}
	
	public String getTanggalRegister(){
		return this._tgl_register;
	}
	
	public String getLastAkses(){
		return this._last_akses;
	}
	
}
