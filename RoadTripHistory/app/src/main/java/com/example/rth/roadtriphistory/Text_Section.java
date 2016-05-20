package com.example.rth.roadtriphistory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Justin on 5/7/2016.
 */
public class Text_Section extends Fragment {
    public Text_Section(){}
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);
       textView = (TextView) rootView.findViewById(R.id.textdesc);
        return rootView;
    }
    public void setDescText(int i){
        textView.setText(i);
    }
}