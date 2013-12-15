package com.indra.tugas5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends Activity{
	
	static final String URL = "http://api.androidhive.info/music/music.xml";

    static final String KEY_SONG = "song"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_TITLE = "title";
    static final String KEY_ARTIST = "artist";
    static final String KEY_THUMB_URL = "thumb_url";
    
    ListView list;
    LazyAdapter adapter;
    
    ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    XMLParser parser = new XMLParser();
    
    
	
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_home);
ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
XMLParser parser = new XMLParser();
String xml = parser.getXmlFromUrl(URL);
Document doc = parser.getDomElement(xml);
NodeList nl = doc.getElementsByTagName(KEY_SONG); 
for (int i = 0; i < nl.getLength(); i++) { 
	HashMap<String, String> map = new HashMap<String, String>();
	Element e = (Element) nl.item(i); 
	map.put(KEY_ID, parser.getValue(e, KEY_ID)); 
	map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE)); 
	map.put(KEY_ARTIST, parser.getValue(e, KEY_ARTIST)); 
	//map.put(KEY_DURATION, parser.getValue(e, KEY_DURATION)); 
	map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL)); 
	songsList.add(map); 
}

list=(ListView)findViewById(R.id.list); 

adapter=new LazyAdapter(this, songsList);
list.setAdapter(adapter);

list.setOnItemClickListener(new OnItemClickListener() { 
	@Override 
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String title = (String) ((TextView)view.findViewById(R.id.title)).getText();
		String artist=(String)((TextView)view.findViewById(R.id.artist)).getText();
		Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/results?search_query="+artist+"+"+title));
		startActivity(i);
	} 
}); 
}
}
