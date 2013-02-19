package tourist.pckg;

import tourist.pckg.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GalleryLayoutActivity extends Activity {
	Integer[] pics = { R.drawable.ic_launcher, R.drawable.ic_launcher,

			R.drawable.ic_launcher, R.drawable.ic_launcher,

			R.drawable.ic_launcher, R.drawable.ic_launcher,

			R.drawable.ic_launcher, R.drawable.ic_action_search,

			R.drawable.ic_launcher, R.drawable.ic_launcher ,

			R.drawable.ic_launcher, R.drawable.ic_launcher,

			R.drawable.ic_launcher, R.drawable.ic_action_search,

			R.drawable.ic_launcher, R.drawable.ic_launcher ,

			R.drawable.ic_launcher, R.drawable.ic_launcher };
	LinearLayout imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_layout);
		try {
			// InputStream in = (new URL("www.google.com").openStream());
		} catch (Exception e) {
			e.getMessage();
		}
		Gallery ga = (Gallery) findViewById(R.id.Gallery);
		ga.setAdapter(new ImageAdapter(this));

		imageView = (LinearLayout) findViewById(R.id.ImageView);
		ga.setOnItemClickListener(new OnItemClickListener() {
			//@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(
						getBaseContext(),
						"You have selected picture " + (arg2 + 1)
								+ " of Antartica", Toast.LENGTH_SHORT).show();
				try {
				imageView.removeAllViews();
				} catch (Exception e) {
					e.getMessage();
				}
//				TouchImageView touchImageView = new TouchImageView(
//						MainActivity.this);
//				touchImageView.setImageResource(pics[arg2]);
//				LayoutParams lp=new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
//				imageView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
//				touchImageView.setLayoutParams(lp);
//				imageView.addView(touchImageView);
			}

		});

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

	//	@Override
		public int getCount() {

			return pics.length;
		}

	//	@Override
		public Object getItem(int arg0) {

			return arg0;
		}

		//@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		//@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ImageView iv = new ImageView(ctx);
			iv.setImageResource(pics[arg0]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(400, 900));
			iv.setBackgroundResource(imageBackground);
			return iv;
		}
	}
}