package com.example.gokulakrishnan.dronatemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WarehouseLocation extends AppCompatActivity {
    EditText wh_Location,sh_Location;
    private RequestQueue requestQueue;
    Button create,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_location);
        wh_Location=findViewById(R.id.wh_Location);
        sh_Location=findViewById(R.id.sh_Location);
        create=findViewById(R.id.create_Location);
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        String date=sdf.format(new Date());
//        sdf=new SimpleDateFormat("HH:mm:ss.ms");
//        String time=sdf.format(new Date());
//        sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
//        String currentDateandTime = sdf.format(new Date());
//        Log.i("sedjbfdsjf",date);
//        Log.i("gokul",time);
//        Log.i("gokul",currentDateandTime);
        show=findViewById(R.id.show_location);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WarehouseLocation.this,Show_Data.class);
                startActivity(intent);
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(WarehouseLocation.this, "Hai", Toast.LENGTH_SHORT).show();

//              String data="{\n" +
//                      "        \"id\": 10,\n" +
//                      "        \"sh_Location\""+ "\""+wh_Location.getText().toString()+"\",\n" +
//                      "        \"wh_Location\""+"\""+sh_Location.getText().toString()+"\",\n" +
//                      "        \"isDeleted\": false,\n" +
//                      "        \"deleterUserId\": null,\n" +
//                      "        \"deletionTime\": null,\n" +
//                      "        \"lastModificationTime\": null,\n" +
//                      "        \"lastModifierUserId\": null,\n" +
//                      "        \"creationTime\": \"2020-06-07T11:37:36.347\",\n" +
//                      "        \"creatorUserId\": null\n" +
//                      "    }";
//                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"+"T"+"HH:mm:ss:ms");
//                String date=sdf.format(new Date());
////
//                Log.i("sedjbfdsjf",date);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String date=sdf.format(new Date());
                sdf=new SimpleDateFormat("HH:mm:ss.ms");
                String time=sdf.format(new Date());

                String data="{\n" +
                        "        \"id\": 10,\n" +
                        "         \"sh_Location\":"+ "\""+sh_Location.getText().toString()+"\",\n" +
                        "       \"wh_Location\":"+"\""+wh_Location.getText().toString()+"\",\n" +
                        "        \"isDeleted\": false,\n" +
                        "        \"deleterUserId\": null,\n" +
                        "        \"deletionTime\": null,\n" +
                        "        \"lastModificationTime\": null,\n" +
                        "        \"lastModifierUserId\": null,\n" +
                        "        \"creationTime\":"+"\""+date.toString()+"T"+time.toString()+"\",\n" +
                        "        \"creatorUserId\": null\n" +
                        "    }";
                Submit(data);
            }


        });
    }
    private void Submit(String data) {
        if(wh_Location.length()==0){
            wh_Location.setError("wh_Location cannot be empty");

        }
        if(sh_Location.length()==0){
            sh_Location.setError("sh_Location cannot be empty");

        }


        final String savedata=data;
        String URL=getString(R.string.URL_Create_Location);;

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres=new JSONObject(response);
                    Toast.makeText(getApplicationContext(),objres.toString(),Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                //Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                wh_Location.setText("");
                sh_Location.setText("");

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
