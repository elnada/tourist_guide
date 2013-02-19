package tourist.pckg;

import dataBase.pckg.PlacesSQLiteAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import android.widget.ListView;

public class PlacesLayoutActivity extends Activity {

	private PlacesSQLiteAdapter placesSQLiteAdapter;
	

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
		placesSQLiteAdapter = new PlacesSQLiteAdapter(this);
		placesSQLiteAdapter.openToWrite();
		placesSQLiteAdapter.deleteAll();

		placesSQLiteAdapter.addPlaceEntry(1,"Sharm");
		placesSQLiteAdapter.addPlaceEntry(2,"Luxor");
		placesSQLiteAdapter.addPlaceEntry(3,"Asyut");
		placesSQLiteAdapter.addPlaceEntry(4,"Beheira");
		placesSQLiteAdapter.addPlaceEntry(5,"Beni Suef");
		placesSQLiteAdapter.addPlaceEntry(6,"Cairo");
		placesSQLiteAdapter.addPlaceEntry(7,"Dakahlia");
		placesSQLiteAdapter.addPlaceEntry(8,"Damietta");
		placesSQLiteAdapter.addPlaceEntry(9,"Faiyum");
		placesSQLiteAdapter.addPlaceEntry(10,"Gharbia");
		placesSQLiteAdapter.addPlaceEntry(11,"Giza");
		placesSQLiteAdapter.addPlaceEntry(12,"Ismailia");
		placesSQLiteAdapter.addPlaceEntry(13,"Kafr el-Sheikh");
		placesSQLiteAdapter.addPlaceEntry(14,"Matruh");
		placesSQLiteAdapter.addPlaceEntry(15,"Minya");
		placesSQLiteAdapter.addPlaceEntry(16,"Monufia");
		placesSQLiteAdapter.addPlaceEntry(17,"New Valley");
		placesSQLiteAdapter.addPlaceEntry(18,"North Sinai");
		placesSQLiteAdapter.addPlaceEntry(19,"Port Said");
		placesSQLiteAdapter.addPlaceEntry(20,"Qalyubia");
		placesSQLiteAdapter.addPlaceEntry(21,"UQena");
		placesSQLiteAdapter.addPlaceEntry(22,"Red Sea");
		placesSQLiteAdapter.addPlaceEntry(23,"Al Sharqia");
		placesSQLiteAdapter.addPlaceEntry(24,"Sohag");
		placesSQLiteAdapter.addPlaceEntry(25,"South Sinai");
		placesSQLiteAdapter.addPlaceEntry(26,"Suez");
		placesSQLiteAdapter.addPlaceEntry(27,"Luxor");


		placesSQLiteAdapter.close();

		/*
		 * Open the same SQLite database and read all it's content.
		 */
		placesSQLiteAdapter = new PlacesSQLiteAdapter(this);
		placesSQLiteAdapter.openToRead();

		Cursor cursor = placesSQLiteAdapter.queueAll();
		startManagingCursor(cursor);

		String[] from = new String[] { PlacesSQLiteAdapter.KEY_PLACES_NAME };
		int[] to = new int[] { R.id.text };

		SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
				R.layout.row, cursor, from, to);

		listContent.setAdapter(cursorAdapter);

		placesSQLiteAdapter.close();
	}

	
}
