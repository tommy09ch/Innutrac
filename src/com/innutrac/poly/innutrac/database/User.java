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

	public User() {
		// Empty Constructor
	}

	public User(int pid, String n, String a, String g, String hf, String hi,
			String w, String t) {
		profileID = pid;
		name = n;
		age = a;
		gender = g;
		heightFt = hf;
		heightIn = hi;
		weight = w;
		profileCreateTime = t;
	}

	public User(String n, String a, String g, String hf, String hi, String w,
			String t) {
		name = n;
		age = a;
		gender = g;
		heightFt = hf;
		heightIn = hi;
		weight = w;
		profileCreateTime = t;
	}

	public User(String n, String a, String g, String hf, String hi, String w) {
		name = n;
		age = a;
		gender = g;
		heightFt = hf;
		heightIn = hi;
		weight = w;
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
}
