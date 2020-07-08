package com.example.gokulakrishnan.dronatemp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class Flight extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   private DrawerLayout drawerLayout;
   private ActionBarDrawerToggle toggle;
   TabLayout tabLayout;
   ViewPager viewPager;
   FragmentTabAdapter fragmentTabAdapter;
   NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        tabLayout=findViewById(R.id.tabs);
        fragmentTabAdapter=new FragmentTabAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        navigationView=(NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        // add  the tab to the TabLayout
        // viewPager=findViewById(R.id.viewPager);
       // tabLayout=findViewById(R.id.tabs);
        //fragmentTabsAdapter=new FragmentTabsAdapter(getSupportFragmentManager());
      //  viewPager.setAdapter(fragmentTabsAdapter);
       // tabLayout.setupWithViewPager(viewPager);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer1);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.warehouseLocation:
                Intent intent=new Intent(Flight.this,WarehouseLocation.class);
                startActivity(intent);
        }
        return false;
    }
}
