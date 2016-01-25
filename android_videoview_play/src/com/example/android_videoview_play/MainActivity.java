package com.example.android_videoview_play;

import java.io.File;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity implements MediaPlayerControl {

	private VideoView videoview;
	private MediaController controller;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		videoview=(VideoView)this.findViewById(R.id.videoView1);
		
		controller=new MediaController(this);
		videoview.setMediaController(controller);
		
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			File file=Environment.getExternalStorageDirectory();
			File videoFile=new File(file,"a.MP4");
			Uri uri=Uri.fromFile(videoFile);
			videoview.setVideoURI(uri);
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

	@Override
	public void start() {
		videoview.start();
	}

	@Override
	public void pause() {
		videoview.pause();
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return videoview.getDuration();
	}

	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return videoview.getCurrentPosition();
	}

	@Override
	public void seekTo(int pos) {
		videoview.seekTo(pos);
	}

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return videoview.isPlaying();
	}

	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return videoview.getBufferPercentage();
	}

	@Override
	public boolean canPause() {
		return videoview.canPause();
	}

	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return videoview.canSeekBackward();
	}

	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return videoview.canSeekForward();
	}
}
