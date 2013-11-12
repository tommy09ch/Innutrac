package com.innutrac.poly.innutrac.database;

/**
//Nutrients Database Handler.
//
//Because this is an existing database that ships with the app, handling it is a 
//little bit more complicated. Instead of just opening the database, there is
//an additional step required. When the database is first opened, this class will
//copy the database from the app's package file into the app's data folder
//on the device's disk. 
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NutrientsDatabase extends SQLiteOpenHelper {
	 private static String DB_PATH;	//Path to the app's data folder in the device's memory. NOT THE .APKG FILE.
	 private static String DB_FILE = "nutrients.db";	//Name of nutrients database
	 private SQLiteDatabase dbRef;	//Reference to the SQLiteDatabase object
	 private final Context ctx;	//Context for the database call
	 
	 //Constructor. All we need is the context, the other information is predefined here.
	 public NutrientsDatabase(Context context) {
		super(context, DB_FILE, null, 1);
		this.ctx = context;
		//Define the app's data directory path where the db is going to be stored permanently
		this.DB_PATH = context.getApplicationInfo().dataDir +"/databases/";
		Log.d("DEBUG:", "Constructor called. DB_PATH: "+DB_PATH);
	}
	 
	 //Opens the database.
	 //Android cannot access the database from the app's package file, so it will need to copy it to the
	 //app's data folder on disk.
	 public void open() {
		 boolean dbExist = checkDatabaseExists();	//Check to see if db has been copied to data folder already
		 if(! dbExist ) //Must be first run, or db has mysteriously disappeared
		 { 
			 this.getReadableDatabase(); //Creates blank database where we want it. We will overwrite it later.
			 Log.d("DEBUG:", "DB Check failed. Creating empty db at "+this.getReadableDatabase().getPath());
			 try
			 {
				 //Now we overwrite the blank db created above with our predefined one
				 copyDatabase();
			 }
			 catch( IOException e)
			 {
				 //Error copying database!
				 Log.d("DB COPY ERROR:", e.getMessage());
			 }
			 
		 }
		 //set reference to database.
		 dbRef = SQLiteDatabase.openDatabase(DB_PATH + DB_FILE, null, SQLiteDatabase.OPEN_READONLY);
		 Log.d("DEBUG:", "DB Ready.");
	 }
	 @Override
	 public synchronized void close() 
	 {
			 if( dbRef != null )
				 dbRef.close();
			 super.close();
	  
	 }
	 
	 //Copies the database from the app package folder to its data folder.
	 //This is only ran if the database is missing from the disk...on first use of app.
	 private void copyDatabase() throws IOException {
			//Open pre-defined db in package file.
		 	Log.d("DEBUG:", "Copying DB. Opening master... ");
			InputStream dbMaster = ctx.getAssets().open(DB_FILE); 
			 
			// Path to the just created empty db
			String dbNew = DB_PATH + DB_FILE;
			 
			//Open the empty db as the output stream
			Log.d("DEBUG:", "Copying DB. Opening copy... ");
			OutputStream dbCopy = new FileOutputStream(dbNew);
			Log.d("DEBUG:", "Copying DB. Copying... ");
			//transfer bytes from the master copy to the new copy
			byte[] buffer = new byte[1024];
			int length;
			while ((length = dbMaster.read(buffer))>0){
			dbCopy.write(buffer, 0, length);
			}
			 
			//Close the streams
			dbCopy.flush();
			dbCopy.close();
			dbMaster.close();
			Log.d("DEBUG:", "Copying DB. Done. ");
	}

	 	//Checks to see if the database exists in the app's datafolder.
	    // Should return true if the app has been run before.
		private boolean checkDatabaseExists() {
			 SQLiteDatabase checkDB = null;
			 try
			 {
				 String path = DB_PATH + DB_FILE;
				 Log.d("DEBUG:", "Looking for DB at path: "+path);
				 checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
			  
			 }
			 catch(SQLiteException e)
			 {
				 Log.d("DEBUG:", "DB not found. needs to be copied.");
			 }
			  
			 if(checkDB != null)	//if checkDB == null, then the database was not found.
			 {
				 Log.d("DEBUG:", "DB found. all is well");
				 checkDB.close();	//We found it and opened the connection. Now close it. This was only a test. 
			 } 
			 return checkDB != null ? true : false;	//Return the proper result
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			//Don't you dare do anything.
			
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// Do nothing. Don't touch my db!
			
		}
		 
		 
}