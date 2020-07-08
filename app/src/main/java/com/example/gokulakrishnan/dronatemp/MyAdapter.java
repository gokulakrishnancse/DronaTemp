package com.example.gokulakrishnan.dronatemp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gokulakrishnan on 7/2/2020.
 */

class MyAdapter extends ArrayAdapter<Items> {
    public MyAdapter(Context context, int customlayout, ArrayList<Items> users) {
        super(context, 0, users);
    }

//    public MyAdapter(Show_Data context, int customlayout, ArrayList<Items2> arrayData) {
//        super(context,0,arrayData);
//    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
       Items items = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.textview);
        TextView tvHome = (TextView) convertView.findViewById(R.id.textview1);
        TextView tvapt_brd = (TextView) convertView.findViewById(R.id.textview2);
        // Populate the data into the template view using the data object
        tvName.setText(items.getflt_num());
        tvHome.setText(items.getairLine_code_num());
//        if(items.getApt_brd().equals("BLR")) {
            tvapt_brd.setText(items.getApt_brd());
//        }
//        tvHome.setText(items.getFlt_num());
        // Return the completed view to render on screen
        return convertView;
    }
}
