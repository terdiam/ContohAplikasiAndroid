package subari.combobox;

import android.app.Activity;
import android.os.Bundle;
//import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DemoComboBox extends Activity implements
AdapterView.OnItemSelectedListener {

	TextView txtPilih;
	String[] negara = { "Amerika", "Argentina", "Brazil", "Indonesia",
					    "Inggris", "Malaysia", "Pilipina" };
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtPilih = (TextView) findViewById(R.id.txtTampil);
        Spinner spin = (Spinner) findViewById(R.id.spinNegara);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>
        						 (this,android.R.layout.simple_spinner_item, negara);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }
    
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
    		Toast.makeText(this, "Anda Memilih: " +
    				negara[position],Toast.LENGTH_LONG).show();  		
    		txtPilih.setText("Negara : " + negara[position]);
    }
    		
    public void onNothingSelected(AdapterView<?> parent) {
    		Toast.makeText(this, "Silahkan Pilih Negara", Toast.LENGTH_LONG).show();
    		}
}
