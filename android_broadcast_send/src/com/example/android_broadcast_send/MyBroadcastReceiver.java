package com.example.android_broadcast_send;

import android.R.string;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	NotificationManager manager;
	@Override
	public void onReceive(Context context, Intent intent) {
		manager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
		builder.setTicker("广播来了");
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setContentText("wifi断了-->"+intent.getStringExtra("name"));
		builder.setContentTitle("断网了");
		//String value=intent.getStringExtra("name");
		//Toast.makeText(context, "hello -->>"+value, Toast.LENGTH_LONG).show();
		manager.notify(1001,builder.build());
	}
}
