package com.sgonzalez.myappsumar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre,editTextEdad;
    private TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre=findViewById(R.id.txtNombre);
        editTextEdad=findViewById(R.id.txtEdad);
        textViewResultado = findViewById(R.id.txtResultado);

    }

    public void seleccion(){
        String nom = editTextNombre.getText().toString();
        String edad = editTextEdad.getText().toString();
        if(!nom.isEmpty()&&!edad.isEmpty()){
            int valorEdad = Integer.parseInt(edad);
            if (valorEdad<18) {
                textViewResultado.setText("Es un Niño");

                Intent intent=new Intent(this,MainActivity2.class);
                startActivity(intent);

            }else{
                textViewResultado.setText("Es un Adulto");
                Intent intent=new Intent(this,MainActivity3.class);
                startActivity(intent);
            }
        }else {
            Toast.makeText(this, "Los datos no fueron Ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClick(View view){
            this.seleccion();
    }
}