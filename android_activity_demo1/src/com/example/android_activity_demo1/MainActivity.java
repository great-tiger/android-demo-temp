package com.example.android_activity_demo1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn;
	private final static int PICK_CONTACT_REQUEST=2001;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)this.findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				pickContact();
				
			}
		});
	}

	private void pickContact() {
	    // Create an intent to "pick" a contact, as defined by the content provider URI
	    Intent intent = new Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI);
	    startActivityForResult(intent, PICK_CONTACT_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
	    if (resultCode == Activity.RESULT_OK && requestCode == PICK_CONTACT_REQUEST) {
	        // ²»Ì«¶®
	        Cursor cursor = getContentResolver().query(data.getData(),
	        new String[] {Contacts.DISPLAY_NAME}, null, null, null);
	        if (cursor.moveToFirst()) { // True if the cursor is not empty
	            int columnIndex = cursor.getColumnIndex(Contacts.DISPLAY_NAME);
	            String name = cursor.getString(columnIndex);
	            Toast.makeText(getApplicationContext(), name, 10);
	        }
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
