package com.example.android_broadcast_ordered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Two extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String value=intent.getStringExtra("name");
		System.out.println("--Two-->>"+value);
	}

}
