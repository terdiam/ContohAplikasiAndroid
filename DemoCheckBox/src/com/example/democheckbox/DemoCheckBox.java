package com.example.democheckbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DemoCheckBox extends Activity {

	TextView hasil;
	Button pilih;
	CheckBox cb1, cb2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        cb1 = (CheckBox) findViewById(R.id.chkHobi1);
        cb2 = (CheckBox) findViewById(R.id.chkHobi2);
        hasil = (TextView) findViewById(R.id.txtHasil);
        pilih = (Button) findViewById(R.id.btnPilih);
        pilih.setOnClickListener(new klik());
    }
    class klik implements Button.OnClickListener
    {
    	public void onClick(View v)
    	{
    		String a="";
    		if (cb1.isChecked())
    			a=a+"- "+cb1.getText()+"\n";
    		if(cb2.isChecked())
    			a=a+"- "+cb2.getText()+"\n";
    		if (a.equals("")) a="hadew.. diluar pilihan diatas!";
    		
    		hasil.setText("Anda memiliki Hobi:\n"+a);
    	}
    }
   }
