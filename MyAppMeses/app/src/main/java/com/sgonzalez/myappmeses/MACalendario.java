package com.sgonzalez.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MACalendario extends AppCompatActivity {

    private TextView textViewNombreMes,
                     textViewCelebracionMes,
                     textViewDescripcionMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macalendario);
        textViewNombreMes = findViewById(R.id.txtMes);
        textViewCelebracionMes= findViewById(R.id.txtNombreCelebracion);
        textViewDescripcionMes= findViewById(R.id.txtDescripCelebracion);

        this.obtenerDatos();
    }
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String celebracion = bundle.getString("celebreacion");
        int descripcion = bundle.getInt("descripcion");
        textViewNombreMes.setText(String.valueOf(nombre));
        textViewCelebracionMes.setText(String.valueOf(celebracion));
        textViewDescripcionMes.setText(descripcion);
    }
}