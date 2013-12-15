package id.web.smtim;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import id.web.smtim.lib.JSONParser;
import id.web.smtim.sqlite.DatabaseHelper;

public class UserFunctions {
	private JSONParser jsonParser;
	
	// Server address
	private static String userUrl = "http://www.smtim.web.id/mobile/user";
	
	// JSON response node name
	public static String KEY_SUCCESS = "success";
	public static String KEY_ERROR = "error";
	public static String KEY_ERROR_MSG = "error_msg";
	public static String KEY_UID = "uid";
	public static String KEY_GCM_ID = "gcm_id";
	public static String KEY_EMAIL = "email";
	public static String KEY_NAMA = "nama";
	public static String KEY_JUMLAH_ORANG = "jumlah_orang";
	public static String KEY_TANGGAL_REGISTER = "tgl_register";
	public static String KEY_LAST_ACCESS = "last_akses";
	
	// Tag variable to post
	private static String user_login_tag = "login";
	private static String user_register_tag = "daftar";
	private static String user_update_tag = "update";
	private static String user_detail_tag = "detail";
	private static String user_update_gcmid = "update_gcm";
	
	// Constructor
	public UserFunctions(){
		jsonParser = new JSONParser();
	}
	
	/**
	 * Function to make login Request
	 * @param email
	 * @param password
	 */
	public JSONObject loginUser(String email, String password) {
		// Building parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", user_login_tag));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		JSONObject json = jsonParser.getJSONFromUrl(userUrl, params);
		
		// Return json
		// Log.e("JSON", json.toString());
		return json;
	}
	
	/**
	 * Function update GCM ID for login on other devices
	 * @param email
	 * @param gcmId
	 * @return
	 */
	public JSONObject updateGcmId(String email, String gcmId){
		// Building parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", user_update_gcmid));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("gcm_reqId", gcmId));
		JSONObject json = jsonParser.getJSONFromUrl(userUrl, params);
		
		return json;
	}
	
	/**
	 * Function Register User
	 * @param gcmId
	 * @param email
	 * @param password
	 * @param nama
	 * @param alamat
	 * @param telp
	 */
	public JSONObject registerUser(String gcmId, String email, String password, 
			String nama, String alamat, String telp){
		// Building parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", user_register_tag));
		params.add(new BasicNameValuePair("gcm_reqId", gcmId));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("nama", nama));
		params.add(new BasicNameValuePair("alamat", alamat));
		params.add(new BasicNameValuePair("notelp", telp));
		JSONObject json = jsonParser.getJSONFromUrl(userUrl, params);
		
		return json;
	}
	
	/**
	 * Function get login status
	 */
	public boolean isUserLoggedId(Context context){
		DatabaseHelper db = new DatabaseHelper(context);
		int count = db.getUserRowCount();
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Function Logout User
	 */
	public boolean logoutUser(Context context){
		DatabaseHelper db = new DatabaseHelper(context);
		db.resetTable();
		return true;
	}
}
