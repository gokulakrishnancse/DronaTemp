package com.example.gokulakrishnan.dronatemp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gokulakrishnan on 7/7/2020.
 */

class MyAdapter1 extends ArrayAdapter<Items1> {
    public MyAdapter1(@NonNull Context context, int resource, ArrayList<Items1> items) {
        super(context, resource);
    }
    @Override
    public View getView(int position, View convertView1, ViewGroup parent) {
        // Get the data item for this position
        Items1 items = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView1 == null) {
            convertView1 = LayoutInflater.from(getContext()).inflate(R.layout.customlayout_depature, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView1.findViewById(R.id.textview3);
        TextView tvHome = (TextView) convertView1.findViewById(R.id.textview4);
        TextView tvapt_brd = (TextView) convertView1.findViewById(R.id.textview5);
        // Populate the data into the template view using the data object
        tvName.setText(items.getflt_num());
        tvHome.setText(items.getairLine_code_num());
//        if(items.getApt_brd().equals("BLR")) {
        tvapt_brd.setText(items.getApt_brd());
//        }
//        tvHome.setText(items.getFlt_num());
        // Return the completed view to render on screen
        return convertView1;
    }
}
