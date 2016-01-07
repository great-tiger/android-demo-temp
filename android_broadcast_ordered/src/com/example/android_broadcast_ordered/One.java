package com.example.android_broadcast_ordered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class One extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String value=intent.getStringExtra("name");
		System.out.println("--One-->>"+value);
		
		Bundle bundle=new Bundle();
		bundle.putString("firstName","hello");
		bundle.putString("lastName","world");
		setResultExtras(bundle);
		//≤‚ ‘÷’÷ππ„≤•
		//abortBroadcast();
	}

}
