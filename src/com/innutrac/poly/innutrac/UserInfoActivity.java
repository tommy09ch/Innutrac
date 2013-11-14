package com.innutrac.poly.innutrac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	String recProtein = "", recCarb = "", recSodium = "", recChloe = "", recSugar = "",
		   recFatMax = "",recFatMin = "", recFiber= "", recCalories = "";
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
		editProf = prev.equalsIgnoreCase("Main");

		if (editProf) {
			skip_cancelBut.setText("Cancel");
			editProf = false;
		}
		if (checkIfProfileExist(false)) {
			assembleCreatedProfile();
			((EditText) findViewById(R.id.ui_name_edit)).setText(name);
			((EditText) findViewById(R.id.ui_age_edit)).setText(age);
			((EditText) findViewById(R.id.ui_feetHeight_edit))
					.setText(heightFt);
			((EditText) findViewById(R.id.ui_inchHeight_edit))
					.setText(heightIn);
			((EditText) findViewById(R.id.ui_weight_edit)).setText(weight);
			if (gender.equalsIgnoreCase("m")) {
				maleRB.setChecked(true);
			} else if (gender.equalsIgnoreCase("f")) {
				femaleRB.setChecked(true);
			}
		}

		maleRB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				gender = "m";
				maleRB.setChecked(true);
				femaleRB.setChecked(false);
			}
		});

		femaleRB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				gender = "f";
				femaleRB.setChecked(true);
				maleRB.setChecked(false);
			}
		});

		skip_cancelBut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pdb.close();
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

				if (name.isEmpty() || age.isEmpty() || gender.isEmpty()) {
					Toast.makeText(UserInfoActivity.this,
							"Please complete all require fields (mark with *)",
							Toast.LENGTH_SHORT).show();
				} else {

					if (checkIfProfileExist(false)) {
						pdb.updateProfile(new User(name, age, gender, heightFt,
								heightIn, weight, time));

						Toast.makeText(UserInfoActivity.this,
								"Profile Updated", Toast.LENGTH_SHORT).show();
					} else {
						checkIfProfileExist(true);
						time = String.valueOf(System.currentTimeMillis());
						pdb.createProfile(new User(name, age, gender, heightFt,
								heightIn, weight, time));

						Toast.makeText(UserInfoActivity.this,
								"Profile Created", Toast.LENGTH_SHORT).show();
					}
					pdb.close();
					//setting recValues
					calcRecValues();
					System.out.println(recProtein + " " + recCarb + " " + recSodium + " " + recChloe
							 + " " + recSugar + " " + recFatMin + " " + recFatMin  + " " + recFiber + " " + recCalories);
					//
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

	public boolean checkIfProfileExist(boolean create) {
		String sdPath = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		File cache = new File(sdPath + "/Innutrac/prof/cache");

		if (cache.exists()) {
			return true;
		} else {
			if (create) {
				File dir = new File(sdPath + "/Innutrac/prof");
				dir.mkdirs();
				cache = new File(dir, "cache");
				try {
					FileOutputStream f = new FileOutputStream(cache);
					f.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			pdb.close();
			onBackPressed();
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
	
	private void calcRecValues() {
		int ageInt = Integer.parseInt(this.age);
		//convert weight to kilograms
		double weightInt = Integer.parseInt(this.weight) * 0.453592;
		double temp = 0;
		
		//set calories
		recCalories = "2000";
		//set carbohydrates
		recCarb = "130";
		//set sugar max
		recSugar = "55";
		
		//set sodium
		if(ageInt <= 50)
			recSodium = "1.5";
		if(ageInt <= 70)
			recSodium = "1.3";
		if(ageInt > 70)
			recSodium = "1.2";
		
		//set fat
		recFatMax = "77";
		if(ageInt <= 18)
			recFatMin = "55";
		else
			recFatMin = "44";
		
		//set protein
		if(!(weight.equals("") && gender.equals(""))) {
			if(gender.equals("m")) {
				if(ageInt <= 13)
					temp = 0.76 * weightInt;
				if(ageInt <= 18)
					temp = 0.73 * weightInt;
				if(ageInt > 18)
					temp = 0.66 * weightInt;
			}
			
			else {
				if(ageInt <= 13)
					temp = 0.76 * weightInt;
				if(ageInt <= 18)
					temp = 0.71 * weightInt;
				if(ageInt > 18)
					temp = 0.66 * weightInt;
			}
			recProtein = String.valueOf(temp);
		}
		
		//set fiber
		if(gender.equals("m")) {
			if(ageInt <= 13)
				recFiber = "31";
			if(ageInt <= 50)
				recFiber = "38";
			if(ageInt > 50)
				recFiber = "30";
		}
		
		else {
			if(ageInt <= 18)
				recFiber = "26";
			if(ageInt <= 50)
				recFiber = "25";
			if(ageInt > 50)
				recFiber = "21";
		}
	}
	
}
