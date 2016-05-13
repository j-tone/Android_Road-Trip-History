package com.example.rth.roadtriphistory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Justin on 5/7/2016.
 */
public class Search_Section extends Fragment {
    public Search_Section(){}
    public static Search_Section newInstance(){
        Search_Section fragment = new Search_Section();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        return rootView;
    }
}