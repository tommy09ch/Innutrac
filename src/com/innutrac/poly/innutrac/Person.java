package com.innutrac.poly.innutrac;

public class Person {
	private int profileID;
	private String name;
	private int age;
	private boolean gender;
	private int displayX;
	private int displayY;
	private int profileCreateTime;
	
	// getters and setters
	
	public Person(int pid, String n, int a, boolean g, int dX, int dY, int pct)
	{
		profileID = pid;
		name = n;
		age = a;
		gender = g;
		displayX = dX;
		displayY = dY;
		profileCreateTime = pct;
	}
	
	public void setAge(int a) {
		age = a;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setGender(boolean g) {
		gender = g;
	}
	
	public void setDisplayResolution(int x, int y)
	{
		displayX = x;
		displayY = y;
	}
	
	public int getProfileId() {
		return profileID;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getGender() {
		return gender;
	}
	
	public int getDisplayResolutionX()
	{
		return displayX;
	}
	
	public int getDisplayResolutionY()
	{
		return displayY;
	}
	
	public int getCreateTime()
	{
		return profileCreateTime;
	}
}
