package dataBase.pckg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class GovernatesSQLiteAdapter {

public static final String MYDATABASE_NAME = "tourist.db";
public static final String DATABASE_TABLE = "GovTable";
public static final int MYDATABASE_VERSION = 1;
public static final String KEY_ID = "_id";
public static final String KEY_CONTENT = "Content";

//public static final String KEY_IMAGE = "image";

//create table MY_DATABASE (ID integer primary key, Content text not null);
//private static final String SCRIPT_CREATE_DATABASE =
//"create table " + DATABASE_TABLE + " ("+ KEY_ID + " integer primary key , "+ KEY_CONTENT + " text not null);";

private SQLiteHelper sqLiteHelper;
private SQLiteDatabase sqLiteDatabase;

private Context context;

public GovernatesSQLiteAdapter(Context c){
context = c;
}

public GovernatesSQLiteAdapter openToRead() throws android.database.SQLException {
sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
sqLiteDatabase = sqLiteHelper.getReadableDatabase();
return this;
}

public GovernatesSQLiteAdapter openToWrite() throws android.database.SQLException {
sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
sqLiteDatabase = sqLiteHelper.getWritableDatabase();
return this;
}

public void close(){
sqLiteHelper.close();
}

// add new governate
	public void addGovernateEntry(int id, String name ) throws SQLiteException{
	    ContentValues contentValues = new  ContentValues();
	    contentValues.put(KEY_ID,    id);
	    contentValues.put(KEY_CONTENT,    name);
	   //  ,byte[] image   ...... contentValues.put(KEY_IMAGE,   image);
	    sqLiteDatabase.insert( DATABASE_TABLE, null, contentValues );
	}


public int deleteAll(){
return sqLiteDatabase.delete(DATABASE_TABLE, null, null);
}

public Cursor queueAll(){
	String[] columns = new String[] { KEY_ID, KEY_CONTENT };
Cursor cursor = sqLiteDatabase.query(DATABASE_TABLE, columns,
  null, null, null, null, null);

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
 //db.execSQL(SCRIPT_CREATE_DATABASE);
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 // TODO Auto-generated method stub

}

}


}