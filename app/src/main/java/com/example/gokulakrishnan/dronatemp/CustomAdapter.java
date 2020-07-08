package com.example.gokulakrishnan.dronatemp;//package com.example.gokulakrishnan.dronatemp;
//
///**
// * Created by Gokulakrishnan on 7/2/2020.
// */
//
//class CustomAdapter {
//}
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.gokulakrishnan.dronatemp.R;

import java.util.ArrayList;

import static com.example.gokulakrishnan.dronatemp.R.*;

/**
 * Created by Gokulakrishnan on 7/2/2020.
 */

public class CustomAdapter extends ArrayAdapter {
    Context context;
    String items[],items1[];
    static LayoutInflater inflater;

    public CustomAdapter(@NonNull Response.Listener<String> context, ArrayList<String> resource, @NonNull ArrayList<String> objects) {
        super((Context) context, layout.customlayout, objects);
        this.items=items;
        this.items1=items1;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        if (row==null){
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(layout.customlayout,parent,false);
        }
        TextView tv=(TextView)row.findViewById(id.textview);
        TextView tv1=(TextView)row.findViewById(id.textview1);
        ImageView imageView=(ImageView)row.findViewById(id.imageicon);
        imageView.setImageResource(Integer.parseInt(items[position]));
//        SpannableStringBuilder spannableStringBuilder=new SpannableStringBuilder();
//        spannableStringBuilder.setSpan(new ImageSpan(getAc, drawable.arrow),spannableStringBuilder.length()-1,spannableStringBuilder.length());
        tv.setText(items[position]);
        tv1.setText(items1[position]);
        return row;
    }
}
