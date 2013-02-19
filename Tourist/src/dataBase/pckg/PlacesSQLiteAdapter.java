package dataBase.pckg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class PlacesSQLiteAdapter {

	public static final String DATABASE_NAME = "tourist.db";
	public static final String PLACES_TABLE = "PlacesTable";
	
	public static final String GOVERNATES_TABLE = "GovernatesTable";
	public static final String KEY_ID = "gov_id";
	public static final String KEY_CONTENT = "Content";
	
	public static final int DATABASE_VERSION = 1;
	public static final String KEY_PLACES_ID = "Place_ID";
	public static final String KEY_PLACES_NAME = "Place_Name";
	//public static final String KEY_DESCRIPTION = "descripe";
//	public static final String KEY_IMAGE = "image";

	// create table MY_DATABASE (ID integer primary key, Content text not null);
	private static final String SCRIPT_CREATE_DATABASE = "create table "
			+ PLACES_TABLE + " (" + KEY_PLACES_ID + " integer primary key , "
			+ KEY_PLACES_NAME + " text not null);";
	// KEY_DESCRIPTION+ " text not null"+ KEY_IMAGE + " BLOB

	private SQLiteHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;
	private Context context;
	public PlacesSQLiteAdapter(Context c) {
		context = c;
	}

	
	public PlacesSQLiteAdapter openToRead()throws android.database.SQLException
	{
		sqLiteHelper = new SQLiteHelper(context, DATABASE_NAME, null,DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();
		return this;
	}

	public PlacesSQLiteAdapter openToWrite()throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, DATABASE_NAME, null,DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		sqLiteHelper.close();
	}

	
//public long addEntry(String content) {
//
//		ContentValues contentValues = new ContentValues();
//		contentValues.put(KEY_NAME, content);
//
//		return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
//}

	// insert id , name , description, image for a place
	public void addPlaceEntry(int id, String name ) throws SQLiteException{
	    ContentValues contentValues = new  ContentValues();
	    contentValues.put(KEY_PLACES_ID,    id);
	    contentValues.put(KEY_PLACES_NAME,    name);
	   // contentValues.put(KEY_DESCRIPTION,    descrip);
	  // ,byte[] image ..  contentValues.put(KEY_IMAGE,   image);
	    sqLiteDatabase.insert( PLACES_TABLE, null, contentValues );
	}

	// insert gov
	public void addGovernateEntry(int id, String name ) throws SQLiteException{
	    ContentValues contentValues = new  ContentValues();
	    contentValues.put(KEY_ID,    id);
	    contentValues.put(KEY_CONTENT,    name);
	   //  ,byte[] image   ...... contentValues.put(KEY_IMAGE,   image);
	    sqLiteDatabase.insert( GOVERNATES_TABLE, null, contentValues );
	}
	
	public int deleteAll() {
		return sqLiteDatabase.delete(PLACES_TABLE, null, null);
	}

	public Cursor queueAll() {
		String[] columns = new String[] { KEY_PLACES_ID, KEY_PLACES_NAME};
		Cursor cursor = sqLiteDatabase.query(PLACES_TABLE, columns, null,
				null, null, null, null);

		return cursor;
	}

	public class SQLiteHelper extends SQLiteOpenHelper {

		public SQLiteHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(SCRIPT_CREATE_DATABASE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}

}