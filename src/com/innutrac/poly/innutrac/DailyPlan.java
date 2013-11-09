package com.innutrac.poly.innutrac;

import java.util.ArrayList;

import com.innutrac.poly.innutrac.database.Food;

public class DailyPlan {
	private int totalCarbcarbohydrate;
	private int totalProtein;
	private int totalSodium;
	private int totalCholesterol;
	private int totalFats;
	private int totalSugar;
	private int totalFiber;
	private int totalCalories;
	ArrayList<Food> foodList = new ArrayList<Food>();

	/**
	 * Constructor to initialize all the "total___" for each of the food groups
	 * when the object is created for each new day.
	 * 
	 */
	public DailyPlan(int totalCarbcarbohydrate, int totalProtein,
			int totalSodium, int totalCholesterol, int totalFats,
			int totalSugar, int totalFiber, int totalCalories) {
		super();
		this.totalCarbcarbohydrate = totalCarbcarbohydrate;
		this.totalProtein = totalProtein;
		this.totalSodium = totalSodium;
		this.totalCholesterol = totalCholesterol;
		this.totalFats = totalFats;
		this.totalSugar = totalSugar;
		this.totalFiber = totalFiber;
		this.totalCalories = totalCalories;
	}

	public void eatFood(Food food) {
		totalCarbcarbohydrate -= Integer.parseInt(food.getCarbcarbohydrate());
		totalProtein -= Integer.parseInt(food.getProtein());
		totalSodium -= Integer.parseInt(food.getSodium());
		totalCholesterol -= Integer.parseInt(food.getCholesterol());
		totalFats -= Integer.parseInt(food.getFats());
		totalSugar -= Integer.parseInt(food.getSugar());
		totalFiber -= Integer.parseInt(food.getFiber());
		totalCalories -= Integer.parseInt(food.getCalories());

		// add the eaten food to the arrayList for saving.
		foodList.add(food);
	}

	// Setters and Getters
	public ArrayList<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(ArrayList<Food> foodList) {
		this.foodList = foodList;
	}

	public int getTotalCarbcarbohydrate() {
		return totalCarbcarbohydrate;
	}

	public void setTotalCarbcarbohydrate(int totalCarbcarbohydrate) {
		this.totalCarbcarbohydrate = totalCarbcarbohydrate;
	}

	public int getTotalProtein() {
		return totalProtein;
	}

	public void setTotalProtein(int totalProtein) {
		this.totalProtein = totalProtein;
	}

	public int getTotalSodium() {
		return totalSodium;
	}

	public void setTotalSodium(int totalSodium) {
		this.totalSodium = totalSodium;
	}

	public int getTotalCholesterol() {
		return totalCholesterol;
	}

	public void setTotalCholesterol(int totalCholesterol) {
		this.totalCholesterol = totalCholesterol;
	}

	public int getTotalFats() {
		return totalFats;
	}

	public void setTotalFats(int totalFats) {
		this.totalFats = totalFats;
	}

	public int getTotalSugar() {
		return totalSugar;
	}

	public void setTotalSugar(int totalSugar) {
		this.totalSugar = totalSugar;
	}

	public int getTotalFiber() {
		return totalFiber;
	}

	public void setTotalFiber(int totalFiber) {
		this.totalFiber = totalFiber;
	}

	public int getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(int totalCalories) {
		this.totalCalories = totalCalories;
	}
}