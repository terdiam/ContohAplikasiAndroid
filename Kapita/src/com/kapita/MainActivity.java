package com.kapita;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

	EditText edtPanjang, edtLebar;
	TextView txtResult;
	Button btnHasil, btnClear, btnKeluar;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtPanjang = (EditText)findViewById(R.id.edtPanjang);
		edtLebar = (EditText)findViewById(R.id.edtLebar);
		btnClear = (Button)findViewById(R.id.btnClear);
		btnKeluar = (Button)findViewById(R.id.btnKeluar);
		btnHasil = (Button)findViewById(R.id.btnHasil);
		txtResult = (TextView)findViewById(R.id.txtResult);
		
		btnClear.setOnClickListener(new Clear());
		btnKeluar.setOnClickListener(new Keluar());
		btnHasil.setOnClickListener(new Hasil());
		
	}

	private class Keluar implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

	private class Clear implements Button.OnClickListener{
		public void onClick(View v){
			edtPanjang.setText("");
			edtLebar.setText("");
			txtResult.setText("");
		}
	}

	private class Hasil implements Button.OnClickListener{
		public void onClick(View v){
			int panjang, lebar;
			
			panjang = Integer.parseInt(edtPanjang.getText().toString());
			lebar = Integer.parseInt(edtLebar.getText().toString());
			int luas = panjang * lebar;
			
			txtResult.setText(String.valueOf(luas));
			
		}
	}
	
}
