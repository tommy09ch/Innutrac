package com.innutrac.poly.innutrac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GetUserInfo extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get_user_info);

		Button start = (Button) findViewById(R.id.save_user_button);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(GetUserInfo.this, MainActivity.class);
				startActivity(i);
			}
		});
	}
}
