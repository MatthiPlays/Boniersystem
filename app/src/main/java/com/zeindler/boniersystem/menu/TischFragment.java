package com.zeindler.boniersystem.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeindler.boniersystem.R;


public class TischFragment extends Fragment {

    private View view;

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
        return view;
    }
}