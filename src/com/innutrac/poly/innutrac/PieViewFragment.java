package com.innutrac.poly.innutrac;

import java.util.ArrayList;

import com.innutrac.poly.innutrac.database.*;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PieViewFragment extends Fragment {
	LinearLayout pieContainer;
	int factor = 1;
	private PieView pie;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_pie, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		pieContainer = (LinearLayout) getView().findViewById(
				R.id.pie_container_id);
		pie = new PieView(getActivity());
		pie.setMode(factor);
		pieContainer.addView(pie);

		pieContainer.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				String name = "";
				boolean checker = false;
				float x = event.getX();
				float y = event.getY();
				// will send touch location to PieView and appropriately change
				// to detail view
				switch (pie.wedgeDetect(x, y)) {
				case 1:
					name = "Sodium";
					checker = true;
					break;
				case 2:
					name = "Carbohydrates";
					checker = true;
					break;
				case 3:
					name = "Protein";
					checker = true;
					break;
				case 4:
					name = "Calories";
					checker = true;
					break;
				case 5:
					name = "Fiber";
					checker = true;
					break;
				case 6:
					name = "Fat";
					checker = true;
					break;
				case 7:
					name = "Sugar";
					checker = true;
					break;
				case 8:
					name = "Cholesterol";
					checker = true;
					break;
				default:
					checker = false;// do nothing
				}
				if (checker) {
					DailyPlan dp = ((MainActivity) getActivity())
							.getTodayDailyPlan();

					ArrayList<Food> foodList = ((MainActivity) getActivity())
							.getTodayFoodList();

					startActivity(new Intent(getActivity(),
							WedgeSummaryActivity.class).putExtra("title", name)
							.putExtra("dp", dp).putExtra("foodList", foodList));
				}
				return false;
			}
		});
	}
}