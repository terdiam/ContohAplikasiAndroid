package com.tugas.mygalery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MakananTradisional extends Activity {
	final private Activity activity = this;
	
	private Button btnMakananTradisionalBack, btnMakananTradisionalLihat;
	private RadioButton rdoMakananTradisionalBuburTinutuan, rdoMakananTradisionalTempoyak, 
	rdoMakananTradisionalIkanArsik, rdoMakananTradisionalSateAmbal, rdoMakananTradisionalHorokHorok;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.makanan_tradisional);
		
		btnMakananTradisionalLihat = (Button)findViewById(R.id.btnMakananTradisionalLihat);
		btnMakananTradisionalBack = (Button)findViewById(R.id.btnMakananTradisionalBack);
		
		rdoMakananTradisionalBuburTinutuan = (RadioButton)findViewById(R.id.rdoMakananTradisionalBuburTinutuan);
		rdoMakananTradisionalTempoyak = (RadioButton)findViewById(R.id.rdoMakananTradisionalTempoyak);
		rdoMakananTradisionalIkanArsik = (RadioButton)findViewById(R.id.rdoMakananTradisionalIkanArsik);
		rdoMakananTradisionalSateAmbal = (RadioButton)findViewById(R.id.rdoMakananTradisionalSateAmbal);
		rdoMakananTradisionalHorokHorok = (RadioButton)findViewById(R.id.rdoMakananTradisionalHorokHorok);
		
		btnMakananTradisionalBack.setOnClickListener(new keluar());
		btnMakananTradisionalLihat.setOnClickListener(new baca());
		
	}

	private class keluar implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

	private class baca implements Button.OnClickListener{
		public void onClick(View v){
			Intent i;
			i = new Intent(activity, MyBrowser.class);
			if (rdoMakananTradisionalBuburTinutuan.isChecked())
				i.putExtra("nama_file", "buburtinutuan");
    		if (rdoMakananTradisionalTempoyak.isChecked())
				i.putExtra("nama_file", "tempoyak");
    		if (rdoMakananTradisionalIkanArsik.isChecked())
				i.putExtra("nama_file", "ikanarsik");
    		if (rdoMakananTradisionalSateAmbal.isChecked())
				i.putExtra("nama_file", "sateambal");
    		if (rdoMakananTradisionalHorokHorok.isChecked())
				i.putExtra("nama_file", "horokhorok");
			
			startActivity(i);
		}
	}
	
}
