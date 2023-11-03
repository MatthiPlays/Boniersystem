package com.zeindler.boniersystem.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeindler.boniersystem.R;

public class LoginFragment extends Fragment {

    private View view;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        syncWithServer();
        init();

        return view;
    }

    private void syncWithServer(){
        //TODO: mit Raspberry PI synchronisieren
        //Synchronisiert sollen hier die Kellner Daten werden.
        //Am besten gibt es eine eigene Klasse die sämtliche Connections handelt, da gibt es dann auch eine Klasse die die Kellner synchronisiert
    }

    private void init(){

    }
}