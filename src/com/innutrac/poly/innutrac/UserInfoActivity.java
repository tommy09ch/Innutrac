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
			weight = "", dimX = "", dimY = "", time = "";
	boolean editProf = false;

	ProfileDatabaseSupport pdb;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_info);
		setTitle("User Profile");

		final RadioButton maleRB = (RadioButton) findViewById(R.id.ui_male_radbut);
		final RadioButton femaleRB = (RadioButton) findViewById(R.id.ui_female_radbut);
		Button saveBut = (Button) findViewById(R.id.ui_save_but);
		Button skip_cancelBut = (Button) findViewById(R.id.ui_skip_but);

		pdb = new ProfileDatabaseSupport(this);
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
			//commented out because causing crashes
			//if (gender.compareToIgnoreCase("M") == 0) {
			//	maleRB.setChecked(true);
			//} else if (gender.compareToIgnoreCase("F") == 0) {
			//	femaleRB.setChecked(true);
			//}
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
								heightIn, weight, dimX, dimY, time));
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
		//dimX = user.getDisplayX();
		//dimY = user.getDisplayY();
		time = user.getProfileCreateTime();
	}

	// public void saveToFile(String value) {
	//
	// String sdPath = Environment.getExternalStorageDirectory()
	// .getAbsolutePath();
	// File file = new File(sdPath + "/Innutrac/User/user_info.dat");
	// if (file.exists()) {
	// // do nothing
	// } else {
	// File dir = new File(sdPath + "/Innutrac/User");
	// dir.mkdirs();
	// file = new File(dir, "user_info.dat");
	// }
	//
	// try {
	// FileWriter fw = new FileWriter(file, true);
	// BufferedWriter bw = new BufferedWriter(fw);
	// bw.write(value);
	// bw.newLine();
	// bw.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	// public void readFromFile() {
	// String sdPath = Environment.getExternalStorageDirectory()
	// .getAbsolutePath();
	// File file = new File(sdPath + "/Innutrac/User/user_info.dat");
	// if (!file.exists()) {
	// File dir = new File(sdPath + "/Innutrac/User");
	// dir.mkdirs();
	// file = new File(dir, "user_info.dat");
	// } else {
	// try {
	// FileReader fr = new FileReader(file);
	// BufferedReader br = new BufferedReader(fr);
	// name = br.readLine();
	// age = br.readLine();
	// gender = br.readLine();
	// heightFt = br.readLine();
	// heightIn = br.readLine();
	// weight = br.readLine();
	// br.readLine();
	// br.close();
	// file.delete();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_info, menu);
		return true;
	}

}
