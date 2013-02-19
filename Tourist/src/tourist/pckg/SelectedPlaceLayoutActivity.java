package tourist.pckg;

import tourist.pckg.R;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost.TabSpec;

public class SelectedPlaceLayoutActivity extends Activity {

	Integer[] pics = { R.drawable.ic_launcher, R.drawable.ic_launcher,

	R.drawable.ic_launcher, R.drawable.ic_launcher,

	R.drawable.ic_launcher, R.drawable.ic_launcher,

	
	R.drawable.ic_launcher, R.drawable.ic_launcher,

	
	R.drawable.ic_launcher, R.drawable.ic_launcher };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selected_place_layout);
		Bundle b = getIntent().getExtras();
		int value = b.getInt("place");
		Toast.makeText(this, " you select place of id " + value,
				Toast.LENGTH_LONG).show();

		try {
			// InputStream in = (new URL("www.google.com").openStream());
		} catch (Exception e) {
			e.getMessage();
		}
		Gallery ga = (Gallery) findViewById(R.id.Gallery01);
		ga.setAdapter(new ImageAdapter(this));

		// imageView = (LinearLayout) findViewById(R.id.ImageView01);
		ga.setOnItemClickListener(new OnItemClickListener() {
			// @Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(
						getBaseContext(),
						"You have selected picture " + (arg2 + 1)
								+ " of Antartica", Toast.LENGTH_SHORT).show();

				Intent intent = new Intent(SelectedPlaceLayoutActivity.this,
						GalleryLayoutActivity.class);

				startActivity(intent);
				finish();

			}

		});
	}

	public void onBtnClicked(View v) {
		if (v.getId() == R.id.btnPlaceName) {
			Intent intent = new Intent(SelectedPlaceLayoutActivity.this,SelectedPlaceListLayoutActivity.class);

			startActivity(intent);
			finish();
		}
	}

	public class ImageAdapter extends BaseAdapter {

		private Context ctx;
		int imageBackground;

		public ImageAdapter(Context c) {
			ctx = c;
			TypedArray ta = obtainStyledAttributes(R.styleable.Gallery1);
			imageBackground = ta.getResourceId(
					R.styleable.Gallery1_android_galleryItemBackground, 1);
			ta.recycle();
		}

		// @Override
		public int getCount() {

			return pics.length;
		}

		// @Override
		public Object getItem(int arg0) {

			return arg0;
		}

		// @Override
		public long getItemId(int arg0) {

			return arg0;
		}

		// @Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ImageView iv = new ImageView(ctx);
			iv.setImageResource(pics[arg0]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(400, 250));
			iv.setBackgroundResource(imageBackground);
			return iv;
		}
	}

	// TabHost tabHost = getTabHost();
	// TabSpec placesSpec = tabHost.newTabSpec("Back");
	// // placesSpec.setIndicator("Back",
	// getResources().getDrawable(R.drawable.ic_launcher));
	// placesSpec.setIndicator("Back");
	// Intent PlacesIntent = new Intent(this,BackTapLayoutActivity.class);
	// placesSpec.setContent(PlacesIntent);
	// tabHost.addTab(placesSpec);

}
