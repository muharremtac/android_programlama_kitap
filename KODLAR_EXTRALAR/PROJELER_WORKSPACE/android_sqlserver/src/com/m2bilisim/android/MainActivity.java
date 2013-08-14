package com.m2bilisim.android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	
	Connection conn = null;
	String url = "jdbc:jtds:sqlserver://10.39.4.103:1433;databaseName=VERITABANI_ADI";
	String driver = "net.sourceforge.jtds.jdbc.Driver";
	String userName = "KULLANICI_ADI";
	String password = "SIFRE";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		try {
			Class.forName(driver).newInstance();
			Thread thread = new Thread(new Runnable(){
				public void run() {
					try {
						conn = DriverManager.getConnection(url , userName, password);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}