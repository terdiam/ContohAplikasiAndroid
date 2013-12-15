package com.indra.tugas5;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class PlayList extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, HomeActivity.class);
        spec = tabHost.newTabSpec("home")
        .setIndicator("HOME", res.getDrawable(R.drawable.ic_tab_home))
        .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs

        intent = new Intent().setClass(this, AboutActivity.class);
        spec = tabHost.newTabSpec("about")
        .setIndicator("ABOUT", res.getDrawable(R.drawable.ic_tab_about))
        .setContent(intent);
        tabHost.addTab(spec);


        intent = new Intent().setClass(this, ContactActivity.class);
        spec = tabHost
        .newTabSpec("contact")
        .setIndicator("CONTACT",
        res.getDrawable(R.drawable.ic_tab_contact))
        .setContent(intent);
        tabHost.addTab(spec);

        //set tab which one you want open first time 0 or 1 or 2
        tabHost.setCurrentTab(0);

        
    }

}
