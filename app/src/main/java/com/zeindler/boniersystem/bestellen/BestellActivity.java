package com.zeindler.boniersystem.bestellen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zeindler.boniersystem.R;
import com.zeindler.boniersystem.login.LoginFragment;

public class BestellActivity extends AppCompatActivity {

    BestellFragment bestellFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestell);

        bestellFragment = new BestellFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_bestell_cl_mainLayout, bestellFragment).commit();
    }
}