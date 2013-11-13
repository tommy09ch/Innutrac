package com.innutrac.poly.innutrac;

import java.io.Serializable;
import java.util.ArrayList;

import com.innutrac.poly.innutrac.database.Food;

@SuppressWarnings("serial")
public class DailyPlan implements Serializable {
	private double totalCarbcarbohydrate;
	private double totalProtein;
	private double totalSodium;
	private double totalCholesterol;
	private double totalFats;
	private double totalSugar;
	private double totalFiber;
	private double totalCalories;

	private double currentCarbcarbohydrate;
	private double currentProtein;
	private double currentSodium;
	private double currentCholesterol;
	private double currentFats;
	private double currentSugar;
	private double currentFiber;
	private double currentCalories;
	//ArrayList<Food> foodList = new ArrayList<Food>();

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

		currentCarbcarbohydrate = 0;
		currentProtein = 0;
		currentSodium = 0;
		currentCholesterol = 0;
		currentFats = 0;
		currentSugar = 0;
		currentFiber = 0;
		currentCalories = 0;
	}

	public DailyPlan() {
		// TODO Auto-generated constructor stub
	}

	public void eatFood(Food food) {
		currentCarbcarbohydrate += Double.parseDouble(food
				.getCarbcarbohydrate());
		currentProtein += Double.parseDouble(food.getProtein());
		currentSodium += Double.parseDouble(food.getSodium());
		currentCholesterol += Double.parseDouble(food.getCholesterol());
		currentFats += Double.parseDouble(food.getFats());
		currentSugar += Double.parseDouble(food.getSugar());
		currentFiber += Double.parseDouble(food.getFiber());
		currentCalories += Double.parseDouble(food.getCalories());

		// add the eaten food to the arrayList for saving.
		//foodList.add(food);
	}

	// Setters and Getters
//	public ArrayList<Food> getFoodList() {
//		return foodList;
//	}

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

	public double getCurrentCarbcarbohydrate() {
		return currentCarbcarbohydrate;
	}

	public void setCurrentCarbcarbohydrate(double currentCarbcarbohydrate) {
		this.currentCarbcarbohydrate = currentCarbcarbohydrate;
	}

	public double getCurrentProtein() {
		return currentProtein;
	}

	public void setCurrentProtein(double currentProtein) {
		this.currentProtein = currentProtein;
	}

	public double getCurrentSodium() {
		return currentSodium;
	}

	public void setCurrentSodium(double currentSodium) {
		this.currentSodium = currentSodium;
	}

	public double getCurrentCholesterol() {
		return currentCholesterol;
	}

	public void setCurrentCholesterol(double currentCholesterol) {
		this.currentCholesterol = currentCholesterol;
	}

	public double getCurrentFats() {
		return currentFats;
	}

	public void setCurrentFats(double currentFats) {
		this.currentFats = currentFats;
	}

	public double getCurrentSugar() {
		return currentSugar;
	}

	public void setCurrentSugar(double currentSugar) {
		this.currentSugar = currentSugar;
	}

	public double getCurrentFiber() {
		return currentFiber;
	}

	public void setCurrentFiber(double currentFiber) {
		this.currentFiber = currentFiber;
	}

	public double getCurrentCalories() {
		return currentCalories;
	}

	public void setCurrentCalories(double currentCalories) {
		this.currentCalories = currentCalories;
	}

	public String getAllCurInfo() {
		return currentCarbcarbohydrate + "\n" + currentProtein + "\n"
				+ currentSodium + "\n" + currentCholesterol + "\n"
				+ currentFats + "\n" + currentSugar + "\n" + currentFiber
				+ "\n" + currentCalories;
	}
}