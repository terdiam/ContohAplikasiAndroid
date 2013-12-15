package com.film.bioskop;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FilmBioskop extends Activity implements
	AdapterView.OnItemSelectedListener{

	ArrayList<String> judul = new ArrayList<String>();
	RadioGroup radGrpgenre;
	RadioButton rdoAction, rdoComedy, rdoDrama, rdoIndo, rdoMandarin, rdoBarat;
	Spinner spinJudul;
	Button btnDetail, btnKeluar;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		radGrpgenre = (RadioGroup)findViewById(R.id.rdoGroupGenre);
		rdoAction = (RadioButton)findViewById(R.id.rdoAction);
		rdoComedy = (RadioButton)findViewById(R.id.rdoComedy);
		rdoDrama = (RadioButton)findViewById(R.id.rdoDrama);
		rdoIndo = (RadioButton)findViewById(R.id.rdoIndo);
		rdoMandarin = (RadioButton)findViewById(R.id.rdoMandarin);
		rdoBarat = (RadioButton)findViewById(R.id.rdoBarat);
		
		spinJudul = (Spinner)findViewById(R.id.spinJudul);
		
		rdoAction.setOnClickListener(new FilmAction());
		rdoComedy.setOnClickListener(new FilmComedy());
		rdoDrama.setOnClickListener(new FilmDrama());
	}

	private class FilmAction implements Button.OnClickListener{
		public void onClick(View v){
			if(rdoAction.isChecked()){
				if(rdoIndo.isChecked()){
					judul.clear();
					judul.add("True Heart");
					judul.add("Gending Sriwijaya");
				}
				if(rdoMandarin.isChecked()){
					judul.clear();
					judul.add("Crouching Tiger, Hidden Dragon");
					judul.add("Hero");
				}
				if(rdoBarat.isChecked()){
					judul.clear();
					judul.add("Bullet to the Head");
					judul.add("A Good Day to Die Hard");
				}
		        ArrayAdapter<String> aa = new ArrayAdapter<String>
				  (this,android.R.layout.simple_spinner_item, judul);
		        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        spinJudul.setAdapter(aa);
		        spinJudul.setOnItemSelectedListener(aa);
			}
		}
	}

	private class FilmComedy implements Button.OnClickListener{
		public void onClick(View v){
			if(rdoAction.isChecked()){
				if(rdoIndo.isChecked()){
					judul.clear();
					judul.add("Finding Srimulat");
					judul.add("Bangun Lagi Dong Lupus");
				}
				if(rdoMandarin.isChecked()){
					judul.clear();
					judul.add("A Tale Of Legendary Libido");
					judul.add("My Girl Boy");
				}
				if(rdoBarat.isChecked()){
					judul.clear();
					judul.add("Scary Movie 5");
					judul.add("The Hangover 3");
				}
			}
		}
	}
	
	private class FilmDrama implements Button.OnClickListener{
		public void onClick(View v){
			if(rdoAction.isChecked()){
				if(rdoIndo.isChecked()){
					judul.clear();
					judul.add("Mursala");
					judul.add("Hari Ini Pasti Menang");
				}
				if(rdoMandarin.isChecked()){
					judul.clear();
					judul.add("49 Days");
					judul.add("A Thousand Kisses");
				}
				if(rdoBarat.isChecked()){
					judul.clear();
					judul.add("Battle of the Year");
					judul.add("300: Battle of Artemisia");
				}
			}
		}
	}
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}



}
