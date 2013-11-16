package com.innutrac.poly.innutrac.database;

public class User {
	private int profileID;
	private String name;
	private String age;
	private String gender;
	private String heightFt;
	private String heightIn;
	private String weight;
	private String profileCreateTime;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int profileID, String name, String age, String gender,
			String heightFt, String heightIn, String weight,
			String profileCreateTime) {
		super();
		this.profileID = profileID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.heightFt = heightFt;
		this.heightIn = heightIn;
		this.weight = weight;
		this.profileCreateTime = profileCreateTime;
	}

	// Constructor for when creating the user profile
	public User(String name, String age, String gender, String heightFt,
			String heightIn, String weight, String profileCreateTime) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.heightFt = heightFt;
		this.heightIn = heightIn;
		this.weight = weight;
		this.profileCreateTime = profileCreateTime;
	}

	// Constructor for when updating the user profile
	public User(String name, String age, String gender, String heightFt,
			String heightIn, String weight) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.heightFt = heightFt;
		this.heightIn = heightIn;
		this.weight = weight;
	}

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