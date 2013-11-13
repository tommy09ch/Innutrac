package com.innutrac.poly.innutrac.database;

public class Food implements Comparable<Food> {

	private String name;
	private String serving_size;
	private String calories;
	private String carbcarbohydrate;
	private String cholesterol;
	private String fats;
	private String fiber;
	private String protein;
	private String sodium;
	private String sugar;

	private String entryID;
	private String usdaDBID;
	private String eatTime;

	public Food(String name, String serving_size, String calories,
			String carbcarbohydrate, String cholesterol, String fats,
			String fiber, String protein, String sodium, String sugar,
			String entryID, String uasdDBID, String eatTime) {
		super();
		this.name = name;
		this.serving_size = serving_size;
		this.calories = calories;
		this.carbcarbohydrate = carbcarbohydrate;
		this.cholesterol = cholesterol;
		this.fats = fats;
		this.fiber = fiber;
		this.protein = protein;
		this.sodium = sodium;
		this.sugar = sugar;
		this.entryID = entryID;
		this.usdaDBID = uasdDBID;
		this.eatTime = eatTime;
	}

	public Food(String name, String serving_size, String calories,
			String carbcarbohydrate, String cholesterol, String fats,
			String fiber, String protein, String sodium, String sugar,
			String usdaDBID, String eatTime) {
		super();
		this.name = name;
		this.serving_size = serving_size;
		this.calories = calories;
		this.carbcarbohydrate = carbcarbohydrate;
		this.cholesterol = cholesterol;
		this.fats = fats;
		this.fiber = fiber;
		this.protein = protein;
		this.sodium = sodium;
		this.sugar = sugar;
		this.usdaDBID = usdaDBID;
		this.eatTime = eatTime;
	}

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServing_size() {
		return serving_size;
	}

	public void setServing_size(String serving_size) {
		this.serving_size = serving_size;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getCarbcarbohydrate() {
		return carbcarbohydrate;
	}

	public void setCarbcarbohydrate(String carbcarbohydrate) {
		this.carbcarbohydrate = carbcarbohydrate;
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

	public String getFiber() {
		return fiber;
	}

	public void setFiber(String fiber) {
		this.fiber = fiber;
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

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getEntryID() {
		return entryID;
	}

	public void setEntryID(String entryID) {
		this.entryID = entryID;
	}

	public String getUasdDBID() {
		return usdaDBID;
	}

	public void setUasdDBID(String uasdDBID) {
		this.usdaDBID = uasdDBID;
	}

	public String getEatTime() {
		return eatTime;
	}

	public void setEatTime(String eatTime) {
		this.eatTime = eatTime;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Food another) {
		return this.name.compareToIgnoreCase(another.name);
	}
}