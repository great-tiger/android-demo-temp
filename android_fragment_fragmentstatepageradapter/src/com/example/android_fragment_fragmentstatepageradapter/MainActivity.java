package com.example.android_fragment_fragmentstatepageradapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	ViewPager mViewPager;
	DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		
		mDemoCollectionPagerAdapter=new DemoCollectionPagerAdapter(getSupportFragmentManager());
		mViewPager=(ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(mDemoCollectionPagerAdapter);
	}

}

class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

	public DemoCollectionPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		DemoObjectFragment fragment = new DemoObjectFragment();
		Bundle args = new Bundle();
		args.putInt(DemoObjectFragment.ARG_OBJECT, arg0 + 1);
		fragment.setArguments(args);
		return fragment;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "OBJECT" + (position + 1);
	}
}
