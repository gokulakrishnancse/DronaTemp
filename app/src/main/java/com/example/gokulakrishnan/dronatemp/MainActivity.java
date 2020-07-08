package com.example.gokulakrishnan.dronatemp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Switch myswitch;
    private CardView warehouse,create,update,delete,flight,search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darktheme);
        } else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!isConnected()){
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("INTERNET CONNECTION ALERT")
            .setMessage("Please Check Your Internet Connection")
            .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }

            })
            .show();

        }

        myswitch = findViewById(R.id.myswitch);
        warehouse=(CardView)findViewById(R.id.warehouse);
        create=(CardView)findViewById(R.id.create);
        update=(CardView)findViewById(R.id.update);
        delete=(CardView)findViewById(R.id.delete);
        flight=(CardView)findViewById(R.id.flight);
        search=(CardView)findViewById(R.id.search);
        warehouse.setOnClickListener(this);
        create.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        flight.setOnClickListener(this);
        search.setOnClickListener(this);




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botton_Navigation_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        // do something here
                        return true;
                    case R.id.settings:
                        // do something here
//                        Intent intent = new Intent(MainActivity.this, Settings.class);
//                        startActivity(intent);
                        return true;
                    case R.id.more:
                        // do something here
                        return true;
                    default:
                        return true;
                }
            }
        });
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            myswitch.setChecked(true);
        }

        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });
    }




    public void restartApp() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.warehouse:
                i=new Intent(this,WarehouseLocation.class);
                startActivity(i);
                break;
//            case R.id.warehouse:i=new Intent(this ,Flight.class);startActivity(i);break;
//            case R.id.create:i=new Intent(this ,Flight.class);startActivity(i);break;
//            case R.id.update:i=new Intent(this ,Flight.class);startActivity(i);break;
//            case R.id.delete:i=new Intent(this ,Flight.class);startActivity(i);break;
            case R.id.flight:
                i = new Intent(this, Flight.class);
                startActivity(i);
                break;
            // case R.id.search:i=new Intent(this ,Flight.class);startActivity(i);break;

        }
    }
        private boolean isConnected(){
            ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            return networkInfo!=null&&networkInfo.isConnected();
    }


    }










