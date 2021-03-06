package com.example.android_activity_startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends Activity {

	private TextView textview1;
	private EditText edittext;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		textview1=(TextView)this.findViewById(R.id.textView1);
		button=(Button)this.findViewById(R.id.button1);
		edittext=(EditText)this.findViewById(R.id.editText1);
		Intent intent=getIntent();
		String value=intent.getStringExtra("result");
		textview1.setText(value);
				
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String value=edittext.getText().toString();
				Intent intent=new Intent();
				intent.putExtra("result", value);
				setResult(1001, intent);
				finish();//结束Activity的生命周期
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next, menu);
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
