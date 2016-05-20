package com.example.rth.roadtriphistory;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Justin on 5/7/2016.
 */
public class Map_Section extends Fragment implements OnMapReadyCallback,
        GoogleMap.OnInfoWindowClickListener{
//    public static class MapData{
//        private int
//        public MapData(){}
//
//    }
//    MapData mapData = new MapData();
    private static LatLng currentLocation;
    private static Location[] closeLocations;
    MapView mapView;

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
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 13));

        map.addMarker(new MarkerOptions().title("Current Location").snippet("This is where we are in theory").position(currentLocation));
        for(int i = 0; i < closeLocations.length; i++){
            if ((closeLocations[i].getLat() < currentLocation.latitude + .6)&&
                    (closeLocations[i].getLat()>currentLocation.latitude - .6)&&
                    (closeLocations[i].getLng()<currentLocation.longitude + .6)&&
                    (closeLocations[i].getLng()>currentLocation.longitude - .6)){
                map.addMarker(new MarkerOptions().title(closeLocations[i].getName())
                        .snippet("Tap here for more")
                        .position(closeLocations[i].getCoord()));
            }
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker){
        for(int i = 0; i < closeLocations.length; i++){
            if(marker.getPosition() == closeLocations[i].getCoord());
            Text_Section text_section = new Text_Section();
            text_section.setDescText(closeLocations[i].getDesc());
        }
    }

    public void updateLocation(double lat, double lng, Location[] locations){
        currentLocation = new LatLng(lat, lng);
        closeLocations = locations;
    }


    //    @Override
//    public void OnResume(){
//        super.onResume();
//        mapView.onResume();
//    }

}