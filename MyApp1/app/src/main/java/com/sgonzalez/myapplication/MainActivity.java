package com.sgonzalez.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView  textViewContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //establecer las view que se utilizaran
        textViewContador= findViewById(R.id.txtContador);
    }

    private void mas() {
        this.contador++;
        this.textViewContador.setText(String.valueOf(contador));
    }
    private void menoss() {
        this.contador--;
        this.textViewContador.setText(String.valueOf(contador));
    }
    private void limpia() {
        this.contador=0;
        this.textViewContador.setText(String.valueOf(contador));
        Toast.makeText(this, "Se Limpio Contador", Toast.LENGTH_SHORT).show();
    }
    public void onClick(View view) {
        if(view.getId()==R.id.btnMas){
            this.mas();
        }
        if(view.getId()==R.id.btnMenos){
            this.menoss();
        }
        if(view.getId()==R.id.btnLimpia){
            this.limpia();
        }
    }
}