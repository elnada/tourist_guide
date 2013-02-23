package tourist.pckg;


import dataBase.pckg.Tourist_DB;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import android.widget.ListView;

public class PlacesLayoutActivity extends Activity {

	private Tourist_DB touristDB;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.places_layout);
		ListView listContent = (ListView) findViewById(R.id.placelist);

		/*
		 * Create/Open a SQLite database and fill with dummy content and close
		 * it
		 */
		touristDB = new Tourist_DB(this);
		touristDB.openToWrite();
		touristDB.deletePlaces();

		touristDB.addPlaceEntry(1,"Sharm");
		touristDB.addPlaceEntry(2,"Luxor");
		touristDB.addPlaceEntry(3,"Asyut");
		touristDB.addPlaceEntry(4,"Beheira");
		touristDB.addPlaceEntry(5,"Beni Suef");
		touristDB.addPlaceEntry(6,"Cairo");
		touristDB.addPlaceEntry(7,"Dakahlia");
		touristDB.addPlaceEntry(8,"Damietta");
		touristDB.addPlaceEntry(9,"Faiyum");
		touristDB.addPlaceEntry(10,"Gharbia");
		touristDB.addPlaceEntry(11,"Giza");
		touristDB.addPlaceEntry(12,"Ismailia");
		touristDB.addPlaceEntry(13,"Kafr el-Sheikh");
		touristDB.addPlaceEntry(14,"Matruh");
		touristDB.addPlaceEntry(15,"Minya");
		touristDB.addPlaceEntry(16,"Monufia");
		touristDB.addPlaceEntry(17,"New Valley");
		touristDB.addPlaceEntry(18,"North Sinai");
		touristDB.addPlaceEntry(19,"Port Said");
		touristDB.addPlaceEntry(20,"Qalyubia");
		touristDB.addPlaceEntry(21,"UQena");
		touristDB.addPlaceEntry(22,"Red Sea");
		touristDB.addPlaceEntry(23,"Al Sharqia");
		touristDB.addPlaceEntry(24,"Sohag");
		touristDB.addPlaceEntry(25,"South Sinai");
		touristDB.addPlaceEntry(26,"Suez");
		touristDB.addPlaceEntry(27,"Luxor");

		/*
		 * Open the same SQLite database and read all it's content.
		 */
		touristDB = new Tourist_DB(this);
		touristDB.openToRead();

		Cursor cursor = touristDB.PlaceRow();
		startManagingCursor(cursor);

		String[] from = new String[] { Tourist_DB.KEY_PLACES_NAME };
		int[] to = new int[] { R.id.text };

		SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,R.layout.row, cursor, from, to);
		listContent.setAdapter(cursorAdapter);

		
	//byte[] image = cursor.getBlob(1);
		touristDB.close();
	}

	
}
