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

	// Simple getter and setter methods

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
}
