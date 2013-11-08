package com.innutrac.poly.innutrac.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProfileDatabaseSupport {
	ProfileDB handler;
	SQLiteDatabase db;
	private final Context ctx;

	public ProfileDatabaseSupport(Context contx) {
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
		private static final String COLUMN_PROFILE_DISPLAY_X = "display_x";
		private static final String COLUMN_PROFILE_DISPLAY_Y = "display_y";
		private static final String COLUMN_PROFILE_CREATE_TIME = "create_time";

//		private static final String TABLE_FOODREC = "food_records";
//		private static final String COLUMN_FOODREC_ID = "id";
//		private static final String COLUMN_FOODREC_FOODID = "food_id";
//		private static final String COLUMN_FOODREC_AMOUNT = "amount";
//		private static final String COLUMN_FOODREC_TIME = "time";

		private static final String CREATE_PROFILE_TABLE = 
				"CREATE TABLE " + TABLE_PROFILE + "(" + 
				COLUMN_PROFILE_ID + " INTEGER PRIMARY KEY," + 
				COLUMN_PROFILE_NAME	+ " TEXT," + 
				COLUMN_PROFILE_AGE + " TEXT," + 
				COLUMN_PROFILE_SEX + " TEXT," + 
				COLUMN_PROFILE_HEIGHT_FT + " TEXT," + 
				COLUMN_PROFILE_HEIGHT_IN + " TEXT,"	+ 
				COLUMN_PROFILE_WEIGHT + " TEXT," + 
				COLUMN_PROFILE_DISPLAY_X + " TEXT,"	+ 
				COLUMN_PROFILE_DISPLAY_Y + " TEXT,"	+ 
				COLUMN_PROFILE_CREATE_TIME + " TEXT" + ")";
		
//		private static final String CREATE_FOODREC_TABLE = 
//				"CREATE TABLE " + TABLE_FOODREC + "(" +
//				COLUMN_FOODREC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//				COLUMN_FOODREC_FOODID + " INTEGER," +
//				COLUMN_FOODREC_AMOUNT + " REAL," +
//				COLUMN_FOODREC_TIME + " NUMERIC" + ")";

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
	
	public ProfileDatabaseSupport open(String name) throws SQLException {
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
        values.put(ProfileDB.COLUMN_PROFILE_DISPLAY_X, user.getDisplayX());
        values.put(ProfileDB.COLUMN_PROFILE_DISPLAY_Y, user.getDisplayY());
        values.put(ProfileDB.COLUMN_PROFILE_CREATE_TIME, user.getProfileCreateTime());
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
				user.setDisplayX(cur.getString(7));
				user.setDisplayY(cur.getString(8));
				user.setProfileCreateTime(cur.getString(9));
			} while (cur.moveToNext());
		}
		return user;
	}
}
