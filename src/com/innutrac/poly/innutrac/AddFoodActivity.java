package com.innutrac.poly.innutrac;

import com.innutrac.poly.innutrac.database.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView.OnEditorActionListener;
import android.widget.SeekBar.*;

public class AddFoodActivity extends Activity {
	FoodDatabase fdb;
	NutrientsDatabase ndb;
	DecimalFormat df = new DecimalFormat("#.##");

	private String name = "", serving_size = "", calories = "0",
			carbcarbohydrate = "0", cholesterol = "0", fats = "0", fiber = "0",
			protein = "0", sodium = "0", sugar = "0", time = "", usdaId = "";

	// static private DailyPlan dailyPlan = new DailyPlan();

	/**
	 * Still need to add the following to this Activity: - getting existing food
	 * data from food/nutrient db - some algorithm that predict the food the
	 * user is typing in - some algorithm to recommend food to user
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_food);

		final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		final SeekBar bar = (SeekBar) findViewById(R.id.af_size_seekBar);
		final EditText sizeET = (EditText) findViewById(R.id.servingSize_ET);
		final AutoCompleteTextView foodNameET = (AutoCompleteTextView) findViewById(R.id.foodName_ET);

		fdb = new FoodDatabase(this);
		fdb.open("FoodRecord");
		ndb = new NutrientsDatabase(this);
		ndb.open();

		final Object[] array = assembleFoodName();

		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_dropdown_item_1line, array);
		foodNameET.setAdapter(adapter);
		foodNameET.setThreshold(3);
		foodNameET.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Food selectedFood = getSpecifiedFood(foodNameET.getText()
						.toString());
				assembleDataFromFoodDB(selectedFood);
				sizeET.setText(Double.toString(1.0));
				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
						0);
			}

		});

		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				double val = (progress) / 10.0;
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
				if (!name.isEmpty()) {
					double size = Double.parseDouble(sizeET.getText()
							.toString());
					adjustNutrientsInfo(size);
				}
			}

		});

		sizeET.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				bar.setProgress((int) Double.parseDouble((sizeET.getText()
						.toString())) * 10);
				double size = Double.parseDouble(sizeET.getText().toString());
				adjustNutrientsInfo(size);
				return false;
			}

		});

		// Inflate a "Done/Discard" custom action bar view.
		LayoutInflater inflater = (LayoutInflater) getActionBar()
				.getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
		final View customActionBarView = inflater.inflate(
				R.layout.actionbar_custom_view_done_discard, null);
		customActionBarView.findViewById(R.id.actionbar_done)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if (name.isEmpty() || serving_size.equals("0.0")) {
							Toast.makeText(
									AddFoodActivity.this,
									"Invalid input, please check the fields for food name and serving size.",
									Toast.LENGTH_SHORT).show();
						} else {
							Food eatenFood = getFoodUserInput();
							fdb.addToFoodRecord(eatenFood);
							fdb.close();
							ndb.close();
							startActivity(new Intent(AddFoodActivity.this,
									MainActivity.class).putExtra("addFood",
									"true"));
							finish(); // end activity
						}
					}
				});
		customActionBarView.findViewById(R.id.actionbar_discard)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// "Discard"
						finish();
					}
				});

		// Show the custom action bar view and hide the normal Home icon and
		// title.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
				ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
						| ActionBar.DISPLAY_SHOW_TITLE);
		actionBar.setCustomView(customActionBarView,
				new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));

	} // onCreate end

	public Food getFoodUserInput() {
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

		time = String.valueOf(System.currentTimeMillis());
		return new Food(name, serving_size, calories, carbcarbohydrate,
				cholesterol, fats, fiber, protein, sodium, sugar, usdaId, time);
	}

	public void assembleDataFromFoodDB(Food selectedFood) {
		this.calories = selectedFood.getCalories();
		this.calories = chkNullStr(calories) ? "0.0" : calories;
		this.carbcarbohydrate = selectedFood.getCarbohydrate();
		this.carbcarbohydrate = chkNullStr(carbcarbohydrate) ? "0.0"
				: carbcarbohydrate;
		this.cholesterol = selectedFood.getCholesterol();
		this.cholesterol = chkNullStr(cholesterol) ? "0.0" : cholesterol;
		this.fats = selectedFood.getFats();
		this.fats = chkNullStr(fats) ? "0.0" : fats;
		this.fiber = selectedFood.getFiber();
		this.fiber = chkNullStr(fiber) ? "0.0" : fiber;
		this.protein = selectedFood.getProtein();
		this.protein = chkNullStr(protein) ? "0.0" : protein;
		this.sodium = selectedFood.getSodium();
		this.sodium = chkNullStr(sodium) ? "0.0" : sodium;
		this.sugar = selectedFood.getSugar();
		this.sugar = chkNullStr(sugar) ? "0.0" : sugar;

		((EditText) findViewById(R.id.cal_ET)).setText(df.format(Double
				.parseDouble(calories)));
		((EditText) findViewById(R.id.carb_ET)).setText(df.format(Double
				.parseDouble(carbcarbohydrate)));
		((EditText) findViewById(R.id.chol_ET)).setText(df.format(Double
				.parseDouble(cholesterol)));
		((EditText) findViewById(R.id.fat_ET)).setText(df.format(Double
				.parseDouble(fats)));
		((EditText) findViewById(R.id.fib_ET)).setText(df.format(Double
				.parseDouble(fiber)));
		((EditText) findViewById(R.id.prot_Et)).setText(df.format(Double
				.parseDouble(protein)));
		((EditText) findViewById(R.id.sodi_ET)).setText(df.format(Double
				.parseDouble(sodium)));
		((EditText) findViewById(R.id.sug_ET)).setText(df.format(Double
				.parseDouble(sugar)));

		this.name = selectedFood.getName();
		this.usdaId = selectedFood.getUasdDBID();
	}

	public Food getSpecifiedFood(String name) {
		Food food = new Food();

		String query = "SELECT food_name, energy, carbs, cholesterol, fat, fiber, protein, sodium, sugar, NDB_No FROM usda_foods "
				+ "WHERE food_name = ?";
		Cursor cur = ndb.getReadableDatabase().rawQuery(query,
				new String[] { name });
		if (cur.moveToFirst()) {
			do {
				food.setName(cur.getString(0));
				food.setServing_size("1");
				food.setCalories(cur.getString(1));
				food.setCarbohydrate(cur.getString(2));
				food.setCholesterol(cur.getString(3));
				food.setFats(cur.getString(4));
				food.setFiber(cur.getString(5));
				food.setProtein(cur.getString(6));
				food.setSodium(cur.getString(7));
				food.setSugar(cur.getString(8));
				food.setUasdDBID(cur.getString(9));
			} while (cur.moveToNext());
		}

		return food;
	}

	public Object[] assembleFoodName() {
		ArrayList<String> foodList = new ArrayList<String>();
		Cursor cur = ndb.getReadableDatabase().rawQuery(
				"SELECT food_name FROM usda_foods", null);
		if (cur.moveToFirst()) {
			do {
				foodList.add(cur.getString(0));
			} while (cur.moveToNext());
		}

		return foodList.toArray();
	}

	private void adjustNutrientsInfo(double size) {

		((EditText) findViewById(R.id.cal_ET)).setText(df.format(Double
				.parseDouble(calories) * size));
		((EditText) findViewById(R.id.carb_ET)).setText(df.format(Double
				.parseDouble(carbcarbohydrate) * size));
		((EditText) findViewById(R.id.chol_ET)).setText(df.format(Double
				.parseDouble(cholesterol) * size));
		((EditText) findViewById(R.id.fat_ET)).setText(df.format(Double
				.parseDouble(fats) * size));
		((EditText) findViewById(R.id.fib_ET)).setText(df.format(Double
				.parseDouble(fiber) * size));
		((EditText) findViewById(R.id.prot_Et)).setText(df.format(Double
				.parseDouble(protein) * size));
		((EditText) findViewById(R.id.sodi_ET)).setText(df.format(Double
				.parseDouble(sodium) * size));
		((EditText) findViewById(R.id.sug_ET)).setText(df.format(Double
				.parseDouble(sugar) * size));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.add_food, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			fdb.close();
			ndb.close();
			onBackPressed();
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

	public boolean chkNullStr(String str) {
		if (str == null || str.isEmpty() || str.equals("0"))
			return true;
		else
			return false;
	}
}
