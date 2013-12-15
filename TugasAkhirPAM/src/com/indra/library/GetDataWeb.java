package com.indra.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Toast;


public class GetDataWeb {

public void connect()
{
    StrictMode.ThreadPolicy policy = new   
    StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

    HttpClient httpclient = new DefaultHttpClient();

    // Prepare a request object
    HttpGet httpget = new HttpGet("SERVER URL"); 

    // Execute the request
    HttpResponse response;
    try {
        response = httpclient.execute(httpget);
        // Examine the response status
        //Log.i("Info",response.getStatusLine().toString());  Comes back with HTTP/1.1 200 OK

        // Get hold of the response entity
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream instream = entity.getContent();
            String result= convertStreamToString(instream);

            JSONArray arr = new JSONArray(result);
            JSONObject jObj = arr.getJSONObject(0);
            String lat = jObj.getString("Lat");
            Log.d("OutPut", jObj.getString("Lon"));
            //Toast.makeText(this, lat, Toast.LENGTH_LONG).show();
            instream.close();
        }


    } catch (Exception e) {
        Log.e("Error",e.toString());
    }
}

    private static String convertStreamToString(InputStream is) {
    /*
     * To convert the InputStream to String we use the BufferedReader.readLine()
     * method. We iterate until the BufferedReader return null which means
     * there's no more data to read. Each line will appended to a StringBuilder
     * and returned as String.
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return sb.toString();
}

}