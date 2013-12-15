package com.indra.tugas5;

import java.util.ArrayList;
import java.util.HashMap;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {

	private Activity activity;
    private  ArrayList<HashMap<String, String>> data ;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
 
    public LazyAdapter( Activity a, ArrayList<HashMap<String, String>> d ) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }
    
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);
 
        TextView title = (TextView)vi.findViewById(R.id.title);
        TextView artist = (TextView)vi.findViewById(R.id.artist);
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image);
 
        HashMap<String, String> song = new HashMap<String, String>(); 
        song = data.get(position);
 
        title.setText(song.get(HomeActivity.KEY_TITLE));
        artist.setText(song.get(HomeActivity.KEY_ARTIST));
        imageLoader.DisplayImage(song.get(HomeActivity.KEY_THUMB_URL), thumb_image);
        return vi;
    }

}
