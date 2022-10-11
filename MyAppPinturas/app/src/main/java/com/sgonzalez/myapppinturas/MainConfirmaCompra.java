package com.sgonzalez.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainConfirmaCompra extends AppCompatActivity {
    private TextView txtViewNomF, txtViewPrecioF,txtViewNomCteF,txtViewApeCteF,txtViewNitF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_confirma_compra);
        txtViewNomF = findViewById(R.id.txtNomCompraF);
        txtViewPrecioF = findViewById(R.id.txtPrecioCompraF);
        txtViewNomCteF = findViewById(R.id.txtNomCteF);
        txtViewApeCteF = findViewById(R.id.txtApeCteF);
        txtViewNitF = findViewById(R.id.txtNitCteF);
        this.obtener();
        Button button = findViewById(R.id.btnFinal);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainConfirmaCompra.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        Integer precio = bundle.getInt("precio");
        String nomcte = bundle.getString("nomcte");
        String apecte = bundle.getString("apecte");
        String nitCte = bundle.getString("nitCte");

        //-----
        txtViewNomF.setText(String.valueOf(nombre));
        txtViewPrecioF.setText(String.valueOf(precio));
        txtViewNomCteF.setText(String.valueOf(nomcte));
        txtViewApeCteF.setText(String.valueOf(apecte));
        txtViewNitF.setText(String.valueOf(nitCte));

    }

}