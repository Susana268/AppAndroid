package com.sgonzalez.myappfragmentcuento2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Fragment fragment1,fragment2,fragment3,fragment4,fragment5;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tlid);
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 5"));
        tabLayout.selectTab(tabLayout.getTabAt(0));

        fragment1 = new FragmentUno();
        fragment2 = new FragmentDos();
        fragment3 = new FragmentTres();
        fragment4 = new FragmentCuatro();
        fragment5 = new FragmentCinco();

        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment3).hide(fragment3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment4).hide(fragment4).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment5).hide(fragment5).commit();
        accionTablayout();

    }
    private void accionTablayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction=getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if(fragment1.isAdded()){
                            transaction.hide(fragment2).
                                        hide(fragment3).
                                        hide(fragment4).
                                        hide(fragment5).
                                        show(fragment1).addToBackStack(null);
                        }else {
                            transaction.hide(fragment2).
                                        hide(fragment3).
                                        hide(fragment4).
                                        hide(fragment5).
                                        add(R.id.frlContenedor,fragment1);
                        }
                        break;
                    case 1:
                        if(fragment2.isAdded()){
                            transaction.hide(fragment3).
                                        hide(fragment4).
                                        hide(fragment5).
                                        hide(fragment1).
                                        show(fragment2).addToBackStack(null);
                        }else {
                            transaction.hide(fragment3).
                                        hide(fragment4).
                                        hide(fragment5).
                                        hide(fragment1).
                                        add(R.id.frlContenedor,fragment2);
                        }
                        break;
                    case 2:
                        if(fragment3.isAdded()){
                            transaction.hide(fragment1).
                                        hide(fragment2).
                                        hide(fragment4).
                                        hide(fragment5).
                                        show(fragment3).addToBackStack(null);
                        }else {
                            transaction.hide(fragment1).
                                        hide(fragment2).
                                        hide(fragment4).
                                        hide(fragment5).
                                        add(R.id.frlContenedor,fragment3);
                        }
                        break;
                    case 3:
                        if(fragment4.isAdded()){
                            transaction.hide(fragment1).
                                        hide(fragment2).
                                        hide(fragment3).
                                        hide(fragment5).
                                        show(fragment4).addToBackStack(null);
                        }else {
                            transaction.hide(fragment1).
                                        hide(fragment2).
                                        hide(fragment3).
                                        hide(fragment5).
                                        add(R.id.frlContenedor,fragment4);
                        }
                        break;
                    case 4:
                        if(fragment5.isAdded()){
                            transaction.hide(fragment1).
                                        hide(fragment2).
                                        hide(fragment3).
                                        hide(fragment4).
                                        show(fragment5).addToBackStack(null);
                        }else {
                            transaction.hide(fragment1).
                                        hide(fragment2).
                                        hide(fragment3).
                                        hide(fragment4).
                                    add(R.id.frlContenedor,fragment5);
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