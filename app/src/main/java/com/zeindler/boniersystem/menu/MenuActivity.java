package com.zeindler.boniersystem.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.zeindler.boniersystem.R;

public class MenuActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }
    private void init(){
        bottomNavigationView = findViewById(R.id.activity_menu_men_mainMenu);
        bottomNavigationView.setOnItemSelectedListener(this);

        //Startseite ist standardmäßig das Tisch Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_menu_fl_fragLayout,new TischFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        Fragment selectedFragment = null;

        if (itemId == R.id.bottom_navigation_menu_itemTische) {
            selectedFragment = new TischFragment();
        }
        if(itemId == R.id.bottom_navigation_menu_item2) {

        }
        if(itemId == R.id.bottom_navigation_menu_itemSettings) {
            selectedFragment = new SettingsFragment();
        }


        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_menu_fl_fragLayout,selectedFragment).commit();
            return true;
        }

        return false;
    }
}