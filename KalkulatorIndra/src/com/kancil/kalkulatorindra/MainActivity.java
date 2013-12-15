package com.kancil.kalkulatorindra;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
		btnBagi, btnKali, btnTambah, btnKurang, btnTitik, btnCE, btnSamaDengan,
		btnPersen, btnModulus, btnDelete;
	
	TextView txtLastProses, txtMemory, txtHasil;
	
	double dHasil = Double.NaN, dTmp=Double.NaN;
	String sTmp="";
	char lastOperator=' ';
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn7 = (Button) findViewById(R.id.btn7);
		btn8 = (Button) findViewById(R.id.btn8);
		btn9 = (Button) findViewById(R.id.btn9);
		btn0 = (Button) findViewById(R.id.btn0);
		btnBagi = (Button) findViewById(R.id.btnBagi);
		btnKali = (Button) findViewById(R.id.btnKali);
		btnTambah = (Button) findViewById(R.id.btnTambah);
		btnKurang = (Button) findViewById(R.id.btnKurang);
		btnTitik = (Button) findViewById(R.id.btnTitik);
		btnCE = (Button) findViewById(R.id.btnCE);
		btnSamaDengan = (Button) findViewById(R.id.btnSamaDengan);
		btnPersen = (Button)findViewById(R.id.btnPersen);
		btnModulus = (Button) findViewById(R.id.btnModulus);
		btnDelete = (Button) findViewById(R.id.btnDelete);
		
		btn1.setOnClickListener(new Button1());
		btn2.setOnClickListener(new Button2());
		btn3.setOnClickListener(new Button3());
		btn4.setOnClickListener(new Button4());
		btn5.setOnClickListener(new Button5());
		btn6.setOnClickListener(new Button6());
		btn7.setOnClickListener(new Button7());
		btn8.setOnClickListener(new Button8());
		btn9.setOnClickListener(new Button9());
		btn0.setOnClickListener(new Button0());
		btnTambah.setOnClickListener(new ButtonTambah());
		btnKurang.setOnClickListener(new ButtonKurang());
		btnBagi.setOnClickListener(new ButtonBagi());
		btnKali.setOnClickListener(new ButtonKali());
		btnTitik.setOnClickListener(new ButtonTitik());
		btnCE.setOnClickListener(new ButtonCE());
		btnSamaDengan.setOnClickListener(new ButtonSamaDengan());
		btnPersen.setOnClickListener(new ButtonPersen());
		btnModulus.setOnClickListener(new ButtonModulus());
		btnDelete.setOnClickListener(new ButtonDelete());
		
		txtLastProses = (TextView) findViewById(R.id.txtLastProses);
		txtMemory = (TextView) findViewById(R.id.txtMemory);
		txtMemory.setText("0");
		txtHasil = (TextView) findViewById(R.id.txtHasil);
		txtHasil.setText("0");
		dHasil=0;
		dTmp=0;
	}
	
	class Button1 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"1");
					sTmp=sTmp+"1";
				} else {
					txtMemory.setText("1");
					sTmp="1";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("1");
		}		
	}

	class Button2 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"2");
					sTmp=sTmp+"2";
				} else {
					txtMemory.setText("2");
					sTmp="2";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("2");
		}		
	}

	class Button3 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"3");
					sTmp=sTmp+"3";
				} else {
					txtMemory.setText("3");
					sTmp="3";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("3");
		}		
	}

	class Button4 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"4");
					sTmp=sTmp+"4";
				} else {
					txtMemory.setText("4");
					sTmp="4";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("4");
		}		
	}


	class Button5 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"5");
					sTmp=sTmp+"5";
				} else {
					txtMemory.setText("5");
					sTmp="5";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("5");
		}		
	}

	class Button6 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"6");
					sTmp=sTmp+"6";
				} else {
					txtMemory.setText("6");
					sTmp="6";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("6");
		}		
	}

	class Button7 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"7");
					sTmp=sTmp+"7";
				} else {
					txtMemory.setText("7");
					sTmp="7";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("7");
		}		
	}

	class Button8 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"8");
					sTmp=sTmp+"8";
				} else {
					txtMemory.setText("8");
					sTmp="8";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("8");
		}		
	}

	class Button9 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"9");
					sTmp=sTmp+"9";
				} else {
					txtMemory.setText("9");
					sTmp="9";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("9");
		}		
	}

	class Button0 implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(txtMemory.getText().toString()!="0"){
					txtMemory.setText(txtMemory.getText().toString()+"0");
					sTmp=sTmp+"0";
				} else {
					txtMemory.setText("0");
					sTmp="0";
				}
			} else {
				resetValue();
			}
			txtLastProses.setText("0");
		}		
	}

	class ButtonTambah implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(lastOperator!=' '){
					Operasi();
					txtHasil.setText("0");
				} else {
					dTmp=Double.parseDouble(sTmp);
					dHasil=dTmp;
				}
			} else {
				dTmp=dHasil;
				txtMemory.setText(Double.toString(dHasil));
				txtHasil.setText("0");
			}
			sTmp="";
			txtMemory.setText(txtMemory.getText().toString()+"+");
			lastOperator='+';
			txtLastProses.setText("+");
			//Toast.makeText(v.getContext(), "Maaf, isikan dulu angka pertama.", Toast.LENGTH_SHORT).show();				
		}		
	}

	class ButtonKurang implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(lastOperator!=' '){
					Operasi();
					txtHasil.setText("0");
				} else {
					dTmp=Double.parseDouble(sTmp);
					dHasil=dTmp;
				}
			} else {
				dTmp=dHasil;
				txtMemory.setText(Double.toString(dHasil));
				txtHasil.setText("0");
			}
			sTmp="";
			txtMemory.setText(txtMemory.getText().toString()+"-");
			lastOperator='-';
			txtLastProses.setText("-");
		}		
	}

	class ButtonBagi implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(lastOperator!=' '){
					Operasi();
					txtHasil.setText("0");
				} else {
					dTmp=Double.parseDouble(sTmp);
					dHasil=dTmp;
				}
			} else {
				dTmp=dHasil;
				txtMemory.setText(Double.toString(dHasil));
				txtHasil.setText("0");
			}
			sTmp="";
			txtMemory.setText(txtMemory.getText().toString()+"/");
			lastOperator='/';
			txtLastProses.setText("/");
		}		
	}

	class ButtonKali implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(lastOperator!=' '){
					Operasi();
					txtHasil.setText("0");
				} else {
					dTmp=Double.parseDouble(sTmp);
					dHasil=dTmp;
				}
			} else {
				dTmp=dHasil;
				txtMemory.setText(Double.toString(dHasil));
				txtHasil.setText("0");
			}
			sTmp="";
			txtMemory.setText(txtMemory.getText().toString()+"*");
			lastOperator='*';
			txtLastProses.setText("*");
		}		
	}

	class ButtonTitik implements OnClickListener {
		public void onClick(View v) {
			txtLastProses.setText(".");
			if(checkTitik(sTmp)){
				sTmp=sTmp+'.';
				txtMemory.setText(txtMemory.getText().toString()+".");
			} else {
				Toast.makeText(v.getContext(), "Maaf, sudah ada koma.", Toast.LENGTH_SHORT).show();
			}
		}		
	}

	class ButtonCE implements OnClickListener {
		public void onClick(View v) {
			txtLastProses.setText("CE");
			resetValue();
		}		
	}
	
	void resetValue(){
		sTmp="";
		dHasil=0;
		dTmp=0;
		lastOperator= ' ';
		txtMemory.setText("0");
		txtHasil.setText("0");
	}

	class ButtonSamaDengan implements OnClickListener {
		public void onClick(View v) {
			Operasi();
			txtLastProses.setText("=");
			txtHasil.setText(Double.toString(dHasil));
			Toast.makeText(v.getContext(), "Maaf, silahkan pilih operasi lain.", Toast.LENGTH_SHORT).show();				
		}		
	}

	class ButtonPersen implements OnClickListener {
		public void onClick(View v) {
			txtLastProses.setText("%");
			//lastOperator='%';
			txtMemory.setText(txtMemory.getText().toString()+"%");
			dTmp=Double.parseDouble(sTmp);
			dTmp=dTmp*0.01;
			sTmp="";
		}		
	}

	class ButtonModulus implements OnClickListener {
		public void onClick(View v) {
			if(txtHasil.getText().toString()=="0"){
				if(lastOperator!=' '){
					Operasi();
					txtHasil.setText("0");
				} else {
					dTmp=Double.parseDouble(sTmp);
					dHasil=dTmp;
				}
			} else {
				dTmp=dHasil;
				txtMemory.setText(Double.toString(dHasil));
				txtHasil.setText("0");
			}
			sTmp="";
			txtMemory.setText(txtMemory.getText().toString()+"M");
			lastOperator='M';
			txtLastProses.setText("M");
		}		
	}

	class ButtonDelete implements OnClickListener {
		public void onClick(View v) {
			
			txtLastProses.setText("\u00AB");
			
			int endIndex = txtMemory.getText().length() - 1;

			if (endIndex < 1) {
				txtMemory.setText("0");
			}
			else {
				txtMemory.setText(txtMemory.getText().subSequence(0, endIndex));
			}			
		}		
	}
	
	private double Operasi(){
		if(sTmp != "") dTmp=Double.parseDouble(sTmp);
		switch (lastOperator) {
		case '+':
			dHasil=dHasil+dTmp;
			break;
		case '-':
			dHasil=dHasil-dTmp;
			break;
		case '*':
			dHasil=dHasil*dTmp;
			break;
		case '/':
			dHasil=dHasil/dTmp;
			break;
		case 'M':
			dHasil=dHasil%dTmp;
		}
		return dHasil;
	}

	private static boolean checkTitik(String str){
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch=='.')return false;
		}
		return true;
	}
	
}
