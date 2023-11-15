package com.zeindler.boniersystem.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zeindler.boniersystem.R;

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
        System.out.println("Neue Bestellung");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //TODO: TEST HIER WIRD NUR GETEST OB DIE VERBINDUNG ZUM SERVER FUNKTIONIERT
                String messageToSend = "JAWOHL LETS FUCKING GOOOOOO!!!!";
                String serverUrl = null;
                try {
                    serverUrl = "http://10.0.0.72/messageReceiver.php?message=" + URLEncoder.encode(messageToSend, "UTF-8");


                    URL url = new URL(serverUrl);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");

                    int responseCode = urlConnection.getResponseCode();
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                } catch (ProtocolException e) {
                    throw new RuntimeException(e);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.fragment_tisch_btn_newBestellung){
            newBestellung();
        }
    }
}