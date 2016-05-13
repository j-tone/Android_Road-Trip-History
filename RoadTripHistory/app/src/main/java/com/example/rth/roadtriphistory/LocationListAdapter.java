package com.example.rth.roadtriphistory;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Justin on 5/11/2016.
 */
public class LocationListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;
    private final String[] other_values;
    private final int[] images;

    public LocationListAdapter(Context context, String[] values, String[] other_values, int[] images){
        super(context, R.layout.list_selection_layout, values);
        this.context = context;
        this.values = values;
        this.other_values = other_values;
        this.images = images;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_selection_layout, parent, false);
        TextView locationName = (TextView) rowView.findViewById(R.id.firstLine);
        TextView locationAddr = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView locationPic = (ImageView) rowView.findViewById(R.id.location_icon);
        locationName.setText(values[position]);
        locationAddr.setText(other_values[position]);
        locationPic.setImageResource(images[position]);

        return rowView;
    }
}
