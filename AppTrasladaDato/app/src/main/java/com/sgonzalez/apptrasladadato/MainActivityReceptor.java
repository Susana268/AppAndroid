package com.sgonzalez.apptrasladadato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityReceptor extends AppCompatActivity {
    private TextView textViewN,textViewA,textViewE,
                     textViewD,textViewT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_receptor);
        textViewN=findViewById(R.id.txtNombre);
        textViewA=findViewById(R.id.txtApellido);
        textViewD=findViewById(R.id.edtDireccion);
        textViewE=findViewById(R.id.edtEdad);
        textViewT=findViewById(R.id.edtTelefono);
        obtenerDatosTrasladados();
    }
    private void obtenerDatosTrasladados(){
        //Agregamos el objeto Bundle para poder recibir los datos trasladados
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String nombre = bundle.getString("nom");
            String apellido =bundle.getString("ape");
            String edad = bundle.getString("eda");
            String direccion =bundle.getString("dir");
            String telefono = bundle.getString("tel");
            textViewN.setText("Nombre: "+nombre);
            textViewA.setText("Apellido: "+apellido);
            textViewE.setText("Edad: "+edad);
            textViewD.setText("Direccion "+direccion);
            textViewT.setText("Telefono: "+telefono);

        }else {
            Toast.makeText(this,"Datos no encontrados",Toast.LENGTH_SHORT).show();
        }
    }
}