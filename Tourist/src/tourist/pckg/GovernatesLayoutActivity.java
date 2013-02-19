package tourist.pckg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import dataBase.pckg.GovernatesSQLiteAdapter;
import dataBase.pckg.GovernatesImageSQLiteAdapter;
import dataBase.pckg.PlacesSQLiteAdapter;
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

	private PlacesSQLiteAdapter governatesSQLiteAdapter;
	

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
		governatesSQLiteAdapter = new PlacesSQLiteAdapter(this);
		governatesSQLiteAdapter.openToWrite();
		governatesSQLiteAdapter.deleteAll();

		governatesSQLiteAdapter.addGovernateEntry(1,"Alexandria");
		governatesSQLiteAdapter.addGovernateEntry(2,"Aswan");
		governatesSQLiteAdapter.addGovernateEntry(3,"Asyut");
		governatesSQLiteAdapter.addGovernateEntry(4,"Beheira");
		governatesSQLiteAdapter.addGovernateEntry(5,"Beni Suef");
		governatesSQLiteAdapter.addGovernateEntry(6,"Cairo");
		governatesSQLiteAdapter.addGovernateEntry(7,"Dakahlia");
		governatesSQLiteAdapter.addGovernateEntry(8,"Damietta");
		governatesSQLiteAdapter.addGovernateEntry(9,"Faiyum");
		governatesSQLiteAdapter.addGovernateEntry(10,"Gharbia");
		governatesSQLiteAdapter.addGovernateEntry(11,"Giza");
		governatesSQLiteAdapter.addGovernateEntry(12,"Ismailia");
		governatesSQLiteAdapter.addGovernateEntry(13,"Kafr el-Sheikh	");
		governatesSQLiteAdapter.addGovernateEntry(14,"Matruh");
		governatesSQLiteAdapter.addGovernateEntry(15,"Minya");
		governatesSQLiteAdapter.addGovernateEntry(16,"Monufia");
		governatesSQLiteAdapter.addGovernateEntry(17,"New Valley");
		governatesSQLiteAdapter.addGovernateEntry(18,"North Sinai");
		governatesSQLiteAdapter.addGovernateEntry(19,"Port Said");
		governatesSQLiteAdapter.addGovernateEntry(20,"Qalyubia");
		governatesSQLiteAdapter.addGovernateEntry(21,"UQena");
		governatesSQLiteAdapter.addGovernateEntry(22,"Red Sea");
		governatesSQLiteAdapter.addGovernateEntry(23,"Al Sharqia");
		governatesSQLiteAdapter.addGovernateEntry(24,"Sohag");
		governatesSQLiteAdapter.addGovernateEntry(25,"South Sinai");
		governatesSQLiteAdapter.addGovernateEntry(26,"Suez");
		governatesSQLiteAdapter.addGovernateEntry(27,"Luxor");

		governatesSQLiteAdapter.close();

		/*
		 * Open the same SQLite database and read all it's content.
		 */
		governatesSQLiteAdapter = new PlacesSQLiteAdapter(this);
		governatesSQLiteAdapter.openToRead();

		Cursor cursor = governatesSQLiteAdapter.queueAll();
		startManagingCursor(cursor);

		String[] from = new String[] { PlacesSQLiteAdapter.KEY_CONTENT };
		int[] to = new int[] { R.id.text };

		SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
				R.layout.row, cursor, from, to);

		listContent.setAdapter(cursorAdapter);

		governatesSQLiteAdapter.close();
		 
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
