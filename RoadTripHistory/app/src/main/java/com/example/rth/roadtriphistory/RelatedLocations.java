package com.example.rth.roadtriphistory;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Justin on 5/13/2016.
 */
public class RelatedLocations {
    private String[] name;
    private String[] desc;

    public RelatedLocations(String[] name, String[] desc){
        this.name = name;
        this.desc = desc;
    }
    public String[] getName() {
        return name;
    }

    public String[] getDesc() {
        return desc;
    }

}
