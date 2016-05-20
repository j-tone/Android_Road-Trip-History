package com.example.rth.roadtriphistory;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Justin on 5/7/2016.
 */
public class Locations_Section extends ListFragment {
    public RelatedLocations locations;

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        String[] example_names = new String[] {"Whitworth University", "My House on Ivanhoe", "Usk, Washington"};
        String[] example_addrs = new String[] {"300 W Hawthorne Rd", "9906 N Ivanhoe Rd", "Middle of nowhere"};
//        LocationListAdapter adapter = new LocationListAdapter(getActivity(), locations.getName(), locations.getDesc());
//        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_locations, container, false);
        return rootView;
    }
}