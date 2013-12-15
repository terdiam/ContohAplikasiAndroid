/*-----------------------------------------------------
 * File : ComboDinamis.java
 * Desc.: membuat combo yang diisikan secara dinamis
 * ----------------------------------------------------
 */
package subari.democombodinamis;

import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ComboDinamis extends Activity implements
								  AdapterView.OnItemSelectedListener {
	TextView selection_country;
	TextView selection_city;
	Spinner spin_city;
	String[] negara = { "Amerika", "Argentina", "Brazil", "Indonesia",
						"Inggris", "Malaysia", "Pilipina" };
	HashMap<String, String []> hash_negara = new HashMap<String, String []>();
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generateData();
        setContentView(R.layout.main);
        selection_country = (TextView) findViewById(R.id.selection_country);
        Spinner spin = (Spinner) findViewById(R.id.spin_country);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>
        						  (this,android.R.layout.simple_spinner_item, negara);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin_city = (Spinner) findViewById(R.id.spin_city);
    }
    
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
    		fillComboKota(negara[position]);
    		}
    		
    public void onNothingSelected(AdapterView<?> parent) {
    		Toast.makeText(this, "Silahkan Pilih Negara", Toast.LENGTH_LONG).show();
    		}
    		
    private void generateData(){
    		hash_negara.put("Amerika", new String[] {"Chicago","Los Angeles","Newyork"});
    		hash_negara.put("Indonesia", new String[] {"Bandung","Jakarta","Surabaya"});
    		hash_negara.put("Malaysia", new String[] {"Kuala Lumpur","Selangor","Serawak"});
    		}
    private void fillComboKota(String snegara){
    		String[] kota = null;
    		ArrayAdapter<String> aa = null;
    		try {
    			kota = hash_negara.get(snegara);
    			aa = new ArrayAdapter<String>(this,
    			android.R.layout.simple_spinner_item, kota);
    		} catch (NullPointerException e) {
    			aa = new ArrayAdapter<String>(this,
    			android.R.layout.simple_spinner_item, new String[] {});
    		}
    		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    		spin_city.setAdapter(aa);
    }
}