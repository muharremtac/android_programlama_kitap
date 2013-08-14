package com.androidornekler.ornek5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsDinleyici extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Bundle bundle = intent.getExtras();

        if (bundle != null)
        {
            Object[] pdus = (Object[])bundle.get("pdus");
            SmsMessage[] msgs = new SmsMessage[pdus.length];

            for (int i = 0; i < msgs.length; i++)
            {
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);

                try
                {
                    Intent in = new Intent(context, SmsGosterici.class);
                    in.putExtra("telNo", msgs[i].getOriginatingAddress());
                    in.putExtra("smsMesaji", msgs[i].getMessageBody().toString());
                    in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(in);
                }
                catch (Exception e) { 
                	Log.e("SMSDINLEYICI", e.toString());
                }
            }
        }
		}

	
}

