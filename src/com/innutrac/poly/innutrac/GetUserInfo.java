package com.innutrac.poly.innutrac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class GetUserInfo extends Activity {
	boolean flag = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get_user_info);
		final RadioButton maleRB = (RadioButton) findViewById(R.id.profMaleRButton);
		final RadioButton femaleRB = (RadioButton) findViewById(R.id.profFemaleRButton);

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

		Button save = (Button) findViewById(R.id.save_user_button);
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String gender = null;
				String name = null;
				String age = null;

				name = ((EditText) findViewById(R.id.profileNameField))
						.getText().toString();
				age = ((EditText) findViewById(R.id.profAgeField)).getText()
						.toString();
				if (maleRB.isChecked()) {
					gender = "M";
				} else if (femaleRB.isChecked()) {
					gender = "F";
				}

				if (name.isEmpty() || gender.isEmpty() || age.isEmpty()) {
					Toast.makeText(GetUserInfo.this, "Please complete all fields", Toast.LENGTH_LONG).show();
				} else {
					saveToFile(name, age, gender);
					
					Toast.makeText(GetUserInfo.this, "Profile Created", Toast.LENGTH_LONG).show();
					Intent i = new Intent(GetUserInfo.this, MainActivity.class);
					startActivity(i);
				}
			}
		});

		Button skip = (Button) findViewById(R.id.skip_user_button);
		skip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(GetUserInfo.this, MainActivity.class);
				startActivity(i);
			}
		});

	}

	public void saveToFile(String n, String a, String g) {

		String sdPath = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		File file = new File(sdPath + "/Innutrac/user_info.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(n);
			bw.write("\n");
			bw.write(a);
			bw.write("\n");
			bw.write(g);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
