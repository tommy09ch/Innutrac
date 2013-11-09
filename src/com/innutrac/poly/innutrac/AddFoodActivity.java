package com.innutrac.poly.innutrac;

import com.innutrac.poly.innutrac.database.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import android.widget.SeekBar.*;

public class AddFoodActivity extends Activity {
	FoodDatabase fdb;

	private String name = "", serving_size = "", calories = "",
			carbcarbohydrate = "", cholesterol = "", fats = "", fiber = "",
			protein = "", sodium = "", sugar = "", time = "";

	/**
	 * Still need to add the following to this Activity: - getting existing food
	 * data from food/nutrient db - some algorithm that predict the food the
	 * user is typing in - some algorithm to recommend food to user
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_food);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle("Add Food");
		SeekBar bar = (SeekBar) findViewById(R.id.af_size_seekBar);
		final EditText sizeET = (EditText) findViewById(R.id.servingSize_ET);
		
		fdb = new FoodDatabase(this);
		fdb.open("FoodDatabase");
		
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				double val = (progress + 10) / 10.0;
				sizeET.setText(Double.toString(val));

				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
						0);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});

		((Button) findViewById(R.id.af_submit_but))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// ////////////////////////////////////////////////////
						// IMPLEMENT ACTION TO SAVE THE FOOD TO DATABASE /////
						// ////////////////////////////////////////////////////
						startActivity(new Intent(AddFoodActivity.this,
								MainActivity.class));

					}

				});

	}

	public void getValuesFromUserInput() {
		name = ((EditText) findViewById(R.id.foodName_ET)).getText().toString();
		serving_size = ((EditText) findViewById(R.id.servingSize_ET)).getText()
				.toString();
		calories = ((EditText) findViewById(R.id.cal_ET)).getText().toString();
		carbcarbohydrate = ((EditText) findViewById(R.id.carb_ET)).getText()
				.toString();
		cholesterol = ((EditText) findViewById(R.id.chol_ET)).getText()
				.toString();
		fats = ((EditText) findViewById(R.id.fat_ET)).getText().toString();
		fiber = ((EditText) findViewById(R.id.fib_ET)).getText().toString();
		protein = ((EditText) findViewById(R.id.prot_Et)).getText().toString();
		sodium = ((EditText) findViewById(R.id.sodi_ET)).getText().toString();
		sugar = ((EditText) findViewById(R.id.sug_ET)).getText().toString();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_food, menu);
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
