package com.example.android_controls_radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button button;
	private RadioButton radioButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button=(Button)this.findViewById(R.id.button1);
		radioButton=(RadioButton)this.findViewById(R.id.radio1);

		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				radioButton.setChecked(true);
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
	
	public void onClick(View view){
		switch (view.getId()) {
		case R.id.radio0:
			Toast.makeText(getApplicationContext(), "您选择了 A", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radio1:
			Toast.makeText(getApplicationContext(), "您选择了 B", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radio2:
			Toast.makeText(getApplicationContext(), "您选择了 C", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
	
	
}
