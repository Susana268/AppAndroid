package com.sgonzalez.myappfragmentcine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MaInformacionAdicional extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Fragment fragmentSinopsis, fragmentDirector, fragmentPuntuacion;
    private FragmentTransaction transaction;
    private TabLayout tabLayout;
    private Button buttonComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_informacion_adicional);
        buttonComprar = findViewById(R.id.btnComprar);
        textView = findViewById(R.id.txtNombreInfoAdicional);
        imageView = findViewById(R.id.imgInfoAdicional);

        tabLayout = findViewById(R.id.tlId);
        tabLayout.addTab(tabLayout.newTab().setText("Sinopsis"));
        tabLayout.addTab(tabLayout.newTab().setText("Director"));
        tabLayout.addTab(tabLayout.newTab().setText("Puntuacion"));

        fragmentSinopsis = new FragmentSinopsis();
        fragmentDirector = new FragmentDirector();
        fragmentPuntuacion = new FracmentPuntuacion();

        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentSinopsis).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentDirector).hide(fragmentDirector).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentPuntuacion).hide(fragmentPuntuacion).commit();

        this.getData();
        this.obtenerInformacionAdicional();
        this.navegacionTablayout();
    }

    private void navegacionTablayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if (fragmentSinopsis.isAdded()){
                            transaction.hide(fragmentDirector).
                                        hide(fragmentPuntuacion).
                                        show(fragmentSinopsis);

                        }else {
                            transaction.hide(fragmentDirector).
                                        add(R.id.flContenedor,fragmentSinopsis).
                                        addToBackStack(null);
                        }
                        break;
                    case 1:
                        if (fragmentDirector.isAdded()){
                            transaction.hide(fragmentPuntuacion).
                                    hide(fragmentSinopsis).
                                    show(fragmentDirector);

                        }else {
                            transaction.hide(fragmentPuntuacion).
                                    add(R.id.flContenedor,fragmentDirector).
                                    addToBackStack(null);
                        }
                        break;
                    case 2:
                        if (fragmentPuntuacion.isAdded()){
                            transaction.hide(fragmentSinopsis).
                                    hide(fragmentDirector).
                                    show(fragmentPuntuacion);

                        }else {
                            transaction.hide(fragmentSinopsis).
                                    add(R.id.flContenedor,fragmentPuntuacion).
                                    addToBackStack(null);
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

        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seleccion();
            }
        });
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        int nombreD = bundle.getInt("nombreD");
        int imagenD = bundle.getInt("imagenD");

        textView.setText(nombreD);
        imageView.setImageResource(imagenD);
    }

    private void obtenerInformacionAdicional(){
        Bundle bundle = getIntent().getExtras();
        int sinopsisD = bundle.getInt("sinopsisD");
        int directorD = bundle.getInt("directorD");
        int puntuacionD = bundle.getInt("puntuacionD");
        this.trasladarInfoFragmentSinopsis(sinopsisD);
        this.traladarInfoFragmentDirector(directorD);
        this.trasladarInfoFragmentPuntuacion(puntuacionD);
    }
    private void trasladarInfoFragmentSinopsis(int sinopsisD){
        Bundle bundle = new Bundle();
        bundle.putInt("sinopsisDF", sinopsisD);
        fragmentSinopsis.setArguments(bundle);
    }
    private void traladarInfoFragmentDirector(int directorD){
        Bundle bundle = new Bundle();
        bundle.putInt("directorDF", directorD);
        fragmentDirector.setArguments(bundle);
    }
    private void trasladarInfoFragmentPuntuacion(int puntuacionD){
        Bundle bundle = new Bundle();
        bundle.putInt("puntuacionDF",puntuacionD);
        fragmentPuntuacion.setArguments(bundle);
    }

    public void seleccion(){
        Bundle bundle = getIntent().getExtras();
        int precioD = bundle.getInt("precioD");

        Intent intent = new Intent(this,MaCompra.class);

        intent.putExtra("precioD",precioD);
        startActivity(intent);
    }

}