package com.innutrac.poly.innutrac;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Activity_AddNewFood extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_food);
		
		SeekBar bar = (SeekBar) findViewById(R.id.sizeBar);
		final EditText sizeET = (EditText) findViewById(R.id.serving_sizeET);
		
		sizeET.setText("1.0");
		
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				double val = (progress+10)/10.0;
				sizeET.setText(Double.toString(val));
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
		
		
		
	}
}
