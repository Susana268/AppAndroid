package com.sgonzalez.myappfragmentcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FracmentPuntuacion extends Fragment {
    private int puntuacionDF;

    public FracmentPuntuacion() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            puntuacionDF = getArguments().getInt("puntuacionDF");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fracment_puntuacion, container, false);
        estructuraFragment(v);
        return v;
    }
    private void estructuraFragment(View v){
        TextView textView = v.findViewById(R.id.txtPuntuacion);
        textView.setText(puntuacionDF);
    }
}