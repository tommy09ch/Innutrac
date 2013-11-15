package com.innutrac.poly.innutrac.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProfileDatabase {
	ProfileDB handler;
	SQLiteDatabase db;
	private final Context ctx;

	public ProfileDatabase(Context contx) {
		this.ctx = contx;
	}

	public class ProfileDB extends SQLiteOpenHelper {
		private static final int DATABASE_VERSION = 1;

		private static final String TABLE_PROFILE = "profile_table";
		private static final String COLUMN_PROFILE_ID = "id";
		private static final String COLUMN_PROFILE_NAME = "name";
		private static final String COLUMN_PROFILE_AGE = "age";
		private static final String COLUMN_PROFILE_SEX = "sex";
		private static final String COLUMN_PROFILE_HEIGHT_FT = "height_ft";
		private static final String COLUMN_PROFILE_HEIGHT_IN = "height_in";
		private static final String COLUMN_PROFILE_WEIGHT = "weight";
		private static final String COLUMN_PROFILE_CREATE_TIME = "create_time";
		private static final String COLUMN_PROFILE_RECOMMENTED_CALORIES = "calories";
		private static final String COLUMN_PROFILE_RECOMMENTED_CARBCARBOHYDRATE = "carbcarbohydrate";
		private static final String COLUMN_PROFILE_RECOMMENTED_CHOLESTEROL = "cholesterol";
		private static final String COLUMN_PROFILE_RECOMMENTED_FATS = "fats";
		private static final String COLUMN_PROFILE_RECOMMENTED_FIBER = "fiber";
		private static final String COLUMN_PROFILE_RECOMMENTED_PROTEIN = "protein";
		private static final String COLUMN_PROFILE_RECOMMENTED_SODIUM = "sodium";
		private static final String COLUMN_PROFILE_RECOMMENTED_SUGAR = "sugar";

		private static final String CREATE_PROFILE_TABLE = 
				"CREATE TABLE " + TABLE_PROFILE + "(" + 
				COLUMN_PROFILE_ID + " INTEGER PRIMARY KEY," + 						// 0
				COLUMN_PROFILE_NAME	+ " TEXT," + 									// 1
				COLUMN_PROFILE_AGE + " TEXT," + 									// 2
				COLUMN_PROFILE_SEX + " TEXT," + 									// 3
				COLUMN_PROFILE_HEIGHT_FT + " TEXT," + 								// 4
				COLUMN_PROFILE_HEIGHT_IN + " TEXT,"	+ 								// 5
				COLUMN_PROFILE_WEIGHT + " TEXT," + 									// 6
				COLUMN_PROFILE_CREATE_TIME + " TEXT," + 							// 7
				
				COLUMN_PROFILE_RECOMMENTED_CALORIES + " TEXT," + 					// 8
				COLUMN_PROFILE_RECOMMENTED_CARBCARBOHYDRATE	+ " TEXT," + 			// 9
				COLUMN_PROFILE_RECOMMENTED_CHOLESTEROL + " TEXT," + 				// 10
				COLUMN_PROFILE_RECOMMENTED_FATS + " TEXT," + 						// 11
				COLUMN_PROFILE_RECOMMENTED_FIBER + " TEXT," + 						// 12
				COLUMN_PROFILE_RECOMMENTED_PROTEIN + " TEXT,"	+ 					// 13
				COLUMN_PROFILE_RECOMMENTED_SODIUM + " TEXT," + 						// 14
				COLUMN_PROFILE_RECOMMENTED_SUGAR + " TEXT" + ")";					// 15

		public ProfileDB(Context context, String dbName) {
			super(context, dbName, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_PROFILE_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
			onCreate(db);
		}
	}
	
	public ProfileDatabase open(String name) throws SQLException {
		handler = new ProfileDB(ctx, name);
		db = handler.getWritableDatabase();
		return this;
	}
	
	public void close() {
		if (db != null && db.isOpen()) {
			db.close();
			handler.close();
		}
	}
	
	public void createProfile(User user) {
        ContentValues values = new ContentValues();
        values.put(ProfileDB.COLUMN_PROFILE_NAME, user.getName()); 
        values.put(ProfileDB.COLUMN_PROFILE_AGE, user.getAge());
        values.put(ProfileDB.COLUMN_PROFILE_SEX, user.getGender()); 
        values.put(ProfileDB.COLUMN_PROFILE_HEIGHT_FT, user.getHeightFt());
        values.put(ProfileDB.COLUMN_PROFILE_HEIGHT_IN, user.getHeightIn());
        values.put(ProfileDB.COLUMN_PROFILE_WEIGHT, user.getWeight());
        values.put(ProfileDB.COLUMN_PROFILE_CREATE_TIME, user.getProfileCreateTime());
        
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_CALORIES, user.getRecommentedCal()); 
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_CARBCARBOHYDRATE, user.getRecommentedCarb());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_CHOLESTEROL, user.getRecommentedChol()); 
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_FATS, user.getRecommentedFat());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_FIBER, user.getRecommentedFib());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_PROTEIN, user.getRecommentedProt());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_SODIUM, user.getRecommentedSod());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_SUGAR, user.getRecommentedSug());
        db.insert(ProfileDB.TABLE_PROFILE, null,values );
	}
	
	public void updateProfile(User user) {
		// Just updating name, age, sex, height ft, height in, weight
		ContentValues values = new ContentValues();
        values.put(ProfileDB.COLUMN_PROFILE_NAME, user.getName()); 
        values.put(ProfileDB.COLUMN_PROFILE_AGE, user.getAge());
        values.put(ProfileDB.COLUMN_PROFILE_SEX, user.getGender()); 
        values.put(ProfileDB.COLUMN_PROFILE_HEIGHT_FT, user.getHeightFt());
        values.put(ProfileDB.COLUMN_PROFILE_HEIGHT_IN, user.getHeightIn());
        values.put(ProfileDB.COLUMN_PROFILE_WEIGHT, user.getWeight());
        
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_CALORIES, user.getRecommentedCal()); 
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_CARBCARBOHYDRATE, user.getRecommentedCarb());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_CHOLESTEROL, user.getRecommentedChol()); 
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_FATS, user.getRecommentedFat());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_FIBER, user.getRecommentedFib());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_PROTEIN, user.getRecommentedProt());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_SODIUM, user.getRecommentedSod());
        values.put(ProfileDB.COLUMN_PROFILE_RECOMMENTED_SUGAR, user.getRecommentedSug());
        db.update(ProfileDB.TABLE_PROFILE, values, ProfileDB.COLUMN_PROFILE_ID + "=" + 1, null);
    }
	
	public User getProfile() {
		User user = new User();
		String selectQuery = "SELECT  * FROM " + ProfileDB.TABLE_PROFILE;
		Cursor cur = db.rawQuery(selectQuery, null);
		if (cur.moveToFirst()) {
			do {
				user.setProfileID(Integer.parseInt(cur.getString(0)));
				user.setName(cur.getString(1));
				user.setAge(cur.getString(2)); 
				user.setGender(cur.getString(3));
				user.setHeightFt(cur.getString(4));
				user.setHeightIn(cur.getString(5));
				user.setWeight(cur.getString(6));
				user.setProfileCreateTime(cur.getString(7));
				
				user.setRecommentedCal(cur.getString(8));
				user.setRecommentedCarb(cur.getString(9));
				user.setRecommentedChol(cur.getString(10)); 
				user.setRecommentedFat(cur.getString(11));
				user.setRecommentedFib(cur.getString(12));
				user.setRecommentedProt(cur.getString(13));
				user.setRecommentedSod(cur.getString(14));
				user.setRecommentedSug(cur.getString(15));
			} while (cur.moveToNext());
		}
		return user;
	}
}