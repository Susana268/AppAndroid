package com.sgonzalez.myappfragmentcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentSinopsis extends Fragment {

    private int sinopsisDF;


    public FragmentSinopsis() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sinopsisDF = getArguments().getInt("sinopsisDF");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sinopsis, container, false);
        estructuraFragment(v);
        return v;
    }
    private void estructuraFragment(View v){
        TextView textView = v.findViewById(R.id.txtSinopsis);
        textView.setText(sinopsisDF);
    }
}