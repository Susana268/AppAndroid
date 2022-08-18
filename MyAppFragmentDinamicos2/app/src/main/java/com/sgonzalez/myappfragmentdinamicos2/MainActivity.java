package com.sgonzalez.myappfragmentdinamicos2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Fragment fragment1,fragment2;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tlid);
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 2"));

        fragment1 = new FragmentUno();
        fragment2 = new FragmentDos();

        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment2).commit();
        accionTablayout();

    }
    private void accionTablayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction=getSupportFragmentManager().beginTransaction();
                switch(tab.getPosition()){
                    case 0:
                        if(fragment1.isAdded()){
                            transaction.hide(fragment2).show(fragment1).addToBackStack(null);

                        }else {
                            transaction.hide(fragment2).add(R.id.frlContenedor,fragment1);
                        }
                        break;
                    case 1:
                        if(fragment2.isAdded()){
                            transaction.hide(fragment1).show(fragment2).addToBackStack(null);
                        }
                        else {
                            transaction.hide(fragment1).add(R.id.frlContenedor,fragment2);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}