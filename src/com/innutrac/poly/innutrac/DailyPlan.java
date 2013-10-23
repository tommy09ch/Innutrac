package com.innutrac.poly.innutrac;

import java.util.ArrayList;

public class DailyPlan {
	private int totalCarbs;
	private int totalProtein;
	private int totalSodium;
	private int totalCholesterol;
	private int totalFats;
	private int totalSugar;
	private int totalFiber;
	private int totalCalories;
	ArrayList<Food> foodList = new ArrayList<Food>();

	/**
	 * Constructor to initialize all the "total___" for each of the food groups.
	 * 
	 * @param carb
	 * @param pro
	 * @param sod
	 * @param chol
	 * @param fat
	 * @param sug
	 * @param fib
	 * @param cal
	 */
	public DailyPlan(int carb, int pro, int sod, int chol, int fat, int sug,
			int fib, int cal) {
		
		totalCarbs = carb;
		totalProtein = pro;
		totalSodium = sod;
		totalCholesterol = chol;
		totalFats = fat;
		totalSugar = sug;
		totalFiber = fib;
		totalCalories = cal;
	}

	public void eatFood(Food food) {
		totalCarbs -= food.getCarb();
		totalProtein -= food.getProtein();
		totalSodium -= food.getSodium();
		totalCholesterol -= food.getCholesterol();
		totalFats -= food.getFats();
		totalSugar -= food.getSugar();
		totalFiber -= food.getFiber();
		totalCalories -= food.getCalories();

		// add the eaten food to the arrayList for saving.
		foodList.add(food);
	}
}
