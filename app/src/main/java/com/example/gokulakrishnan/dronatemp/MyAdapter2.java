package com.example.gokulakrishnan.dronatemp;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;

import java.util.ArrayList;

/**
 * Created by Gokulakrishnan on 7/7/2020.
 */

class MyAdapter2 extends ArrayAdapter<Items2> {
    Context context;
    int resource;
    ArrayList<Items2> items3=null;
//    public MyAdapter2(Context context, ArrayList<Items2> users) {
//        super(context, 0, users);
//    }
//
//    public MyAdapter2(Response.Listener<String> listener, int layout_show_data, ArrayList<Items2> items3) {
//        super((Context) listener,0,items3);
//    }

    public MyAdapter2(Context context, int resource, ArrayList<Items2> items3) {
        super(context,resource,items3);
    }


//    public MyAdapter2(Response.Listener<String> context, int layout_show_data, ArrayList<Items2> items3) {
//        super((Context) context,0,items3);
//    }

//    public MyAdapter2(Show_Data show_data, ArrayList<Items2> items3) {
//        super((Context) show_data,0,items3);
//    }

//    public MyAdapter2(Response.Listener<String> listener, ArrayList<Items2> items3) {
//        super((Context) listener,0,items3);
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Get the data item for this position
        Items2 user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_show_data, parent, false);
        }
        if (position % 2 == 0) {

            convertView.setBackgroundColor(Color.parseColor("#FFFFFFFF"));

        } else {

           convertView.setBackgroundColor(Color.parseColor("#FFDADADA"));

        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.show_sh_Locatinn);
        TextView tvHome = (TextView) convertView.findViewById(R.id.show_wh_Location);
        // Populate the data into the template view using the data object
        tvName.setText(user.getSh_Location());

        tvHome.setText(user.getWh_Location());
        // Return the completed view to render on screen
        return convertView;
    }
}
