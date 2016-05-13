package com.example.rth.roadtriphistory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Justin on 5/7/2016.
 */
public class Learn_Section extends Fragment {
    public Learn_Section(){}
    public static Learn_Section newInstance(){
        Learn_Section fragment = new Learn_Section();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_learn, container, false);
        return rootView;
    }
}