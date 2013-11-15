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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WedgeSummaryActivity extends Activity {
	TextView maxRDI, todayIn;
	ListView listView;
	DailyPlan dp;
	private String nutGroupName = "Blank";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wedge_summary);
		maxRDI = ((TextView) findViewById(R.id.max_rdi_TV));
		todayIn = ((TextView) findViewById(R.id.today_intake_TV));
		listView = ((ListView) findViewById(R.id.foodListView));
		setUpTitleAndBackground();

		// Object[] array = assembleFoodsRelatedToGroup();
		//
		// @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
		// ArrayAdapter adapter = new ArrayAdapter(this,
		// android.R.layout.simple_expandable_list_item_1, array) {
		// @Override
		// public View getView(int position, View convertView, ViewGroup parent)
		// {
		// View view = super.getView(position, convertView, parent);
		//
		// TextView textView = (TextView) view
		// .findViewById(android.R.id.text1);
		//
		// /* YOUR CHOICE OF COLOR */
		// textView.setTextColor(Color.parseColor("#C7C244"));
		//
		// return view;
		// }
		// };
		//
		// listView.setAdapter(adapter);
	}

	public void setUpTitleAndBackground() {
		nutGroupName = getIntent().getStringExtra("title");
		dp = (DailyPlan) getIntent().getSerializableExtra("dp");
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
			maxRDI.setText(String.valueOf(dp.getTotalCarbcarbohydrate()));
			todayIn.setText(String.valueOf(dp.getCurrentCarbcarbohydrate()));
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

//	public Object[] assembleFoodsRelatedToGroup() {
//
//		ArrayList<Food> foodList = dp.getFoodList();
//		ArrayList<Food> groupFood = new ArrayList<Food>();
//
//		for (int i = 0; i < foodList.size(); i++) {
//			Food food = foodList.get(i);
//			if (nutGroupName.equalsIgnoreCase("Carbohydrates")) {
//				if (!food.getCarbcarbohydrate().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			} else if (nutGroupName.equalsIgnoreCase("Protein")) {
//				if (!food.getProtein().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			} else if (nutGroupName.equalsIgnoreCase("Sodium")) {
//				if (!food.getSodium().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			} else if (nutGroupName.equalsIgnoreCase("Cholesterol")) {
//				if (!food.getCholesterol().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			} else if (nutGroupName.equalsIgnoreCase("Fat")) {
//				if (!food.getFats().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			} else if (nutGroupName.equalsIgnoreCase("Sugar")) {
//				if (!food.getSugar().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			} else if (nutGroupName.equalsIgnoreCase("Fiber")) {
//				if (!food.getFiber().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			} else if (nutGroupName.equalsIgnoreCase("Calories")) {
//				if (!food.getCalories().equals("0.0")) {
//					groupFood.add(food);
//					break;
//				}
//			}
//		}
//
//		return groupFood.toArray();
//	}

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
