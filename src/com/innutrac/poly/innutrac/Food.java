package com.innutrac.poly.innutrac;

public class Food {
	private String name;
	private int carb;
	private int protein;
	private int sodium;
	private int cholesterol;
	private int fats;
	private int sugar;
	private int fiber;
	private int calories;
	private int foodDBID;
	private int entryID;
	private int eatTime;

	// Simple getter and setter methods
	
	public Food( String n, int car, int prot, int sodi, int chol, int fa, int sug, int fib, int cal, int fdb, int eid, int cTime)
	{
		name = n;
		carb = car;
		protein = prot;
		sodium = sodi;
		cholesterol = chol;
		fats = fa;
		sugar = sug;
		fiber = fib;
		calories = cal;
		fiber = fib;
		calories = cal;
		foodDBID = fdb;
		entryID = eid;
		eatTime = cTime;
		
	}

	public void setName(String n) {
		name = n;
	}

	public void setCarb(int c) {
		carb = c;
	}

	public void setSodium(int s) {
		sodium = s;
	}

	public void setCholesterol(int ch) {
		cholesterol = ch;
	}

	public void setFats(int f) {
		fats = f;
	}

	public void setSugar(int sg) {
		sugar = sg;
	}

	public void setFiber(int fib) {
		fiber = fib;
	}

	public void setfoodDbId(int dbid) {
		foodDBID = dbid;
	}

	public void entryID(int eid) {
		entryID = eid;
	}

	public void setEatTime(int time) {
		eatTime = time;
	}

	
	public String getName() {
		return name;
	}

	public int getCarb() {
		return carb;
	}

	public int getProtein() {
		return protein;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public int getFats() {
		return fats;
	}

	public int getSugar() {
		return sugar;
	}

	public int getFiber() {
		return fiber;
	}

	public int getCalories() {
		return calories;
	}
	
	public int getfoodDbId() {
		return foodDBID;
	}
	
	public int getEntryId() {
		return entryID;
	}
	
	public int getEatTime() {
		return eatTime;
	}
}
