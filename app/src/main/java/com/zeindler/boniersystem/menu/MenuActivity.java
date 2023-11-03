package com.zeindler.boniersystem.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
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
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int idTisch = R.id.bottom_navigation_menu_itemTische;
        int itemId = item.getItemId();
        Fragment selectedFragment = null;
        switch(2){
            case R.id.botto:
                selectedFragment = new TischFragment();
                break;

        }


        return false;
    }
}