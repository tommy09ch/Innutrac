package com.innutrac.poly.innutrac;

public class PieWedge 
{
	float startAngle;
	float sweep;
	String color;
	
	public PieWedge()
	{
		startAngle = 0f;
		sweep = 0f;
		color = null;
	}
	public PieWedge(float start, float sw, String col)
	{
		startAngle = start;
		sweep = sw;
		color = col;
	}
	void setStartAngle(float s)
	{
		startAngle = s;
	}
	void setSweep(float s)
	{
		sweep = s;
	}
	void setColor(String s)
	{
		color = s;
	}
	float getStartAngle()
	{
		return startAngle;
	}
	float getSweep()
	{
		return sweep;
	}
	String getColor()
	{
		return color;
	}
}
