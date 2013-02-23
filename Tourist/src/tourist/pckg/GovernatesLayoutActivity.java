package tourist.pckg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import dataBase.pckg.Tourist_DB;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;

import android.widget.ListView;

public class GovernatesLayoutActivity extends Activity {

	private Tourist_DB touristDB;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.governates_layout);
		ListView listContent = (ListView) findViewById(R.id.governatelist);

		/*
		 * Create/Open a SQLite database and fill with dummy content and close
		 * it
		 */
		touristDB = new Tourist_DB(this);
		touristDB.openToWrite();
		touristDB.deleteGovernates();

		touristDB.addGovernateEntry(1,"Alexandria");
		touristDB.addGovernateEntry(2,"Aswan");
		touristDB.addGovernateEntry(3,"Asyut");
		touristDB.addGovernateEntry(4,"Beheira");
		touristDB.addGovernateEntry(5,"Beni Suef");
		touristDB.addGovernateEntry(6,"Cairo");
		touristDB.addGovernateEntry(7,"Dakahlia");
		touristDB.addGovernateEntry(8,"Damietta");
		touristDB.addGovernateEntry(9,"Faiyum");
		touristDB.addGovernateEntry(10,"Gharbia");
		touristDB.addGovernateEntry(11,"Giza");
		touristDB.addGovernateEntry(12,"Ismailia");
		touristDB.addGovernateEntry(13,"Kafr el-Sheikh	");
		touristDB.addGovernateEntry(14,"Matruh");
		touristDB.addGovernateEntry(15,"Minya");
		touristDB.addGovernateEntry(16,"Monufia");
		touristDB.addGovernateEntry(17,"New Valley");
		touristDB.addGovernateEntry(18,"North Sinai");
		touristDB.addGovernateEntry(19,"Port Said");
		touristDB.addGovernateEntry(20,"Qalyubia");
		touristDB.addGovernateEntry(21,"UQena");
		touristDB.addGovernateEntry(22,"Red Sea");
		touristDB.addGovernateEntry(23,"Al Sharqia");
		touristDB.addGovernateEntry(24,"Sohag");
		touristDB.addGovernateEntry(25,"South Sinai");
		touristDB.addGovernateEntry(26,"Suez");
		touristDB.addGovernateEntry(27,"Luxor");

		touristDB.close();

		/*
		 * Open the same SQLite database and read all it's content.
		 */
		touristDB = new Tourist_DB(this);
		touristDB.openToRead();

		Cursor cursor = touristDB.GovernateRow();
		startManagingCursor(cursor);

		String[] from = new String[] { Tourist_DB.KEY_GOVERNATES_NAME };
		int[] to = new int[] { R.id.text };

		SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
				R.layout.row, cursor, from, to);

		listContent.setAdapter(cursorAdapter);

		touristDB.close();
		 
		// store image in DB
//		 GovernatesImageSQLiteAdapter db=new GovernatesImageSQLiteAdapter(this);
//		db.open();
//		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
//		Bitmap bitmap = (BitmapDrawable)getResources().getDrawable(R.drawable.common)).getBitmap();
//		bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);  
//		byte[] photo = baos.toByteArray();
//		//db.insertUserDetails(fullName,userid, password, photo,visibility);
//		db.insertUserDetails( photo);
		
		//Retrieve from DB..
//		byte[]  img=cursor.getBlob(..);
//		ByteArrayInputStream imageStream = new ByteArrayInputStream(img);
//		Bitmap theImage= BitmapFactory.decodeStream(imageStream);
//		image_view.setImageBitmap(theImage);

	}

	
}
