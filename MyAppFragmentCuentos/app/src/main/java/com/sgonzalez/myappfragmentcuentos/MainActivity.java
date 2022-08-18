package com.sgonzalez.myappfragmentcuentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Fragment fragment1,fragment2,fragment3,fragment4;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout= findViewById(R.id.tlid);
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 3"));
        tabLayout.selectTab(tabLayout.getTabAt(0));


        fragment1 = new FragmentUno();
        fragment2 = new FragmentDos();
        fragment3 = new FragmentTres();
        fragment4 = new FragmentCuatro();

        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment1).commit();



    }
    private void accionTab(){

    }

}