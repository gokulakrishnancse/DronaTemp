package com.example.gokulakrishnan.dronatemp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
     ViewPager viewPager;
  FragmentTabAdapter fragmentTabAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabLayout=findViewById(R.id.tabs);
        fragmentTabAdapter=new FragmentTabAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
