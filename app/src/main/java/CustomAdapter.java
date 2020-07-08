import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gokulakrishnan.dronatemp.R;

/**
 * Created by Gokulakrishnan on 7/2/2020.
 */

public class CustomAdapter extends ArrayAdapter {
    Context context;
    String items[],items1[];
    static LayoutInflater inflater;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, R.layout.customlayout, objects);
        this.items=items;
        this.items1=items1;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        if (row==null){
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.customlayout,parent,false);
        }
        TextView tv=(TextView)row.findViewById(R.id.textview);
        TextView tv1=(TextView)row.findViewById(R.id.textview1);
        tv.setText(items[position]);
        tv1.setText(items1[position]);
        return row;
    }
}
