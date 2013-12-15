package com.smtim.sqlite;

import com.smtim.sqlite.model.User;
import com.smtim.sqlite.model.Team;
import com.smtim.sqlite.model.Pesan;
import com.smtim.sqlite.model.History;
import com.smtim.sqlite.model.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class DatabaseHandler extends SQLiteOpenHelper {
	
	//Logcat tag
	private static final String LOG = DatabaseHandler.class.getName();
	
	//Database Version
	private static final int DATABASE_VERSION = 1;
	
	//Database Name
	private static final String DATABASE_NAME = "SMTiM";
	
	//Table Name
	private static final String TABLE_LOGIN = "login";
	private static final String TABLE_USER = "user";
	private static final String TABLE_TIM = "team";
	private static final String TABLE_PESAN = "pesan";
	private static final String TABLE_HISTORY = "history";
	private static final String TABLE_STATUS = "status";
	
	//USER Table - Columns
	private static final String KEY_ID = "id";
	private static final String KEY_UID = "uid";
	private static final String KEY_GCM_ID = "gcm_regid";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_NAMA = "nama";
	private static final String KEY_JUMLAH_ORANG = "jumlah_orang";
	private static final String KEY_TGL_REGISTER = "tgl_register";
	
	//TIM Table - Columns
	private static final String KEY_ANGGOTA = "anggota";
	private static final String KEY_KETUA = "ketua";
	
	//PESAN Table - Columns
	private static final String KEY_ID_PENGIRIM = "id_pengirim";
	private static final String KEY_PESAN = "pesan";
	
	//HISTORY Table - Columns
	private static final String KEY_TANGGAL = "tanggal";
	private static final String KEY_LAT = "latitude";
	private static final String KEY_LONG = "longitude";
	
	//STATUS Table - Columns
	private static final String KEY_STATUS = "status";
	private static final String KEY_LAST_UPDATE = "last_update";
	
	//Create Table
	
	//Table USER
	private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" 
			+ KEY_ID + " INTEGER PRIMARY KEY," 
			+ KEY_UID + " TEXT," 
			+ KEY_GCM_ID + " TEXT," 
			+ KEY_EMAIL + " TEXT UNIQUE,"
			+ KEY_NAMA + " TEXT,"
			+ KEY_JUMLAH_ORANG + " INTEGER,"
			+ KEY_TGL_REGISTER + " DATETIME"
			+ ")";
	
	//Table LOGIN
	private static final String CREATE_TABLE_LOGIN = "CREATE TABLE " + TABLE_LOGIN + "("
			+ KEY_ID + " INTEGER PRIMARY KEY," 
			+ KEY_UID + " TEXT," 
			+ KEY_EMAIL + " TEXT UNIQUE,"
			+ KEY_TGL_REGISTER + " DATETIME"
			+ ")";			
	
	//Table TIM
	private static final String CREATE_TABLE_TEAM = "CREATE TABLE " + TABLE_TIM + "("
			+ KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_NAMA + " TEXT UNIQUE,"
			+ KEY_ANGGOTA + " TEXT,"
			+ KEY_KETUA + " TEXT"
			+ ")";
	
	//Table PESAN
	private static final String CREATE_TABLE_PESAN = "CREATE TABLE " + TABLE_PESAN + "("
			+ KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_ID_PENGIRIM + " TEXT,"
			+ KEY_PESAN + " TEXT"
			+ ")";
	
	//Table HISTORY
	private static final String CREATE_TABLE_HISTORY = "CREATE TABLE " + TABLE_HISTORY + "("
			+ KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_TANGGAL + " DATETIME,"
			+ KEY_LAT + " DOUBLE,"
			+ KEY_LONG + " DOUBLE"
			+ ")";
	
	//Table STATUS
	private static final String CREATE_TABLE_STATUS = "CREATE TABLE " + TABLE_STATUS + "("
			+ KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_UID + " TEXT,"
			+ KEY_STATUS + " INTEGER,"
			+ KEY_LAST_UPDATE + " DATETIME"
			+ ")";

	public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_TABLE_USER);
		db.execSQL(CREATE_TABLE_LOGIN);
		db.execSQL(CREATE_TABLE_TEAM);
		db.execSQL(CREATE_TABLE_PESAN);
		db.execSQL(CREATE_TABLE_HISTORY);
		db.execSQL(CREATE_TABLE_STATUS);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		//Drop Old Table if exist
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIM);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PESAN);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATUS);
		//Create New Table
		onCreate(db);
	}
	
	// ------------------- "Login" Table method --------------//
	/**
	 * Store User detail in database Login
	 */
	public void addLoginUser(String uid, String email, String tgl_register){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_UID, uid);
		values.put(KEY_EMAIL, email);
		values.put(KEY_TGL_REGISTER, tgl_register);
		
		//Insert Row
		db.insert(TABLE_LOGIN, null, values);
		db.close();
	}
	
	/**
	 * Get User Login from database
	 */
	public HashMap<String, String> getUserLoginDetail(){
		HashMap<String, String> user = new HashMap<String, String>();
		String selectQuery = "SELECT * FROM " + TABLE_LOGIN;
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);
		//Move to first Row
		c.moveToFirst();
		if(c.getCount() > 0){
			user.put(KEY_UID, c.getString(c.getColumnIndex(KEY_UID)));
			user.put(KEY_EMAIL, c.getString(c.getColumnIndex(KEY_EMAIL)));
			user.put(KEY_TGL_REGISTER, c.getString(c.getColumnIndex(KEY_TGL_REGISTER)));
		}
		c.close();
		db.close();
		
		return user;
	}
	
	/**
	 * Get user login status
	 * return true if row are in table
	 */
	public int getRowCountUserLogin(){
		String countQuery = "SELECT * FROM " + TABLE_LOGIN;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(countQuery, null);
		int rowCount = c.getCount();
		db.close();
		c.close();
		
		return rowCount;
	}
	
	// ------------------- "User" Table method ---------------//
	/**
	 * Creating a User
	 */
	public long createUser(User user){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_UID, user.getUid());
		values.put(KEY_GCM_ID, user.getGcmRegId());
		values.put(KEY_EMAIL, user.getEmail());
		values.put(KEY_NAMA, user.getNama());
		values.put(KEY_JUMLAH_ORANG, user.getJumlahOrang());
		values.put(KEY_TGL_REGISTER, user.getTanggalRegister());
		
		//Insert Row
		long user_id = db.insert(TABLE_USER, null, values);
		
		return user_id;
	}
	
	/**
	 * Get single User
	 */
	public User getUser(String uid){
		SQLiteDatabase db = this.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE "
				+ KEY_UID + " = " + uid;
		
		Log.e(LOG, selectQuery);
		
		Cursor c = db.rawQuery(selectQuery, null);
		
		if(c != null)
			c.moveToFirst();
		
		User u = new User();
		u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
		u.setGcmRegId(c.getString(c.getColumnIndex(KEY_GCM_ID)));
		u.setUid(c.getString(c.getColumnIndex(KEY_UID)));
		u.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
		u.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
		u.setJumlahOrang(c.getInt(c.getColumnIndex(KEY_JUMLAH_ORANG)));
		u.setTanggalRegister(c.getString(c.getColumnIndex(KEY_TGL_REGISTER)));
		
		return u;
	}
	
	/**
     * Getting user data from database
     * */
    public List<User> getUserDetails(){
    	List<User> user = new ArrayList<User>();
    	String selectQuery = "SELECT  * FROM " + TABLE_USER;
    	
    	Log.e(LOG, selectQuery);
    	
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor c = db.rawQuery(selectQuery, null);
    	
    	//Looping all rows and add to list
    	if(c.moveToFirst()){
    		do {
    			User u = new User();
    			u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
    			u.setUid(c.getString(c.getColumnIndex(KEY_UID)));
    			u.setGcmRegId(c.getString(c.getColumnIndex(KEY_GCM_ID)));
    			u.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
    			u.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
    			u.setJumlahOrang(c.getInt(c.getColumnIndex(KEY_JUMLAH_ORANG)));
    			u.setTanggalRegister(c.getString(c.getColumnIndex(KEY_TGL_REGISTER)));
    			
    			//Add to Team List
    			user.add(u);
    		} while (c.moveToNext());
    	}
    	c.close();
    	
    	return user;

    }
    
    /**
     * Update Jumlah Orang
     */
    public int updateJumlahOrang(int tambah, String uid){
    	SQLiteDatabase db = this.getWritableDatabase();
    	ContentValues values = new ContentValues();
    	values.put(KEY_JUMLAH_ORANG, tambah);
    	
    	return db.update(TABLE_USER, values, KEY_UID + " = ?", new String[] { uid });
    }
    
    /**
     * Getting user login status
     * return true if rows are there in table
     */
    public int getUserRowCount(){
    	String countQuery = "SELECT * FROM " + TABLE_USER;
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.rawQuery(countQuery, null);
    	int rowCount = cursor.getCount();
    	cursor.close();
    	
    	return rowCount;
    }
	
    /**
     * Re Create table User
     * Delete all table and create again
     */
    public void resetTableUser(){
    	SQLiteDatabase db = this.getWritableDatabase();
    	//Delete All Rows
    	db.delete(TABLE_USER, null, null);
    }
    
    // ------------------ "Team" table method ----------------------//
    public long createTim(Team team){
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put(KEY_NAMA, team.getNama());
    	values.put(KEY_ANGGOTA, team.getAnggota());
    	values.put(KEY_KETUA, team.getKetua());
    	
    	long team_id = db.insert(TABLE_TIM, null, values);
    	return team_id;
    }
    
    /**
     * Getting All Anggota Tim
     */
    public List<Team> getAllAnggota(){
    	List<Team> team = new ArrayList<Team>();
    	String selectQuery = "SELECT * FROM " + TABLE_TIM;
    	
    	Log.e(LOG, selectQuery);
    	
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor c = db.rawQuery(selectQuery, null);
    	
    	//Looping all rows and add to list
    	if(c.moveToFirst()){
    		do {
    			Team t = new Team();
    			t.setId(c.getInt(c.getColumnIndex(KEY_ID)));
    			t.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
    			t.setAnggota(c.getString(c.getColumnIndex(KEY_ANGGOTA)));
    			t.setKetua(c.getString(c.getColumnIndex(KEY_KETUA)));
    			
    			//Add to Team List
    			team.add(t);
    		} while (c.moveToNext());
    	}
    	c.close();
    	
    	return team;
    	
    }
    
    /**
     * Update Ketua 
     */
    public int updateKetuaTim(String nama, String uid){
    	SQLiteDatabase db = this.getWritableDatabase();
    	ContentValues values = new ContentValues();
    	
    	values.put(KEY_UID, uid);
    	
    	//Updating Row
    	return db.update(TABLE_TIM, values, KEY_NAMA + " = ?", new String[] { nama });
    }
    
    /**
     * Delete Anggota
     */
    public void deleteAnggota(String uid){
    	SQLiteDatabase db = this.getWritableDatabase();
    	db.delete(TABLE_TIM, KEY_ANGGOTA, new String[] { uid });
    }
    
    // -------------- "Pesan" Table method ------------------------//
    public long createPesan(Pesan pesan){
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put(KEY_ID_PENGIRIM, pesan.getPengirim());
    	values.put(KEY_PESAN, pesan.getPesan());
    	
    	long id_pesan = db.insert(TABLE_PESAN, null, values);
    	
    	return id_pesan;
    	
    }
    
    /**
     * Get single pesan
     */
    public Pesan getPesan(long pesan_id){
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	String selectQuery = "SELECT * FROM " + TABLE_PESAN + " WHERE "
    			+ KEY_ID + "=" + pesan_id;
    	
    	Log.e(LOG, selectQuery);
    	
    	Cursor c = db.rawQuery(selectQuery, null);
    	if(c!=null)
    		c.moveToFirst();
    		
		Pesan p = new Pesan();
		p.setId(c.getInt(c.getColumnIndex(KEY_ID)));
		p.setPengirim(c.getString(c.getColumnIndex(KEY_ID_PENGIRIM)));
		p.setPesan(c.getString(c.getColumnIndex(KEY_PESAN)));
		
		return p;
  
    }
    
    /**
     * Get all pesan
     */
    public List<Pesan> getAllPesan(){
    	List<Pesan> pesan = new ArrayList<Pesan>();
    	String selectQuery = "SELECT * FROM " + TABLE_PESAN;
    	
    	Log.e(LOG, selectQuery);
    	
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor c = db.rawQuery(selectQuery, null);
    	
    	//Looping
    	if(c.moveToFirst()){
    		do {
    			Pesan p = new Pesan();
    			p.setId(c.getInt(c.getColumnIndex(KEY_ID)));
    			p.setPengirim(c.getString(c.getColumnIndex(KEY_ID_PENGIRIM)));
    			p.setPesan(c.getString(c.getColumnIndex(KEY_PESAN)));
    			
    			//Add to pesan
    			pesan.add(p);
    		} while(c.moveToNext());
    	}
    	
    	return pesan;
    }
        
    

}