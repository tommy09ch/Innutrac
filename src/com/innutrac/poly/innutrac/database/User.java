package com.innutrac.poly.innutrac.database;

public class User {
	private int profileID;
	private String name;
	private String age;
	private String gender; // 1 = male, 0 = female
	private String heightFt;
	private String heightIn;
	private String weight;
	private String profileCreateTime;
	private String recommentedCal;
	private String recommentedCarb;
	private String recommentedChol;
	private String recommentedFat;
	private String recommentedFib;
	private String recommentedProt;
	private String recommentedSod;
	private String recommentedSug;

	public User() {
		// Empty Constructor
	}

	public User(int profileID, String name, String age, String gender,
			String heightFt, String heightIn, String weight,
			String profileCreateTime, String recommentedCal,
			String recommentedCarb, String recommentedChol,
			String recommentedFat, String recommentedFib,
			String recommentedProt, String recommentedSod, String recommentedSug) {
		super();
		this.profileID = profileID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.heightFt = heightFt;
		this.heightIn = heightIn;
		this.weight = weight;
		this.profileCreateTime = profileCreateTime;
		this.recommentedCal = recommentedCal;
		this.recommentedCarb = recommentedCarb;
		this.recommentedChol = recommentedChol;
		this.recommentedFat = recommentedFat;
		this.recommentedFib = recommentedFib;
		this.recommentedProt = recommentedProt;
		this.recommentedSod = recommentedSod;
		this.recommentedSug = recommentedSug;
	}

	public User(int profileID, String name, String age, String gender,
			String heightFt, String heightIn, String weight,
			String recommentedCal, String recommentedCarb,
			String recommentedChol, String recommentedFat,
			String recommentedFib, String recommentedProt,
			String recommentedSod, String recommentedSug) {
		super();
		this.profileID = profileID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.heightFt = heightFt;
		this.heightIn = heightIn;
		this.weight = weight;
		this.recommentedCal = recommentedCal;
		this.recommentedCarb = recommentedCarb;
		this.recommentedChol = recommentedChol;
		this.recommentedFat = recommentedFat;
		this.recommentedFib = recommentedFib;
		this.recommentedProt = recommentedProt;
		this.recommentedSod = recommentedSod;
		this.recommentedSug = recommentedSug;
	}

	// getters and setters
	public int getProfileID() {
		return profileID;
	}

	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeightFt() {
		return heightFt;
	}

	public void setHeightFt(String heightFt) {
		this.heightFt = heightFt;
	}

	public String getHeightIn() {
		return heightIn;
	}

	public void setHeightIn(String heightIn) {
		this.heightIn = heightIn;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getProfileCreateTime() {
		return profileCreateTime;
	}

	public void setProfileCreateTime(String profileCreateTime) {
		this.profileCreateTime = profileCreateTime;
	}

	public String getRecommentedCal() {
		return recommentedCal;
	}

	public void setRecommentedCal(String recommentedCal) {
		this.recommentedCal = recommentedCal;
	}

	public String getRecommentedCarb() {
		return recommentedCarb;
	}

	public void setRecommentedCarb(String recommentedCarb) {
		this.recommentedCarb = recommentedCarb;
	}

	public String getRecommentedChol() {
		return recommentedChol;
	}

	public void setRecommentedChol(String recommentedChol) {
		this.recommentedChol = recommentedChol;
	}

	public String getRecommentedFat() {
		return recommentedFat;
	}

	public void setRecommentedFat(String recommentedFat) {
		this.recommentedFat = recommentedFat;
	}

	public String getRecommentedFib() {
		return recommentedFib;
	}

	public void setRecommentedFib(String recommentedFib) {
		this.recommentedFib = recommentedFib;
	}

	public String getRecommentedProt() {
		return recommentedProt;
	}

	public void setRecommentedProt(String recommentedProt) {
		this.recommentedProt = recommentedProt;
	}

	public String getRecommentedSod() {
		return recommentedSod;
	}

	public void setRecommentedSod(String recommentedSod) {
		this.recommentedSod = recommentedSod;
	}

	public String getRecommentedSug() {
		return recommentedSug;
	}

	public void setRecommentedSug(String recommentedSug) {
		this.recommentedSug = recommentedSug;
	}
}