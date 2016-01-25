package com.example.android_videoview_service;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayActivity extends Activity implements MediaPlayerControl {

	private VideoView videoview;
	private MediaController controller;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		
		videoview=(VideoView)this.findViewById(R.id.videoView1);
		videoview.setVideoPath("/mnt/sdcard/abc.MP4");
		controller=new MediaController(this);
		videoview.setMediaController(controller);
		videoview.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
