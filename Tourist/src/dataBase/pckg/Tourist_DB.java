package dataBase.pckg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class Tourist_DB {

	public static final String DATABASE_NAME = "tourist.db";
	public static final int DATABASE_VERSION = 1;

	// Places Table Variables
	public static final String PLACES_TABLE = "PlacesTable";
	public static final String KEY_PLACES_ID = "_id";
	public static final String KEY_PLACES_NAME = "Place_Name";
	public static final String KEY_PLACES_IMAGE = "Place_Image";
	public static final String KEY_GOV_ID = "Gov_ID";

	// Governates Table Variables
	public static final String GOVERNATES_TABLE = "GovernatesTable";
	public static final String KEY_GOVERNATES_ID = "_id";
	public static final String KEY_GOVERNATES_NAME = "Governates_Name";
	public static final String KEY_GOVERNATES_IMAGE = "Governates_Image";

	// Place Describtion Table Variables
	public static final String KEY_PLACES_DESCRIBE = "Place_Describe";
	
	

	// ***********************************  Create Place Table     **********************************

	// create Places Table (ID integer primary key, name text not null , Blop image);
	private static final String CREATE_PLACES_TABLE = "create table "
			+ PLACES_TABLE + " (" + KEY_PLACES_ID + " integer primary key , "
			+ KEY_PLACES_NAME + " text not null ," + KEY_PLACES_IMAGE + " BLOB ,"+ KEY_GOV_ID + " integer );";
           
	
	// To Add New Place
	public void addPlaceEntry(int id, String name)
			throws SQLiteException {
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_PLACES_ID, id);
		contentValues.put(KEY_PLACES_NAME, name); 
		// , byte[] imag  contentValues.put(KEY_PLACES_IMAGE, image);   
		//, int Gov_id  contentValues.put(KEY_GOV_ID, Gov_id); 
		sqLiteDatabase.insert(PLACES_TABLE, null, contentValues);
	}

	// to select row from places table
	public Cursor PlaceRow() {
		String[] columns = new String[] { KEY_PLACES_ID, KEY_PLACES_NAME };
		Cursor cursor = sqLiteDatabase.query(PLACES_TABLE, columns, null, null,
				null, null, null);
		return cursor;
	}

	// to delete data from table
	public int deletePlaces() {
		return sqLiteDatabase.delete(PLACES_TABLE, null, null);
	}

	// ************************   Create Governates Table    ************************************************************

	// create Governates Table (ID integer primary key, name text not null , Blop image);
	private static final String CREATE_GOVERNATES_TABLE = "create table "
			+ GOVERNATES_TABLE + " (" + KEY_GOVERNATES_ID+ " integer primary key , " + KEY_GOVERNATES_NAME+ " text not null ," + KEY_GOVERNATES_IMAGE + " BLOB);";


	// To Add New Governate
	public void addGovernateEntry(int id, String name, byte[] image)
			throws SQLiteException {
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_GOVERNATES_ID, id);
		contentValues.put(KEY_GOVERNATES_NAME, name);
		contentValues.put(KEY_GOVERNATES_IMAGE, image);
		sqLiteDatabase.insert(GOVERNATES_TABLE, null, contentValues);
	}

	// to select row from governate table
	public Cursor GovernateRow() {
		String[] columns = new String[] { KEY_GOVERNATES_ID,KEY_GOVERNATES_NAME,KEY_GOVERNATES_IMAGE };
		Cursor cursor = sqLiteDatabase.query(GOVERNATES_TABLE, columns, null,
				null, null, null, null);
		return cursor;
	}

	// to delete data from table
	public int deleteGovernates() {
		return sqLiteDatabase.delete(GOVERNATES_TABLE, null, null);
	}

	// **********************************************************************************************
	private SQLiteHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;
	private Context context;

	public Tourist_DB(Context c) {
		context = c;
	}

	public class SQLiteHelper extends SQLiteOpenHelper {

		public SQLiteHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(CREATE_PLACES_TABLE);
			db.execSQL(CREATE_GOVERNATES_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}

	// To Open DB and Read from it
	public Tourist_DB openToRead() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, DATABASE_NAME, null,
				DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();
		return this;
	}

	// To Open DB and Write on it
	public Tourist_DB openToWrite() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, DATABASE_NAME, null,
				DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();
		return this;
	}

	// To close DB connection
	public void close() {
		sqLiteHelper.close();
	}

}