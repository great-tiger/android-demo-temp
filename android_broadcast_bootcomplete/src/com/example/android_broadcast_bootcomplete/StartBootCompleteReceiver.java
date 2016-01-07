package com.example.android_broadcast_bootcomplete;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartBootCompleteReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent intent2=new Intent(context,MainActivity.class);
		intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent2);
	}

}
