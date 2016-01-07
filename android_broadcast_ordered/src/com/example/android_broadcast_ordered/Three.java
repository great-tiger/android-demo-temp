package com.example.android_broadcast_ordered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Three extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String value=intent.getStringExtra("name");
		System.out.println("--Three-->>"+value);
		Bundle bundle=getResultExtras(true);
		if(bundle!=null){
			System.out.println("--Three result-->"+bundle.getString("firstName")+"-->>"+bundle.getString("lastName"));
		}
	}

}
