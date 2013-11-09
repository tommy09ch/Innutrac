package com.innutrac.poly.innutrac;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HistoryFragment extends Fragment{
	
	
	LineGraph lg;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.history_graph, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		lg = (LineGraph)getView().findViewById(R.id.linegraph);
		
		Line l = new Line();
		Line limit_line = new Line();
		LinePoint p = new LinePoint();
		
		//draw the limit line
		limit_line.setShowingPoints(false);
		p.setX(0);
		p.setY(5);
		limit_line.addPoint(p);
		p=new LinePoint();
		p.setX(10);
		p.setY(5);
		limit_line.addPoint(p);
		limit_line.setColor(Color.parseColor("#FFBB33"));
		//
		
		p =new LinePoint();
		p.setX(0);
		p.setY(4);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(2);
		p.setY(8);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(3);
		p.setY(6);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(5);
		p.setY(4);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(7);
		p.setY(8);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(10);
		p.setY(4);
		l.addPoint(p);
		l.setColor(Color.GREEN);
		
		lg.addLine(l);
		lg.addLine(limit_line);
		lg.setRangeY(0, 10);
		lg.setLineToFill(0);
	}

}