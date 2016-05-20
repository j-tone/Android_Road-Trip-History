package com.example.rth.roadtriphistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Justin on 5/11/2016.
 */
public class LocationListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] names;
    private final String[] other_values;

    public LocationListAdapter(Context context, String[] values, String[] other_values){
        super(context, R.layout.list_selection_layout, values);
        this.context = context;
        this.names = values;
        this.other_values = other_values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_selection_layout, parent, false);
        TextView locationName = (TextView) rowView.findViewById(R.id.firstLine);
        TextView locationAddr = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView locationPic = (ImageView) rowView.findViewById(R.id.location_icon);
        locationName.setText(names[position]);
        locationAddr.setText(other_values[position]);

        return rowView;
    }
}
