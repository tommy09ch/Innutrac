package com.innutrac.poly.innutrac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProfileDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME_PROFILE = "profile.db";
    
    private static final String TABLE_PROFILE = "profile_info"; 
    private static final String KEY_PROFILE_ID = "id";
    private static final String KEY_PROFILE_NAME = "name";
    private static final String KEY_PROFILE_AGE = "age";
    private static final String KEY_PROFILE_SEX = "sex";
    private static final String KEY_PROFILE_CREATE_TIME = "create_time";
    private static final String KEY_PROFILE_DISPLAY_X = "display_x";
    private static final String KEY_PROFILE_DISPLAY_Y = "display_y";
    
    private static final String TABLE_FOODREC = "food_records"; 
    private static final String KEY_FOODREC_ID = "id";
    private static final String KEY_FOODREC_FOODID = "food_id";
    private static final String KEY_FOODREC_AMOUNT = "amount";
    private static final String KEY_FOODREC_TIME = "time";
	
	public ProfileDatabase(Context context) {
		super(context, DATABASE_NAME_PROFILE, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		 // SQL statement to create profile table
        String queryStr = "CREATE TABLE "+TABLE_PROFILE+" ( " +
        		KEY_PROFILE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		KEY_PROFILE_NAME+" TEXT, "+
        		KEY_PROFILE_AGE+" INTEGER, "+
        		KEY_PROFILE_SEX+" INTEGER, "+
        		KEY_PROFILE_DISPLAY_X+" INTEGER, "+
        		KEY_PROFILE_DISPLAY_Y+" INTEGER, "+
        		KEY_PROFILE_CREATE_TIME+" NUMERIC );";
        db.execSQL(queryStr);
        //Now create table for storing food entries
        queryStr = "CREATE TABLE "+TABLE_FOODREC+" ( " +
        		KEY_FOODREC_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		KEY_FOODREC_FOODID+" INTEGER, "+
        		KEY_FOODREC_AMOUNT+" REAL, "+
        		KEY_FOODREC_TIME+" NUMERIC )";
        db.execSQL(queryStr);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Do nothing. Don't delete existing data!
	}
	
	public void addProfile(String name, int age, boolean sex, int displayX, int displayY)
	{
		long time = System.currentTimeMillis() / 1000L;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PROFILE_NAME, name);
        values.put(KEY_PROFILE_AGE, age); 
        values.put(KEY_PROFILE_SEX, ( sex ? 1 : 0));
        values.put(KEY_PROFILE_DISPLAY_X, displayX); 
        values.put(KEY_PROFILE_DISPLAY_Y, displayY); 
        values.put(KEY_PROFILE_CREATE_TIME, time); 
        
        db.insert( TABLE_PROFILE, null,values );
        db.close(); 
	}
	
	public int updateProfile(int profile_id, String name, int age, boolean sex, int displayX, int displayY) 
	{
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PROFILE_NAME, name);
        values.put(KEY_PROFILE_AGE, age); 
        values.put(KEY_PROFILE_SEX, ( sex ? 1 : 0));
        values.put(KEY_PROFILE_DISPLAY_X, displayX); 
        values.put(KEY_PROFILE_DISPLAY_Y, displayY); 

        int i = db.update(TABLE_FOODREC, //table
                values, // column/value
                KEY_PROFILE_ID+" = ?", // selections
                new String[] { String.valueOf(profile_id) }); //selection args

        db.close();
 
        return i;
    }
	
	public Person getProfile(int userID)
	{
		SQLiteDatabase db = this.getReadableDatabase(); 
	    Cursor cursor = db.query(TABLE_PROFILE, new String[] { KEY_PROFILE_ID,KEY_PROFILE_NAME, KEY_PROFILE_AGE, KEY_PROFILE_SEX, KEY_PROFILE_DISPLAY_X, KEY_PROFILE_DISPLAY_Y, KEY_PROFILE_CREATE_TIME }, KEY_PROFILE_ID+" = ?", new String[] { String.valueOf(userID) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
		return new Person(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(3)), Boolean.parseBoolean(cursor.getString(2)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)));
	}
	
	public void addFood(int foodID, double amount)
	{
		addFood(foodID, amount, (System.currentTimeMillis() / 1000L));
	}
	
	public void addFood(int foodID, double amount, long time)
	{
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FOODREC_FOODID, foodID);
        values.put(KEY_FOODREC_AMOUNT, amount); 
        values.put(KEY_FOODREC_TIME, time);
        
        db.insert( TABLE_PROFILE, null,values );
        db.close(); 
	}
	
	public void deleteFood(int entry_id) 
	{
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOODREC,
                KEY_FOODREC_ID+" = ?",
                new String[] { String.valueOf(entry_id) });
        db.close();
    }
	
	public int updateFood(int entry_id, int foodID, double amount, long time) 
	{
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOODREC_FOODID, foodID);
        values.put(KEY_FOODREC_AMOUNT, amount); 
        values.put(KEY_FOODREC_TIME, time);

        int i = db.update(TABLE_FOODREC, //table
                values, // column/value
                KEY_FOODREC_ID+" = ?", // selections
                new String[] { String.valueOf(entry_id) }); //selection args

        db.close();
 
        return i;
    }
	
	public Food[] getFood()
	{
		//Return all food ever
		return null;
	}
	
	public Food[] getFood(int startTime, int endTime)
	{
		//Return food between date range
		return null;
	}
	
	public Food getFood(int id)
	{
		//Return specific entry
		return null;
	}

}
