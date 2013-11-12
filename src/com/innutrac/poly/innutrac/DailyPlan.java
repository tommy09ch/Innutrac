package com.innutrac.poly.innutrac;

import java.util.ArrayList;

import com.innutrac.poly.innutrac.database.Food;

public class DailyPlan {
	private double totalCarbcarbohydrate;
	private double totalProtein;
	private double totalSodium;
	private double totalCholesterol;
	private double totalFats;
	private double totalSugar;
	private double totalFiber;
	private double totalCalories;
	ArrayList<Food> foodList = new ArrayList<Food>();

	/**
	 * Constructor to initialize all the "total___" for each of the food groups
	 * when the object is created for each new day.
	 * 
	 */
	public DailyPlan(double totalCarbcarbohydrate, double totalProtein,
			double totalSodium, double totalCholesterol, double totalFats,
			double totalSugar, double totalFiber, double totalCalories) {
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

	public DailyPlan() {
		// TODO Auto-generated constructor stub
	}

	public void eatFood(Food food) {
		totalCarbcarbohydrate -= Double.parseDouble(food.getCarbcarbohydrate());
		totalProtein -= Double.parseDouble(food.getProtein());
		totalSodium -= Double.parseDouble(food.getSodium());
		totalCholesterol -= Double.parseDouble(food.getCholesterol());
		totalFats -= Double.parseDouble(food.getFats());
		totalSugar -= Double.parseDouble(food.getSugar());
		totalFiber -= Double.parseDouble(food.getFiber());
		totalCalories -= Double.parseDouble(food.getCalories());

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

	public double getTotalCarbcarbohydrate() {
		return totalCarbcarbohydrate;
	}

	public void setTotalCarbcarbohydrate(int totalCarbcarbohydrate) {
		this.totalCarbcarbohydrate = totalCarbcarbohydrate;
	}

	public double getTotalProtein() {
		return totalProtein;
	}

	public void setTotalProtein(int totalProtein) {
		this.totalProtein = totalProtein;
	}

	public double getTotalSodium() {
		return totalSodium;
	}

	public void setTotalSodium(int totalSodium) {
		this.totalSodium = totalSodium;
	}

	public double getTotalCholesterol() {
		return totalCholesterol;
	}

	public void setTotalCholesterol(int totalCholesterol) {
		this.totalCholesterol = totalCholesterol;
	}

	public double getTotalFats() {
		return totalFats;
	}

	public void setTotalFats(int totalFats) {
		this.totalFats = totalFats;
	}

	public double getTotalSugar() {
		return totalSugar;
	}

	public void setTotalSugar(int totalSugar) {
		this.totalSugar = totalSugar;
	}

	public double getTotalFiber() {
		return totalFiber;
	}

	public void setTotalFiber(int totalFiber) {
		this.totalFiber = totalFiber;
	}

	public double getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(int totalCalories) {
		this.totalCalories = totalCalories;
	}
}