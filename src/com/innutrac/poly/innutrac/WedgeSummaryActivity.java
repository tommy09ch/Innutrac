package com.innutrac.poly.innutrac;

import java.util.ArrayList;

import com.innutrac.poly.innutrac.database.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.*;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class WedgeSummaryActivity extends Activity {
	TextView maxRDI, todayIn;
	ListView listView;
	DailyPlan dp;
	ArrayList<Food> foodList;
	private String nutGroupName = "Blank";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wedge_summary);
		maxRDI = ((TextView) findViewById(R.id.max_rdi_TV));
		todayIn = ((TextView) findViewById(R.id.today_intake_TV));
		listView = ((ListView) findViewById(R.id.foodListView));
		setUpTitleAndBackground();

	}

	@SuppressWarnings("unchecked")
	public void setUpTitleAndBackground() {
		nutGroupName = getIntent().getStringExtra("title");
		dp = (DailyPlan) getIntent().getSerializableExtra("dp");
		foodList = (ArrayList<Food>) getIntent().getSerializableExtra("foodList");
		
		System.out.println(foodList.toString());
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle(nutGroupName);

		int actionBarTitleId = Resources.getSystem().getIdentifier(
				"action_bar_title", "id", "android");
		if (actionBarTitleId > 0) {
			TextView title = (TextView) findViewById(actionBarTitleId);
			if (title != null) {
				title.setTextColor(Color.parseColor("#ffffff"));
			}
		}

		if (nutGroupName.equalsIgnoreCase("Carbohydrates")) {// dark blue
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ff0099cc")));
			maxRDI.setText(String.valueOf(dp.getTotalCarbohydrate()));
			todayIn.setText(String.valueOf(dp.getCurrentCarbohydrate()));
		} else if (nutGroupName.equalsIgnoreCase("Protein")) { // light blue
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ff33b5e5")));
			maxRDI.setText(String.valueOf(dp.getTotalProtein()));
			todayIn.setText(String.valueOf(dp.getCurrentProtein()));
		} else if (nutGroupName.equalsIgnoreCase("Sodium")) {// dark green
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ff669900")));
			maxRDI.setText(String.valueOf(dp.getTotalSodium()));
			todayIn.setText(String.valueOf(dp.getCurrentSodium()));
		} else if (nutGroupName.equalsIgnoreCase("Cholesterol")) {// light green
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ff99cc00")));
			maxRDI.setText(String.valueOf(dp.getTotalCholesterol()));
			todayIn.setText(String.valueOf(dp.getCurrentCholesterol()));
		} else if (nutGroupName.equalsIgnoreCase("Fat")) {// dark orange
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ffff8800")));
			maxRDI.setText(String.valueOf(dp.getTotalFats()));
			todayIn.setText(String.valueOf(dp.getCurrentFats()));
		} else if (nutGroupName.equalsIgnoreCase("Sugar")) {// light orange
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ffffbb33")));
			maxRDI.setText(String.valueOf(dp.getTotalSugar()));
			todayIn.setText(String.valueOf(dp.getCurrentSugar()));
		} else if (nutGroupName.equalsIgnoreCase("Fiber")) {// dark red
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ffcc0000")));
			maxRDI.setText(String.valueOf(dp.getTotalFiber()));
			todayIn.setText(String.valueOf(dp.getCurrentFiber()));
		} else if (nutGroupName.equalsIgnoreCase("Calories")) {// light red
			getActionBar().setBackgroundDrawable(
					new ColorDrawable(Color.parseColor("#ffff4444")));
			maxRDI.setText(String.valueOf(dp.getTotalCalories()));
			todayIn.setText(String.valueOf(dp.getCurrentCalories()));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wedge_summary, menu);
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
