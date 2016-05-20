package com.example.rth.roadtriphistory;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    Map_Section theMap = new Map_Section();
    private SectionsPagerAdapter mSectionsPagerAdapter;

    Location[] locations = new Location[]{new Location(45.650565, -120.960659, "Celilo Falls", R.string.Celilo_Desc),
            new Location(45.687534, -121.690806, "Starvation Creek", R.string.Starvation_Desc),
            new Location(45.600324, -122.619479, "Oregon Steam Navigation Company", R.string.Oregon_Desc)};

//    double currLat = 45.682113;
//    double currLong = -121.846634;

    double currLat = 45.579359;
    double currLong = -122.115394;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    final int[] ICONS = new int[]{
            R.drawable.ic_map,
            R.drawable.ic_text,
            R.drawable.ic_locations,
            R.drawable.ic_learn,
            R.drawable.ic_search
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        for(int i = 0; i < ICONS.length; i++) {
            tabLayout.getTabAt(i).setIcon(ICONS[i]);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result){
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            if (position == 0){
                theMap.updateLocation(currLat, currLong, locations);
                return theMap;
            }
            else if (position == 1)
                return new Text_Section();
            else if (position == 2){
                Locations_Section locations_section = new Locations_Section();
                return locations_section;
            }
            else if (position == 3)
                return Learn_Section.newInstance();
            else
                return Search_Section.newInstance();
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }
    }
}
