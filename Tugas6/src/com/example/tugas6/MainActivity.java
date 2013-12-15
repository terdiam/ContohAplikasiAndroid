package com.example.tugas6;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;
import android.net.Uri;


public class MainActivity extends Activity {
	
	ImageButton ImgButCra, ImgButEnutrof, ImgButExit, ImgButOsamodas, ImgButPandawa, ImgButSadida, ImgButScrier, ImgButXelor;
	Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImgButCra = (ImageButton)findViewById(R.id.cra);
        ImgButEnutrof = (ImageButton)findViewById(R.id.enutrof);
        ImgButExit = (ImageButton)findViewById(R.id.btnExit);
        ImgButOsamodas = (ImageButton)findViewById(R.id.osamodas);
        ImgButPandawa = (ImageButton)findViewById(R.id.pandawa);
        ImgButSadida = (ImageButton)findViewById(R.id.sadida);
        ImgButScrier = (ImageButton)findViewById(R.id.scrier);
        ImgButXelor = (ImageButton)findViewById(R.id.xelor);
        
        ImgButExit.setOnClickListener(new keluar());
        
        ImgButCra.setOnClickListener(new Cra());
        ImgButEnutrof.setOnClickListener(new Enutrof());
        ImgButOsamodas.setOnClickListener(new Osamodas());
        ImgButPandawa.setOnClickListener(new Pandawa());
        ImgButSadida.setOnClickListener(new Sadida());
        ImgButScrier.setOnClickListener(new Scrier());
        ImgButXelor.setOnClickListener(new Xelor());
        
    }

	private class keluar implements ImageButton.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

	private class Cra implements ImageButton.OnClickListener{
		public void onClick(View v){
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wakfu.com/en/mmorpg/game-guide/character-classes/9-cra-range"));
			startActivity(intent);
		}
	}

	private class Enutrof implements ImageButton.OnClickListener{
		public void onClick(View v){
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wakfu.com/en/mmorpg/game-guide/character-classes/3-enutrof-fingers"));
			startActivity(intent);
		}
	}

	private class Osamodas implements ImageButton.OnClickListener{
		public void onClick(View v){
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wakfu.com/en/mmorpg/game-guide/character-classes/2-osamodas-whip"));
			startActivity(intent);
		}
	}

	private class Pandawa implements ImageButton.OnClickListener{
		public void onClick(View v){
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wakfu.com/en/mmorpg/game-guide/character-classes/12-pandawa-pint"));
			startActivity(intent);
		}
	}

	private class Sadida implements ImageButton.OnClickListener{
		public void onClick(View v){
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wakfu.com/en/mmorpg/game-guide/character-classes/10-sadida-shoe"));
			startActivity(intent);
		}
	}

	private class Scrier implements ImageButton.OnClickListener{
		public void onClick(View v){
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wakfu.com/en/mmorpg/game-guide/character-classes/11-sacrier-blood"));
			startActivity(intent);
		}
	}

	private class Xelor implements ImageButton.OnClickListener{
		public void onClick(View v){
			intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wakfu.com/en/mmorpg/game-guide/character-classes/5-"));
			startActivity(intent);
		}
	}

    
}


