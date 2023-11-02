package com.zeindler.boniersystem.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zeindler.boniersystem.R;

public class MenuActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }
    private void init(){
        bottomNavigationView = findViewById(R.id.activity_menu_men_mainMenu);
        bottomNavigationView.setOnNa
    }
}