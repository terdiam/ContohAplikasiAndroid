/*------------------------------------------------
 * File : DemoRadioButton.java
 * Desc.: Membuat pilihan dg radio button
 * -----------------------------------------------
 */
package subari.demoradiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;

public class DemoRadioButton extends Activity {
	TextView hasil;
	RadioGroup rg;
	RadioButton rb1, rb2;	
	Button pilih;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rg = (RadioGroup) findViewById(R.id.rdoGroup1);
        rb1 = (RadioButton) findViewById(R.id.rdoJK1);
        rb2 = (RadioButton) findViewById(R.id.rdoJK2);
        
        hasil=(TextView) findViewById(R.id.txtTampil);
        pilih = (Button) findViewById(R.id.btnPilih);
        pilih.setOnClickListener(new klik());
        
    }
    
   class klik implements Button.OnClickListener
    {
    	public void onClick(View v)
    	{
    		if (rb1.isChecked())
    			hasil.setText("Anda Laki-laki");
    		if (rb2.isChecked())
    			hasil.setText("Anda Wanita");
    	}
    	
    }
}