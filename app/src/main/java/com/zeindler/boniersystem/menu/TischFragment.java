package com.zeindler.boniersystem.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zeindler.boniersystem.R;
import com.zeindler.boniersystem.bestellen.BestellActivity;
import com.zeindler.boniersystem.server.Connector;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


public class TischFragment extends Fragment implements View.OnClickListener {

    private View view;

    private FloatingActionButton btnNewBestellung;

    public TischFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tisch, container, false);

        init();

        return view;
    }

    private void init(){
        btnNewBestellung = view.findViewById(R.id.fragment_tisch_btn_newBestellung);
        btnNewBestellung.setOnClickListener(this);
    }

    private void newBestellung(){
        Intent intent = new Intent(getContext(), BestellActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.fragment_tisch_btn_newBestellung){
            newBestellung();
        }
    }
}