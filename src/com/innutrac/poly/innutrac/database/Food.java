package com.innutrac.poly.innutrac.database;

public class Food {

	private String name;
	private String carbcarbohydrate;
	private String protein;
	private String sodium;
	private String cholesterol;
	private String fats;
	private String sugar;
	private String fiber;
	private String calories;
	private String amount;
	private String foodDBID;
	private String entryID;
	private String eatTime;

	public Food(String name, String carbcarbohydrate, String protein,
			String sodium, String cholesterol, String fats, String sugar,
			String fiber, String calories, String foodDBID, String entryID,
			String eatTime) {
		super();
		this.name = name;
		this.carbcarbohydrate = carbcarbohydrate;
		this.protein = protein;
		this.sodium = sodium;
		this.cholesterol = cholesterol;
		this.fats = fats;
		this.sugar = sugar;
		this.fiber = fiber;
		this.calories = calories;
		this.foodDBID = foodDBID;
		this.entryID = entryID;
		this.eatTime = eatTime;
	}

	// Simple getter and setter methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarbcarbohydrate() {
		return carbcarbohydrate;
	}

	public void setCarbcarbohydrate(String carbcarbohydrate) {
		this.carbcarbohydrate = carbcarbohydrate;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getSodium() {
		return sodium;
	}

	public void setSodium(String sodium) {
		this.sodium = sodium;
	}

	public String getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getFats() {
		return fats;
	}

	public void setFats(String fats) {
		this.fats = fats;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getFiber() {
		return fiber;
	}

	public void setFiber(String fiber) {
		this.fiber = fiber;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getFoodDBID() {
		return foodDBID;
	}

	public void setFoodDBID(String foodDBID) {
		this.foodDBID = foodDBID;
	}

	public String getEntryID() {
		return entryID;
	}

	public void setEntryID(String entryID) {
		this.entryID = entryID;
	}

	public String getEatTime() {
		return eatTime;
	}

	public void setEatTime(String eatTime) {
		this.eatTime = eatTime;
	}
}