package com.innutrac.poly.innutrac;

import java.io.Serializable;

import com.innutrac.poly.innutrac.database.Food;

public class DailyPlan implements Serializable {
	
	private static final long serialVersionUID = -8981165452660044171L;
	private double totalCalories;
	private double totalCarbohydrate;
	private double totalCholesterol;
	private double totalFats;
	private double totalFiber;
	private double totalProtein;
	private double totalSodium;
	private double totalSugar;

	private double currentCalories;
	private double currentCarbohydrate;
	private double currentCholesterol;
	private double currentFats;
	private double currentFiber;
	private double currentProtein;
	private double currentSodium;
	private double currentSugar;

	private String planId;
	private String planLogTime;

	public DailyPlan(double totalCalories, double totalCarbohydrate,
			double totalCholesterol, double totalFats, double totalFiber,
			double totalProtein, double totalSodium, double totalSugar,
			String planLogTime) {
		super();
		this.totalCalories = totalCalories;
		this.totalCarbohydrate = totalCarbohydrate;
		this.totalCholesterol = totalCholesterol;
		this.totalFats = totalFats;
		this.totalFiber = totalFiber;
		this.totalProtein = totalProtein;
		this.totalSodium = totalSodium;
		this.totalSugar = totalSugar;
		this.planLogTime = planLogTime;

		currentCalories = 0;
		currentCarbohydrate = 0;
		currentCholesterol = 0;
		currentFats = 0;
		currentFiber = 0;
		currentProtein = 0;
		currentSodium = 0;
		currentSugar = 0;
	}

	public DailyPlan() {
		this.totalCarbohydrate = 0;
		this.totalProtein = 0;
		this.totalSodium = 0;
		this.totalCholesterol = 0;
		this.totalFats = 0;
		this.totalSugar = 0;
		this.totalFiber = 0;
		this.totalCalories = 0;

		currentCalories = 0;
		currentCarbohydrate = 0;
		currentCholesterol = 0;
		currentFats = 0;
		currentFiber = 0;
		currentProtein = 0;
		currentSodium = 0;
		currentSugar = 0;
	}

	public void eatFood(Food f) {
		currentCalories += Double.parseDouble(f.getCalories());
		currentCarbohydrate += Double.parseDouble(f.getCarbohydrate());
		currentCholesterol += Double.parseDouble(f.getCholesterol());
		currentFats += Double.parseDouble(f.getFats());
		currentFiber += Double.parseDouble(f.getFiber());
		currentProtein += Double.parseDouble(f.getProtein());
		currentSodium += Double.parseDouble(f.getSodium());
		currentSugar += Double.parseDouble(f.getSugar());
	}

	public double getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(double totalCalories) {
		this.totalCalories = totalCalories;
	}

	public double getTotalCarbohydrate() {
		return totalCarbohydrate;
	}

	public void setTotalCarbohydrate(double totalCarbohydrate) {
		this.totalCarbohydrate = totalCarbohydrate;
	}

	public double getTotalCholesterol() {
		return totalCholesterol;
	}

	public void setTotalCholesterol(double totalCholesterol) {
		this.totalCholesterol = totalCholesterol;
	}

	public double getTotalFats() {
		return totalFats;
	}

	public void setTotalFats(double totalFats) {
		this.totalFats = totalFats;
	}

	public double getTotalFiber() {
		return totalFiber;
	}

	public void setTotalFiber(double totalFiber) {
		this.totalFiber = totalFiber;
	}

	public double getTotalProtein() {
		return totalProtein;
	}

	public void setTotalProtein(double totalProtein) {
		this.totalProtein = totalProtein;
	}

	public double getTotalSodium() {
		return totalSodium;
	}

	public void setTotalSodium(double totalSodium) {
		this.totalSodium = totalSodium;
	}

	public double getTotalSugar() {
		return totalSugar;
	}

	public void setTotalSugar(double totalSugar) {
		this.totalSugar = totalSugar;
	}

	public double getCurrentCalories() {
		return currentCalories;
	}

	public void setCurrentCalories(double currentCalories) {
		this.currentCalories = currentCalories;
	}

	public double getCurrentCarbohydrate() {
		return currentCarbohydrate;
	}

	public void setCurrentCarbohydrate(double currentCarbohydrate) {
		this.currentCarbohydrate = currentCarbohydrate;
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

	public double getCurrentFiber() {
		return currentFiber;
	}

	public void setCurrentFiber(double currentFiber) {
		this.currentFiber = currentFiber;
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

	public double getCurrentSugar() {
		return currentSugar;
	}

	public void setCurrentSugar(double currentSugar) {
		this.currentSugar = currentSugar;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanLogTime() {
		return planLogTime;
	}

	public void setPlanLogTime(String planLogTime) {
		this.planLogTime = planLogTime;
	}

	@Override
	public String toString() {
		return String.valueOf(this.currentCalories);
	}
}