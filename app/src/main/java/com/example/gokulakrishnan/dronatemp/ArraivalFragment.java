package com.example.gokulakrishnan.dronatemp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class ArraivalFragment extends Fragment {



    public ArraivalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_arraival, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView textView=(TextView)view.findViewById(R.id.text);
        final TextView textView1=(TextView)view.findViewById(R.id.textview);
        final TextView textView2=(TextView)view.findViewById(R.id.textview1);
        Button button = (Button) view.findViewById(R.id.button);
        final ListView listView=(ListView)view.findViewById(R.id.List_View);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String URL=getString(R.string.URL_Arraival);
                String data=getString(R.string.json_data_Arraival);
                final String savedata = data;
                 final String[] data1 = {""};
                 final String[] flt_num={""};


                RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            final JSONObject jsonRootObject = new JSONObject(response);
                            JSONObject json_LL = jsonRootObject.getJSONObject("result");
                            final JSONArray jsonArray = json_LL.optJSONArray("items");
                            ArrayList<Items> items = new ArrayList<>();
//                            final ArrayList<String> items = new ArrayList<>();
//                            final ArrayList<String> items1 = new ArrayList<String>();
//                            final ArrayList<String> items2 = new ArrayList<String>();
//                            final ArrayList<String> item3 = new ArrayList<String>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String flt_car = jsonObject.optString("flt_car").toString();
//                                String flt_num = jsonObject.optString("flt_num").toString();
//                                String airLine_Code_Num = jsonObject.optString("airLine_Vode_Num").toString();
                                String flt_num=(jsonObject.optString("flt_num").toString());
                                String airLine_Code_Num =(jsonObject.optString("airLine_Code_Num").toString());
                                String dat_flt_ori = jsonObject.optString("dat_flt_ori").toString();
                                String apt_brd = jsonObject.optString("apt_brd").toString()+"\nto\n"+jsonObject.optString("apt_off").toString();

                                //String apt_off = jsonObject.optString("apt_off").toString();
                                String date_std = jsonObject.optString("date_std").toString();
                                int time_std = Integer.parseInt(jsonObject.optString("time_std").toString());
                                String date_sta = jsonObject.optString("date_sta").toString();
                                String time_sta = jsonObject.optString("time_sta").toString();

//                                textView.setText(flt_car.toString());
//                                items.add(new Items(flt_car));
//                                if(apt_brd.equals("BLR")) {
//                                if(apt_brd.equals("BLR".toString()))
                                if(jsonObject.getString("apt_off").equalsIgnoreCase("DXB"))
                                    items.add(new Items(R.drawable.ethiad, flt_num, airLine_Code_Num, apt_brd));
//                                }
//                                items.add(new Items(airLine_Code_Num));
//                                items1.add(new Items(String.valueOf(flt_num)));
//                                items1.add(String.valueOf(airLine_Code_Num));
//                                textView2.setText(flt_num);
                                //data1[0]+=+flt_num+airLine_Code_Num;
//                                items.add(data1[0]= flt_num+"      "+airLine_Code_Num+"      "
//                                        +airLine_Code_Num
//                                +"      "+dat_flt_ori+"      "+apt_brd+"      "+apt_off+"      "+date_std
//                                " "+time_std+" "+date_sta+" "+time_sta
//
// );
                            }
                            MyAdapter myAdapter=new MyAdapter(getActivity(),R.layout.customlayout,items);
//                            MyAdapter myAdapter=new MyAdapter(getActivity().getApplicationContext(),R.layout.customlayout,items);

//                            CustomAdapter adapter= new CustomAdapter(this,items,items1);
                            Toast.makeText(getActivity(), myAdapter.toString(), Toast.LENGTH_SHORT).show();
                            listView.setAdapter(myAdapter);
//                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                                   R.layout.customlayout,R.id.textview, R.id.textview,items);
//                            ArrayAdapter<String>adapter1=new ArrayAdapter<String>(getActivity(),R.layout.textview,items1);
//////
//                            listView.setAdapter(adapter);
//                            listView.setAdapter(adapter1);
//                            Toast.makeText(getActivity(), items.toString(), Toast.LENGTH_SHORT).show();
//                            textView1.setText(adapter.toString());


                        } catch (JSONException e) {
                            Toast.makeText(getActivity().getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                        }
                        //Log.i("VOLLEY", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        //Log.v("VOLLEY", error.toString());
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        try {
                            return savedata == null ? null : savedata.getBytes("utf-8");
                        } catch (UnsupportedEncodingException uee) {
                            //Log.v("Unsupported Encoding while trying to get the bytes", data);
                            return null;
                        }
                    }
                };
                requestQueue.add(stringRequest);
            }

            });
        }
//        class CustomAdapter extends BaseAdapter{
//
//            public CustomAdapter(FragmentActivity activity, ArrayList<String> items, ArrayList<String> items1) {
//            }
//
//            @Override
//            public int getCount() {
//                return 0;
//            }
//
//            @Override
//            public Object getItem(int i) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int i) {
//                return 0;
//            }
//
//            @Override
//            public View getView(int i, View view, ViewGroup viewGroup) {
//                return null;
////                Toast.makeText(getContext(),, Toast.LENGTH_SHORT).show();
//            }
//        }
}
