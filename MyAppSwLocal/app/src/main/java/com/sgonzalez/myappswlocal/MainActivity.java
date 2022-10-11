package com.sgonzalez.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton  materialButtonInsertar, materialButtonBuscar,
                            materialButtonListar, materialButtonActualizar,
                            materialButtonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialButtonInsertar = findViewById(R.id.btnInsertarMenu);
        materialButtonBuscar = findViewById(R.id.btnBuscarMenu);
        materialButtonListar = findViewById(R.id.btnListarMenu);
        materialButtonEliminar =findViewById(R.id.btnEliminarMenu);
        materialButtonActualizar= findViewById(R.id.btnActualizarMenu);
        this.menuSW();
    }

    private void menuSW() {
        materialButtonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInsert();
            }
        });
        materialButtonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirBuscar();
            }
        });
        materialButtonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirListar();
            }
        });
        materialButtonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirActualizar();
            }
        });
        materialButtonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { abrirEliminar();
            }
        });

    }

    private void abrirInsert(){
        Intent intent = new Intent(getApplicationContext(),MAInsertarSW.class);
        startActivity(intent);
    }
    private void abrirBuscar(){
        Intent intent = new Intent(getApplicationContext(),MABuscarIdSW.class);
        startActivity(intent);
    }

    private void abrirListar(){
        Intent intent = new Intent(getApplicationContext(),MAListarMostrarSW.class);
        startActivity(intent);
    }
    private void abrirActualizar(){
        Intent intent = new Intent(getApplicationContext(),MAActualizarSw.class);
        startActivity(intent);
    }
    private void abrirEliminar(){
        Intent intent = new Intent(getApplicationContext(),MAListarMostrarSW.class);
        startActivity(intent);
    }

}