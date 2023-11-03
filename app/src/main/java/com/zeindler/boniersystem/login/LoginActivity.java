package com.zeindler.boniersystem.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zeindler.boniersystem.R;

public class LoginActivity extends AppCompatActivity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_login_cl_mainLayout, loginFragment).commit();
    }
}