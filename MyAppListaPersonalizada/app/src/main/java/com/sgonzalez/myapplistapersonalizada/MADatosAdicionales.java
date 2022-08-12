package com.sgonzalez.myapplistapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MADatosAdicionales extends AppCompatActivity {
    private TextView textViewNom, textViewApe, textViewEdad, textViewEs;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madatos_adicionales);
        textViewNom= findViewById(R.id.txtNombreDatoAdicional);
        textViewApe= findViewById(R.id.txtApellidoDatoAdicional);
        textViewEdad = findViewById(R.id.txtEdadDatoAdicional);
        textViewEs= findViewById(R.id.txtEstadoDatoAdicional);
        imageView= findViewById(R.id.imgUserDatoAdicional);
        this.obtener();
    }

    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        Integer img = bundle.getInt("img");
        String nombre = bundle.getString("nombre");
        String apellido = bundle.getString("apellido");
        Integer edad = bundle.getInt("edad");
        String estado=bundle.getString("estado");
        //-----
        imageView.setImageResource(img);
        textViewNom.setText(String.valueOf(nombre));
        textViewApe.setText(String.valueOf(apellido));
        textViewEdad.setText(String.valueOf(edad));
        textViewEs.setText(String.valueOf(estado));

    }
}