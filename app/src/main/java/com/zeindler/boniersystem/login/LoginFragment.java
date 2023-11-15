package com.zeindler.boniersystem.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zeindler.boniersystem.R;
import com.zeindler.boniersystem.menu.MenuActivity;
import com.zeindler.boniersystem.server.Connector;
import com.zeindler.boniersystem.veranstaltung.*;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View view;

    private Kellner[] kellner;
    private TextView[] tvKellner;
    private Veranstaltung veranstaltung;

    private TextView tvTitle;
    private LinearLayout llKellner;
    private ImageButton btnNewKellner;
    private Button btnLogin;

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
        kellner = Connector.getKellner();
        veranstaltung = Connector.getVeranstaltung();
    }

    private void init(){
        tvTitle = view.findViewById(R.id.fragment_login_tv_title);
        llKellner = view.findViewById(R.id.fragment_login_ll_kellner);
        btnNewKellner = view.findViewById(R.id.fragment_login_btn_newKellner);

        tvTitle.setText(veranstaltung.getName());

        //Liste der Kellner
        tvKellner = new TextView[kellner.length];//Liste soll genau so lang sein wie die der Kellner, KellnerXY index ist dann in beiden arrays der gleiche
        for(int i = 0;i<tvKellner.length;i++){
            TextView tv=new TextView(getContext());
            tv.setTag(i);//Tag, damit ich später weiß welcher Kellner ausgewählt wurde

            //TextView sytlen und initialisieren
            tv.setText(kellner[i].getName());
            tv.setTextSize(30);


            tv.setOnClickListener(this);
            tvKellner[i]=tv;
            llKellner.addView(tv);
        }

        //Neuer Kellner
        btnNewKellner.setOnClickListener(this);

        //Login
        btnLogin = view.findViewById(R.id.fragment_login_btn_login);
        btnLogin.setOnClickListener(this);

    }
    private void selectKellner(int index){
        Kellner k = kellner[index];

    }


    //Neuer Kellner
    private void openDialogNewKellner(){
        //TODO: Dialog für neuen Kellner
    }


    //Login
    private void login(){
        //TODO: technisches Login

        Intent intent = new Intent(getContext(), MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        System.out.println(id);
        if(id==R.id.fragment_login_btn_newKellner){
            //Neuer Kellner
            openDialogNewKellner();
        }else if(id==R.id.fragment_login_btn_login){
            login();
        }else{//kann nur einer der Kellner sein, daher anhand des Tags erkennen
            int index = (int) v.getTag();
            selectKellner(index);
        }
    }
}