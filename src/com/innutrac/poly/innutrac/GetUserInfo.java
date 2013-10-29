package com.innutrac.poly.innutrac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

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
				// TODO Auto-generated method stub
				maleRB.setChecked(true);
				femaleRB.setChecked(false);
			}

		});

		femaleRB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				maleRB.setChecked(false);
				femaleRB.setChecked(true);
			}

		});

		Button save = (Button) findViewById(R.id.save_user_button);
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String gender = "";
				String name = "";
				String age = "";

				name = findViewById(R.id.profileNameField).toString();
				age = findViewById(R.id.profAgeField).toString();
				if (findViewById(R.id.profMaleRButton).isSelected()) {
					gender = "M";
				} else {
					gender = "F";
				}

				Person person = new Person();
				person.setAge(age);
				person.setName(name);
				person.setGender(gender);
				
				
				Intent i = new Intent(GetUserInfo.this, MainActivity.class);
				startActivity(i);
			}
		});

	
		Button skip = (Button) findViewById(R.id.skip_user_button);
		skip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(GetUserInfo.this, MainActivity.class);
				startActivity(i);				
			}});

	}
}
