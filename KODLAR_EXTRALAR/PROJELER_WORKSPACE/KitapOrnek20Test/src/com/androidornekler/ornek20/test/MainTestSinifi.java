package com.androidornekler.ornek20.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.androidornekler.ornek20.Main;

public class MainTestSinifi extends ActivityInstrumentationTestCase2<Main> {

	private Main mainActivity;
	private TextView textView;
	private String kaynakMetni;

	public MainTestSinifi() {
		super("com.androidornekler.ornek20", Main.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mainActivity = this.getActivity();
		textView = (TextView) mainActivity.findViewById(com.androidornekler.ornek20.R.id.testEdilenIcerik);
		kaynakMetni = mainActivity.getString(com.androidornekler.ornek20.R.string.deneme);
	}

	public void testBosKontrolu() {
		assertNotNull(textView);
	}

	public void testMetinKontrolu() {
		assertEquals(kaynakMetni, (String) textView.getText());
	}

	public void testIcerikKontrolu() {
		assertEquals(kaynakMetni, "Bilgi");
	}
	
}
