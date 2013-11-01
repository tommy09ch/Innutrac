package com.innutrac.poly.innutrac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.Window;

public class Activity_SplashScreen extends Activity {
	private static final int TIMER_SPEED = 2000; // 2 seconds

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent i = checkOnFirstLoad();
				startActivity(i);
				finish();

			}
		}, TIMER_SPEED);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

	/**
	 * Checks if first load, if so then create cache files and appropriate
	 * directories. Then return WelcomeMessage.class as new intent. Otherwise,
	 * go to MainActivity.class
	 * 
	 * @return
	 */
	private Intent checkOnFirstLoad() {
		String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
		
		
		File cache = new File(sdPath + "/Innutrac/vals/cache");
		if (cache.exists()) {
			return new Intent(this, MainActivity.class);
		} else {
			File dir = new File(sdPath + "/Innutrac/vals");
			dir.mkdirs();
			cache = new File(dir, "cache");
			try {
				// We're using this blank file to determine if this is the first load
				FileOutputStream f = new FileOutputStream(cache);
				f.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new Intent(this, Activity_FirstTimeMessage.class);
		}
	}
}