package com.zeindler.boniersystem.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zeindler.boniersystem.R;
import com.zeindler.boniersystem.veranstaltung.*;

public class LoginFragment extends Fragment {

    private View view;

    private Kellner[] kellner;

    private TextView tvTitle;
    private ScrollView svKellner;
    private ImageButton btnAddKellner;

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

        //TEST
        kellner = new Kellner[2];
        kellner[0]=new Kellner(0,"Katrin");
        kellner[1]=new Kellner(1,"Markus");
    }

    private void init(){

    }
}