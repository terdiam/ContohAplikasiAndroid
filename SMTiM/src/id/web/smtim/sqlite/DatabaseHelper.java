package id.web.smtim.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	// Log cat TAG
	private static final String LOG = "DatabaseHelper";
	
	// Database Version
	private static final int DATABASE_VERSION = 1;
	
	// Database Name
	private static final String DATABASE_NAME = "SMTiM.db";
	
	// Table name
	private static final String TABLE_USER = "user";
	private static final String TABLE_TEAM = "team";
	private static final String TABLE_HISTORY = "history";
	private static final String TABLE_STATUS = "status";
	private static final String TABLE_PESAN = "pesan";
	
	// Common column names
	private static final String KEY_ID = "id";
	private static final String KEY_UID = "uid";
	private static final String KEY_REGID = "gcm_regid";
	private static final String KEY_NAMA = "nama";
	private static final String KEY_LAST_AKSES = "last_akses";
	
	// User Table - column names
	private static final String KEY_USER_EMAIL = "email";
	private static final String KEY_USER_JUMLAH_ORANG = "jumlah_orang";
	private static final String KEY_USER_REGISTER = "tgl_register";
	
	// Team Table - column names
	private static final String KEY_TEAM_ANGGOTA = "anggota";
	private static final String KEY_TEAM_KETUA = "ketua";
	
	// History Table - column names
	private static final String KEY_HISTORY_TANGGAL = "tanggal";
	private static final String KEY_HISTORY_LATITUDE = "latitude";
	private static final String KEY_HISTORY_LANGITUDE = "langitude";
	
	// Status Table - column names
	private static final String KEY_STATUS_STATUS = "status";
	private static final String KEY_STATUS_LAST_UPDATE = "last_update";
	
	// Pesan Table - column names
	private static final String KEY_PESAN_PENGIRIM = "id_pengirim";
	private static final String KEY_PESAN_ISI = "pesan";
	
	// Table Create Statements
	// User table create statements
	private static final String CREATE_TABLE_USER = "CREATE TABLE "
			+ TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY, "
			+ KEY_UID + " TEXT," + KEY_REGID + " TEXT," + KEY_USER_EMAIL
			+ " TEXT," + KEY_NAMA + " TEXT," + KEY_USER_JUMLAH_ORANG
			+ " INTEGER," + KEY_USER_REGISTER + " DATETIME,"
			+ KEY_LAST_AKSES + " DATETIME" + ")";
	
	private static final String CREATE_TABLE_TEAM = "CREATE TABLE "
			+ TABLE_TEAM + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_NAMA + " TEXT," + KEY_TEAM_ANGGOTA + " TEXT,"
			+ KEY_TEAM_KETUA + " TEXT" + ")";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Creating Table
		db.execSQL(CREATE_TABLE_USER);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on Upgrade Drop Older table
		db.execSQL("DROP TABLE IF EXIST " + TABLE_USER);
		
		// Create New Table
		onCreate(db);
	}
	
	// ---------------------- CRUD Function ---------------------- //
	/**
	 * Function Create User
	 */
	public long createUser(User user){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_UID, user.getUid());
		values.put(KEY_REGID, user.getRegId());
		values.put(KEY_USER_EMAIL, user.getEmail());
		values.put(KEY_NAMA, user.getNama());
		values.put(KEY_USER_JUMLAH_ORANG, user.getJumlahOrang());
		values.put(KEY_USER_REGISTER, user.getTanggalRegister());
		values.put(KEY_LAST_AKSES, user.getLastAkses());
		
		// Insert Row
		long user_id = db.insert(TABLE_USER, null, values);
		
		return user_id;
	}
	
	/**
	 * Get Single User
	 */
	public User getUser(String uid){
		SQLiteDatabase db = this.getReadableDatabase();
		
		String SelectQuery = "SELECT * FROM " + TABLE_USER + " WHERE"
				+ KEY_UID + "=" + KEY_UID;
		
		Log.e(LOG, SelectQuery);
		
		Cursor c = db.rawQuery(SelectQuery, null);
		
		if(c != null)
			c.moveToFirst();
		
		User usr = new User();
		usr.setId(c.getInt(c.getColumnIndex(KEY_ID)));
		usr.setUid(c.getString(c.getColumnIndex(KEY_UID)));
		usr.setRegId(c.getString(c.getColumnIndex(KEY_REGID)));
		usr.setEmail(c.getString(c.getColumnIndex(KEY_USER_EMAIL)));
		usr.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
		usr.setJumlahOrang(c.getInt(c.getColumnIndex(KEY_USER_JUMLAH_ORANG)));
		usr.setTanggalRegister(c.getString(c.getColumnIndex(KEY_USER_REGISTER)));
		usr.setLastAkses(c.getString(c.getColumnIndex(KEY_LAST_AKSES)));
		
		return usr;
	}
	
	/**
	 * Get All User
	 */
	public List<User> getAllUser(){
		List<User> user = new ArrayList<User>();
		String selectQuery = "SELECT * FROM " + TABLE_USER;
		
		Log.e(LOG, selectQuery);
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);
		
		// Looping all row add to list
		if(c.moveToFirst()){
			do {
				User u = new User();
				u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
				u.setUid(c.getString(c.getColumnIndex(KEY_UID)));
				u.setRegId(c.getString(c.getColumnIndex(KEY_REGID)));
				u.setEmail(c.getString(c.getColumnIndex(KEY_USER_EMAIL)));
				u.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
				u.setJumlahOrang(c.getInt(c.getColumnIndex(KEY_USER_JUMLAH_ORANG)));
				u.setTanggalRegister(c.getString(c.getColumnIndex(KEY_USER_REGISTER)));
				u.setLastAkses(c.getString(c.getColumnIndex(KEY_LAST_AKSES)));
				
				// Add to User List
				user.add(u);
			}  while (c.moveToNext());
		}
		return user;
	}
	
	/**
	 * Getting User login Status
	 * return true if row are there in table
	 */
	public int getUserRowCount(){
		String queryResult = "SELECT * FROM " + TABLE_USER;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(queryResult, null);
		int rowCount = c.getCount();
		db.close();
		c.close();
		return rowCount;
	}
	
	/**
	 * Re Create database
	 */
	public void resetTable(){
		SQLiteDatabase db = this.getWritableDatabase();
		
		//Delete all rows
		db.delete(TABLE_USER, null, null);
		db.close();
	}

}
