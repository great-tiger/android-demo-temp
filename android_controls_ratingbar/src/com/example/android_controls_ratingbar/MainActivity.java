package com.example.android_controls_ratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button setBtn;
	private Button getBtn;
	private RatingBar ratingBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setBtn=(Button)this.findViewById(R.id.button1);
		getBtn=(Button)this.findViewById(R.id.button2);
		ratingBar=(RatingBar)this.findViewById(R.id.ratingBar1);
		//����ֵ
		setBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ratingBar.setRating(2.3f);
			}
		});
		//��ȡֵ
		getBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				float f=ratingBar.getRating();
				Toast.makeText(getApplicationContext(), String.valueOf(f), Toast.LENGTH_SHORT).show();
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
