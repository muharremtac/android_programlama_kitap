package com.m2.android.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DbornekActivity extends Activity {
	private static final String SERVER_IP = "10.0.2.2";//Emulator icin

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ListView listView = (ListView) findViewById(R.id.listView);
		String connectionURL = "jdbc:jtds:sqlserver://" + SERVER_IP
				+ ":1433;databaseName=banks;user=sa;password=password";

		Connection con=null;
		Statement stmd=null;
		ResultSet rs=null;
		List<String> bankalar = new ArrayList<String>();
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL);
			stmd = con.createStatement();
			rs = stmd.executeQuery("select BANK_ID, BANK_NAME, FROM BANKS");

			while (rs.next()) {
				bankalar.add(rs.getString("BANK_ID") + " " + rs.getString("BANK_NAME"));
			}

			listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, bankalar));
		} catch (SQLException e) {
		} catch (Exception e) {
		} finally {
			try {
				if(con!=null && con.isClosed()==false){
					con.close();
				}
				if(stmd!=null && stmd.isClosed()==false){
					stmd.close();
				}
				if(rs!=null && rs.isClosed()==false){
					rs.close();
				}
			} catch (SQLException e) {
			}
			
		}
	}
}