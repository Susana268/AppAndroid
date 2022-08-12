package com.sgonzalez.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainCompra extends AppCompatActivity {
    private TextView txtViewNom, txtViewPrecio;
    private ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_compra);
        txtViewNom = findViewById(R.id.txtNomCompra);
        txtViewPrecio = findViewById(R.id.txtPrecioCompra);
        imgView = findViewById(R.id.imgCompra);
        this.obtener();
    }

    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        Integer img = bundle.getInt("img");
        String nombre = bundle.getString("nombre");
        Integer precio = bundle.getInt("precio");
        //-----
        imgView.setImageResource(img);
        txtViewNom.setText(String.valueOf(nombre));
        txtViewPrecio.setText(String.valueOf(precio));

    }
}