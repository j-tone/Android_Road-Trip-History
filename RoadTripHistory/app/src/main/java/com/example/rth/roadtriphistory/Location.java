package com.example.rth.roadtriphistory;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Justin on 5/20/2016.
 */
public class Location {
    private double lat;
    private double lng;
    private String name;
    private int desc;

    public Location(double lat, double lng, String name, int desc){
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.desc = desc;
    }

    public double getLat(){
        return lat;
    }

    public double getLng(){
        return lng;
    }

    public LatLng getCoord(){
        return new LatLng(lat, lng);
    }

    public String getName(){
        return name;
    }

    public int getDesc(){
        return desc;
    }
}
