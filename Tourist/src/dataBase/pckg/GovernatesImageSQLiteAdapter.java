package dataBase.pckg;
import java.io.ByteArrayOutputStream;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class GovernatesImageSQLiteAdapter {         
    private static final String DATABASE_NAME = "myDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String USERDETAILS=
                "create table userdetails(usersno integer primary key autoincrement,userid text not null ,username text not null,password text not null,photo BLOB,visibility text not null);";
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    public GovernatesImageSQLiteAdapter(Context ctx)     {
        this.context = ctx;
     DBHelper = new DatabaseHelper(context);
    }
       
    private static class DatabaseHelper extends SQLiteOpenHelper     {
        DatabaseHelper(Context context)         {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db)         {
                db.execSQL(USERDETAILS);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion,    int newVersion)         {
                db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
    }   
 
    public GovernatesImageSQLiteAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }
  
    public void close()     {
                DBHelper.close();
    }
    //public long insertUserDetails(String uname,String userid, String pass, byte[] photo,String visibility)
    public long insertUserDetails( byte[] photo
    		)
    {
        ContentValues initialValues = new ContentValues();
//        initialValues.put("username", uname);
//        initialValues.put("userid",userid);
//        initialValues.put("password", pass);
        initialValues.put("photo",photo);
        //initialValues.put("visibility",visibility);
        return db.insert("userdetails", null, initialValues);
    }
  
 public Cursor getUserDetails(String userid)    {
                return db.rawQuery("select username,userid,photo,visibility ,usersno from userdetails where userid='"+userid+"'",null);
    }
    public int updateUserDetails(String userid,String username,byte[] photo,String visibility)    {
                ContentValues args = new ContentValues();
        args.put("username", username);
        args.put("photo",photo);
        args.put("visibility",visibility);
        return db.update("userdetails", args,"userid='" +userid+"'", null);
    }  
    public Cursor searchFriends(String username,String to_userid)    {
                return db.rawQuery("select userid,username,photo,usersno from userdetails where username LIKE '%"+username+"%' AND userid <>'"+to_userid+"' AND userid NOT IN (select request_destinationid from requestdetails where request_sourceid='"+to_userid+"' and status=1)",null);
    }
    public void deleteFriend(int l_userid,int dest_userid)   {
                db.delete("requestdetails","request_sourceid="+l_userid+" and request_destinationid="+dest_userid+" and status=1", null);
                db.delete("requestdetails","request_sourceid="+dest_userid+" and request_destinationid="+l_userid+" and status=1", null);
    }
}
