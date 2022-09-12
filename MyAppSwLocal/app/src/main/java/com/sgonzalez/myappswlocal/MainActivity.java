package com.sgonzalez.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton materialButtonInsertar, materialButtonBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialButtonInsertar = findViewById(R.id.btnInsertarMenu);
        materialButtonBuscarCodigo = findViewById(R.id.btnBuscarMenu);
        this.menuSW();
    }

    private void menuSW() {
        materialButtonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInsertCliente();
            }
        });
        ::::
        materialButtonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInsertCliente();
            }
        });
    }

    private void abrirInsertCliente(){
        Intent intent = new Intent(getApplicationContext(),MAInsertarSW.class);
        startActivity(intent);
    }
}