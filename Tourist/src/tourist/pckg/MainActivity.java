
package tourist.pckg;
 
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
public class MainActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        TabHost tabHost = getTabHost();
 
        // Tab for Places
        TabSpec placesSpec = tabHost.newTabSpec("Places");
        // setting Title and Icon for the Tab
        
       // placesSpec.setIndicator("Places", getResources().getDrawable(R.drawable.ic_launcher));
        placesSpec.setIndicator("Places");
        Intent PlacesIntent = new Intent(this,PlacesLayoutActivity.class);
        placesSpec.setContent(PlacesIntent);
// 
//        // Tab for Governates
//        
        TabSpec governatesSpec = tabHost.newTabSpec("Governates");
       // governatesSpec.setIndicator("Governates", getResources().getDrawable(R.drawable.ic_launcher));
        governatesSpec.setIndicator("Governates");
        Intent GovernatesIntent = new Intent(this, GovernatesLayoutActivity.class);
        governatesSpec.setContent(GovernatesIntent);
// 
//      
//        // Adding all TabSpec to TabHost
      tabHost.addTab(placesSpec); // Adding photos tab
      tabHost.addTab(governatesSpec); // Adding songs tab
    }
}