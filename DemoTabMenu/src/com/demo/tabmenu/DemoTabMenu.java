package com.demo.tabmenu;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.TabHost;

public class DemoTabMenu extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost(); // The activity TabHost
        TabHost.TabSpec spec; // Resusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, CowokActivity.class);
        
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("cowok").setIndicator("Cowok",
        res.getDrawable(R.drawable.ic_tab_cowok))
        .setContent(intent);
        tabHost.addTab(spec);
        
        // Do the same for the other tabs
        intent = new Intent().setClass(this, CewekActivity.class);
        spec = tabHost.newTabSpec("cewek").setIndicator("Cewek",
        res.getDrawable(R.drawable.ic_tab_cewek))
        .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, JilbabActivity.class);
        spec = tabHost.newTabSpec("jilbab").setIndicator("Jilbab",
        res.getDrawable(R.drawable.ic_tab_jilbab))
        .setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(3);
    }
}