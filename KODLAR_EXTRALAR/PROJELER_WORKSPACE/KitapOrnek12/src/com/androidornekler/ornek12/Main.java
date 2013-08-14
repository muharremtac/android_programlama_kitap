package com.androidornekler.ornek12;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	Button dialogButton;
	Button alertButton;
	Button listAlertButton;
	Button choiceAlertButton;
	Button progressDialogButton;
	Button datePickerButton;
	
	TextView tarihView;
	
	private int yil;
	private int ay;
	private int gun;
	
	static final int DATE_DIALOG_ID = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dialogButton = (Button)findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final Dialog dialog = new Dialog(Main.this);
				dialog.setTitle("Basit dialog");
				dialog.show();
			}
		});
        
        
        alertButton = (Button)findViewById(R.id.alertButton);
        alertButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
				builder.setMessage("Uygulamadan çıkılsın mı?").
				setCancelable(false).setPositiveButton("Evet",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
						finish();
					}
				}).setNegativeButton("Hayır",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
        
        
        listAlertButton = (Button)findViewById(R.id.listAlertButton);
        listAlertButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final CharSequence[] items = {"Kirmızı", "Yeşil", "Mavi"};

				AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
				builder.setTitle("Renk seçiniz");
				builder.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
				    }
				});
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
        
        choiceAlertButton = (Button)findViewById(R.id.choiceAlertButton);
        choiceAlertButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final CharSequence[] items = {"Kirmızı", "Yeşil", "Mavi"};

				AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
				builder.setTitle("Renk seçiniz");
				builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
				    }
				});
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
        
        progressDialogButton = (Button)findViewById(R.id.progressDialogButton);
        progressDialogButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				ProgressDialog pd = ProgressDialog.show(Main.this, "Başlık", "İşlem", true,true);
			}
		});
        
        
        
        tarihView = (TextView)findViewById(R.id.tarihView);
        
        datePickerButton = (Button)findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 showDialog(DATE_DIALOG_ID);
			}
		});
        
        final Calendar takvim = Calendar.getInstance();
        yil = takvim.get(Calendar.YEAR);
        ay = takvim.get(Calendar.MONTH);
        gun = takvim.get(Calendar.DAY_OF_MONTH);

        updateDisplay();
    }
    
    
    
    private void updateDisplay() {
        tarihView.setText(
            new StringBuilder()
                    .append(ay + 1).append("-")
                    .append(gun).append("-")
                    .append(yil).append(" ").toString());
    }
    
    
    private DatePickerDialog.OnDateSetListener tarihListener =
        new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int iYil, 
                                  int iAy, int iGun) {
                yil = iYil;
                ay = iAy;
                gun = iGun;
                updateDisplay();
            }
        };
    
    @Override
    protected Dialog onCreateDialog(int id) {
       switch (id) {
       case DATE_DIALOG_ID:
          return new DatePickerDialog(this,
                    tarihListener,
                    yil, ay, gun);
       }
       return null;
    }
    
}