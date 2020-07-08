//package com.example.gokulakrishnan.dronatemp;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatDelegate;
//import android.widget.CompoundButton;
//import android.widget.Switch;
//
//public class Settings extends AppCompatActivity {
//    private Switch myswitch;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
//            setTheme(R.style.darktheme);
//        }
//        else setTheme(R.style.AppTheme);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_settings);
//        myswitch=findViewById(R.id.myswitch);
//        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
//            myswitch.setChecked(true);
//        }
//        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked){
//                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                   restartApp();
//                }
//                else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    restartApp();
//                }
//            }
//        });
//
//    }
//    public void restartApp() {
//        Intent intent = new Intent(getApplicationContext(), Settings.class);
//        startActivity(intent);
//        finish();
//    }
//
//
//}
