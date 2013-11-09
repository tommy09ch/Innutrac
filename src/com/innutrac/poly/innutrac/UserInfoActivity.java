package com.innutrac.poly.innutrac;

import com.innutrac.poly.innutrac.database.*;

import android.os.*;
import android.app.Activity;
import android.content.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class UserInfoActivity extends Activity {
	String name = "", age = "", gender = "", heightFt = "", heightIn = "",
			weight = "", time = "";
	boolean editProf = false;

	ProfileDatabase pdb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_info);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle("User Profile");

		final RadioButton maleRB = (RadioButton) findViewById(R.id.ui_male_radbut);
		final RadioButton femaleRB = (RadioButton) findViewById(R.id.ui_female_radbut);
		Button saveBut = (Button) findViewById(R.id.ui_save_but);
		Button skip_cancelBut = (Button) findViewById(R.id.ui_skip_but);

		pdb = new ProfileDatabase(this);
		pdb.open("UserDatabase");

		String prev = getIntent().getStringExtra("title");
		editProf = prev.compareTo("WelcomeMessage") != 0;

		if (editProf) {
			skip_cancelBut.setText("Cancel");
			assembleCreatedProfile();

			((EditText) findViewById(R.id.ui_name_edit)).setText(name);
			((EditText) findViewById(R.id.ui_age_edit)).setText(age);
			((EditText) findViewById(R.id.ui_feetHeight_edit))
					.setText(heightFt);
			((EditText) findViewById(R.id.ui_inchHeight_edit))
					.setText(heightIn);
			((EditText) findViewById(R.id.ui_weight_edit)).setText(weight);
			if (gender.compareTo("M") == 0) {
				maleRB.setChecked(true);
			} else if (gender.compareTo("F") == 0) {
				femaleRB.setChecked(true);
			}
		}

		maleRB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				maleRB.setChecked(true);
				femaleRB.setChecked(false);
			}
		});

		femaleRB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				maleRB.setChecked(false);
				femaleRB.setChecked(true);
			}
		});

		skip_cancelBut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(UserInfoActivity.this,
						MainActivity.class));
			}

		});

		saveBut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				name = ((EditText) findViewById(R.id.ui_name_edit)).getText()
						.toString();
				age = ((EditText) findViewById(R.id.ui_age_edit)).getText()
						.toString();
				heightFt = ((EditText) findViewById(R.id.ui_feetHeight_edit))
						.getText().toString();
				heightIn = ((EditText) findViewById(R.id.ui_inchHeight_edit))
						.getText().toString();
				weight = ((EditText) findViewById(R.id.ui_weight_edit))
						.getText().toString();
				if (maleRB.isChecked()) {
					gender = "M"; // m = male
				} else if (femaleRB.isChecked()) {
					gender = "F"; // f = female
				}

				if (name.isEmpty() || age.isEmpty() || gender.isEmpty()) {
					Toast.makeText(UserInfoActivity.this,
							"Please complete all require fields (mark with *)",
							Toast.LENGTH_SHORT).show();
				} else {

					if (editProf) {
						pdb.updateProfile(new User(name, age, gender, heightFt,
								heightIn, weight));
						Toast.makeText(UserInfoActivity.this,
								"Profile Updated", Toast.LENGTH_SHORT).show();
					} else {
						time = String.valueOf(System.currentTimeMillis() / 1000.0);
						pdb.createProfile(new User(name, age, gender, heightFt,
								heightIn, weight, time));
						Toast.makeText(UserInfoActivity.this,
								"Profile Created", Toast.LENGTH_SHORT).show();
					}
					pdb.close();
					startActivity(new Intent(UserInfoActivity.this,
							MainActivity.class));
				}

			}

		});
	}

	public void assembleCreatedProfile() {
		User user = pdb.getProfile();

		name = user.getName();
		age = user.getAge();
		gender = user.getGender();
		heightFt = user.getHeightFt();
		heightIn = user.getHeightIn();
		weight = user.getWeight();
		time = user.getProfileCreateTime();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
}
