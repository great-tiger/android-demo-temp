package com.example.andriod_notification_test;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	NotificationManager manager;
	Button btn1;
	Button btn2;//自定义通知
	Button btn3;//大视图的通知
	NotificationCompat.Builder builder;//NotificationCompat 通知的帮助类
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				builder=new NotificationCompat.Builder(MainActivity.this);	
				builder.setTicker("XXXX");//当通知第一次出现时，设置状态栏文本
				builder.setContentTitle("Picture Download")
			    .setContentText("Download in progress")
			    .setSmallIcon(R.drawable.ic_launcher);
				//设置点击跳转
				Intent intent=new Intent(MainActivity.this,MainActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0, intent,PendingIntent.FLAG_ONE_SHOT);
				builder.setContentIntent(pendingIntent);
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						for(int i=0;i<=100;i++){
							builder.setProgress(100, i, false);
							manager.notify(1001, builder.build());
							try{
								Thread.sleep(100);
							}catch(InterruptedException e){
								
							}
						}
						builder.setContentText("Download complete").setProgress(0, 0, false);
						manager.notify(1001, builder.build());
					}
				}).start();
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
				builder.setTicker("有约会来了");
				builder.setSmallIcon(R.drawable.ic_launcher);
				RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.notification);
				remoteViews.setTextViewText(R.id.title, "晚上有时间吗?");
				remoteViews.setTextViewText(R.id.content, "一起吃饭吧");			
				builder.setContent(remoteViews);
				manager.notify(1002, builder.build());
			}
		});
		
		btn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
				builder.setSmallIcon(R.drawable.ic_launcher);
				builder.setContentTitle("Event tracker");
				builder.setContentText("Events received");
				NotificationCompat.InboxStyle style=new NotificationCompat.InboxStyle();
				builder.setStyle(style);
				style.setBigContentTitle("Event tracker details");
				String[] lines=new String[]{"1","2","3","4","5","6"};
				for(int i=0;i<lines.length;i++){
					style.addLine(lines[i]);
				}
				
				//设置点击跳转
				Intent intent=new Intent(MainActivity.this,MainActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0, intent,PendingIntent.FLAG_ONE_SHOT);
				builder.setContentIntent(pendingIntent);
				builder.setAutoCancel(true);//当通知点击完后，通知会消失。注意，如果没有设置点击跳转，则无效
				
				manager.notify(1003, builder.build());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
