package com.smtim.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
 
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
 
public class JSONParser {
 
    static JSONObject jObj = null;
    static String json = "";
 
    // constructor
    public JSONParser() {
 
    }
 
    public JSONObject getJSONFromUrl(String endpoint, Map<String, String> params) throws IOException {
    	
    	URL url;
    	try{
    		url = new URL(endpoint);
    	} catch (MalformedURLException e){
    		throw new IllegalArgumentException("Invalid url: " + endpoint);
    	}
    	
    	StringBuilder bodyBuilder = new StringBuilder();
    	Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
    	while(iterator.hasNext()){
    		Entry<String, String> param = iterator.next();
    		bodyBuilder.append(param.getKey()).append('=').append(param.getValue());
    		if (iterator.hasNext()) {
    			bodyBuilder.append('&');
    		}
    	}
    	String body = bodyBuilder.toString();
    	Log.v("SMTiM ", "Posting '" + body + "' to " + url);
    	byte[] bytes = body.getBytes();
    	HttpURLConnection conn = null;
    	
    	try {
            Log.e("URL", "> " + url);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setFixedLengthStreamingMode(bytes.length);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");
            // post the request
            OutputStream out = conn.getOutputStream();
            out.write(bytes);
            out.close();
            // handle the response
            int status = conn.getResponseCode();
            if (status != 200) {
              throw new IOException("Post failed with error code " + status);
            }
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

 
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
            		conn.getInputStream(), "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "n");
            }
            reader.close();
            json = sb.toString();
            Log.e("JSON", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);           
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
 
        // return JSON String
        return jObj;
 
    }
}