package com.innutrac.poly.innutrac;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class WelcomeMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_message);
		Button startButton = (Button) findViewById(R.id.wm_start_button);
		TextView foo = (TextView) findViewById(R.id.textView3);
		foo.setText(Html.fromHtml(getString(R.string.what_is_innutrac_body)));

		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(WelcomeMessageActivity.this,
						UserInfoActivity.class).putExtra("title",
						"WelcomeMessage"));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
