package com.example.rth.roadtriphistory;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Justin on 5/7/2016.
 */
public class Map_Section extends Fragment implements OnMapReadyCallback {
    MapView mapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = (MapView) rootView.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng whitworth = new LatLng(47.753, -117.417);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(whitworth, 13));

        map.addMarker(new MarkerOptions().title("Whitworth").snippet("The place of learning").position(whitworth));
    }

    //    @Override
//    public void OnResume(){
//        super.onResume();
//        mapView.onResume();
//    }

}