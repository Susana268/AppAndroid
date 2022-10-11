package com.sgonzalez.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainCompra extends AppCompatActivity {
    private TextView txtViewNom, txtViewPrecio,txtViewNomCte,txtViewApeCte,txtViewNitCte;
    private ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_compra);
        txtViewNom = findViewById(R.id.txtNomCompra);
        txtViewPrecio = findViewById(R.id.txtPrecioCompra);
        imgView = findViewById(R.id.imgCompra);
        txtViewNomCte = findViewById(R.id.txtNomCteCompra);
        txtViewApeCte = findViewById(R.id.txtApeCteCompra);
        txtViewNitCte = findViewById(R.id.txtNitCteCompra);
        this.obtener();
        Button button = findViewById(R.id.btnComprar);
        Button buttonCancel = findViewById(R.id.btnCancelar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomPinturaDato = txtViewNom.getText().toString();
                int precioPinturaDato = Integer.parseInt(txtViewPrecio.getText().toString());
                String nomCtePinturaDato = txtViewNomCte.getText().toString();
                String apeCtePinturaDato = txtViewApeCte.getText().toString();
                String nitCtePinturaDato = txtViewNitCte.getText().toString();
                trasladoAdapter(nomPinturaDato,precioPinturaDato,nomCtePinturaDato,
                                apeCtePinturaDato,nitCtePinturaDato);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainCompra.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
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
    private void trasladoAdapter(String nombre, int precio,String nombreCte,
                                 String apellidoCte, String nitCte){
        Intent intent = new Intent(this,MainConfirmaCompra.class);

        intent.putExtra("nombre",nombre);
        intent.putExtra("precio",precio);
        intent.putExtra("nomcte",nombreCte);
        intent.putExtra("apecte",apellidoCte);
        intent.putExtra("nitCte",nitCte);

        this.startActivity(intent);
        finish();
    }
}