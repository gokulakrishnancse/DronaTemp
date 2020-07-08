package com.example.gokulakrishnan.dronatemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
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


public class Show_Data extends AppCompatActivity {
    private RequestQueue requestQueue;
    String data1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__data);
        String data="{\n" +
                "    \"input\": \"2\"\n" +
                "}";
        Show(data);
    }
    public void Show(String data){
        final String savedata=data;
        String URL=getString(R.string.URL_Show_Location);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    final JSONObject jsonRootObject = new JSONObject(response);
                    JSONObject json_LL = jsonRootObject.getJSONObject("result");
                    final JSONArray jsonArray = json_LL.optJSONArray("items");
                    final ArrayList<Items2> items3 = new ArrayList<Items2>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String sh_Location=jsonObject.optString("sh_Location").toString();
//                        String piecesn=jsonObject.optString("pieces").toString();
                        String wh_Location=jsonObject.optString("wh_Location").toString();
//                        String isDeleted=jsonObject.optString("isDeleted").toString();
//                        String deleterUserId=jsonObject.optString("deleterUserId").toString();
//                        String deletionTime=jsonObject.optString("deletionTime").toString();
//                        String lastModificationTime=jsonObject.optString("lastModificationTime").toString();
//                        String creationTimen=jsonObject.optString("creationTime").toString();
//                        String creatorUserId=jsonObject.optString("creatorUserId").toString();
                        String id=jsonObject.optString("id").toString();
//                        items.add(new Items(R.drawable.ethiad, flt_num, airLine_Code_Num, apt_brd));
                        items3.add(new Items2(sh_Location,wh_Location));



                    }
                    MyAdapter2 myAdapter2=new MyAdapter2(getApplicationContext(),R.layout.layout_show_data,items3);
                    Toast.makeText(Show_Data.this, myAdapter2.toString(), Toast.LENGTH_SHORT).show();


//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_Data.this,
//                            android.R.layout.activity_list_item, android.R.id.text1, ArrayData);
                    ListView lv = (ListView) findViewById(R.id.List_Items_Location);
                    lv.setAdapter(myAdapter2);
//                    Toast.makeText(Show_Data.this, ArrayData.toString(), Toast.LENGTH_SHORT).show();



                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                //Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

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
}
