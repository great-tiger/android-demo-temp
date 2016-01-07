package com.example.android_broadcast_send;

import android.R.string;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver3 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String value=intent.getStringExtra("name");
		Toast.makeText(context, "hello -->>"+value, Toast.LENGTH_LONG).show();
	}
}
