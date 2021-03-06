package com.example.android_handler_updatetextview;

import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textview;
	Button button;
	MyHandler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textview=(TextView)this.findViewById(R.id.textView1);
		button=(Button)this.findViewById(R.id.button1);
		handler=new MyHandler();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new MyThread().start();
			}
		});
	}

	class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			textview.append("count"+msg.arg1+" ");
			super.handleMessage(msg);
		}
	}
	
    class MyThread extends Thread{
    	int count=0;
    	@Override
    	public void run() {
    		while (count++<20) {
    			try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Message message=Message.obtain();
				message.arg1=count;
				handler.sendMessage(message);
			}
    		super.run();
    	}
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
