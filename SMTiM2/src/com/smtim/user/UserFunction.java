package com.smtim.user;

import com.smtim.library.JSONParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import android.util.Log;

public class UserFunction {
    private JSONParser jsonParser;
    
    private static String userURL = "http://www.smtim.web.id/mobile/user";
    private static String teamURL = "http://www.smtim.web.id/mobile/team";
    private static String historyURL = "http://www.smtim.web.id/mobile/history";
    private static String statusURL = "http://www.smtim.web.id/mobile/status";
    private static String pesanURL = "http://www.smtim.web.id/mobile/pesan";
    
    private static String loginURL = "http://www.smtim.web.id/mobile/user";
    private static String registerURL = "http://www.smtim.web.id/mobile/user";
    private static String updateLokasiURL = "http://www.smtim.web.id/mobile/user";

    //-- "User" Tag Function --//
    private static String user_login_tag = "login";
    private static String user_daftar_tag = "daftar";
    private static String user_update_tag = "update";
    private static String user_detail_tag = "detail";
    
    //-- "Team" Tag Function --//
    private static String team_buat_tag = "buat";
    private static String team_daftar_tag = "daftar";
    private static String team_list_tag = "list";
    private static String team_info_tag = "info";
    private static String team_keluar_tag = "keluar";
    
    //-- "History" Tag Function --//
    private static String history_update_tag = "update";
    private static String history_list_tag = "list";
    private static String history_detail_tag = "detail";
    
    //-- "Status" Tag Function --//
    private static String status_update_tag = "update";
    private static String status_detail_tag = "detail";
    
    //-- "Pesan" Tag Function --//
    private static String pesan_kirim_tag = "kirim";
    private static String pesan_detail_tag = "detail";
    
    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String update_lokasi = "updatelokasi";
     
    // constructor
    public UserFunction(){
        jsonParser = new JSONParser();
    }
    
    /**
     * Function User Daftar
     * @param id
     * @param latitude
     * @param longitude
     * @return
     */
    public JSONObject userDaftar(final String regId, String email, String password, String nama, String alamat, String noTelp){
    	Map<String, String> params = new HashMap<String, String>();
        params.put("tag", user_daftar_tag);
        params.put("gcm_reqId", regId);
        params.put("email", email);
        params.put("password", password);
        params.put("nama", nama);
        params.put("alamat", alamat);
        params.put("notelp", noTelp);
        
        JSONObject json = null; 
        try{
            // getting JSON Object
            json = jsonParser.getJSONFromUrl(userURL, params);
        } catch (IOException e){
        	Log.e("SMTiM", " > " + "Json: " + e);
        }
        // return json
        return json;
    	
    }
    
    /**
     * Function User Login
     * @param email
     * @param password
     * @return
     */
/*
    public JSONObject userLogin(String email, String password){
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("tag", "login"));
    	params.add(new BasicNameValuePair("email", email));
    	params.add(new BasicNameValuePair("password", password));
    	
    	// getting JSON Object
    	JSONObject json = jsonParser.getJSONFromUrl(userURL, params);
    	
    	return json;
    }
        
    public JSONObject updateLokasi(String id, String latitude, String longitude){
    	List<NameValuePair> params= new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("tag", update_lokasi));
    	params.add(new BasicNameValuePair("id", id));
    	params.add(new BasicNameValuePair("latitude", latitude));
    	params.add(new BasicNameValuePair("longitude", longitude));
    	JSONObject json = jsonParser.getJSONFromUrl(updateLokasiURL, params);
    	
    	return json;
    }
/*    
    /**
     * function make Login Request
     * @param email
     * @param password
     * */
/*    
    public JSONObject loginUser(String email, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
        // return json
        //Log.e("JSON", json.toString());
        return json;
    }
*/     
    /**
     * function make Login Request
     * @param name
     * @param email
     * @param password
     * */
  /*
    public JSONObject registerUser(String email, String password, String nama, String alamat, String no_telp){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("nama", nama));
        params.add(new BasicNameValuePair("alamat", alamat));
        params.add(new BasicNameValuePair("no_telp", no_telp));
         
        // getting JSON Object
        JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
        // return json
        return json;
    }
*/     
    /**
     * Function get Login status
     * */
/*
    public boolean isUserLoggedIn(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        int count = db.getRowCountUserLogin();
        if(count > 0){
            // user logged in
            return true;
        }
        return false;
    }
*/     
    /**
     * Function to logout user
     * Reset Database
     * */
/*
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTableUser();
        return true;
    }
*/
}
