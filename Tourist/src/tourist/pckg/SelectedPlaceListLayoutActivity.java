package tourist.pckg;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SelectedPlaceListLayoutActivity extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selected_place_list_layout);
		String[] values = new String[] { "haram", "cetedle", "abu sumble", "nile", "ras sdr", "karnk", "abu el hol","azhr bark",
				};
		// Use your own layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.selected_place_list_layout, R.id.label01, values);
		setListAdapter(adapter);
	}
}
