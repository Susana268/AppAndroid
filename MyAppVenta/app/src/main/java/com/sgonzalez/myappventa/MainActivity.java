package com.sgonzalez.myappventa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre,editTextValor,editTextCantidad;
    private TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre=findViewById(R.id.edtNombre);
        editTextValor=findViewById(R.id.edtValor);
        editTextCantidad=findViewById(R.id.edtCantidad);
        textViewResultado=findViewById(R.id.txtResultado);

    }
    private void calcular(){
        String nombre=editTextNombre.getText().toString();
        String valor=editTextValor.getText().toString();
        String cantidad=editTextCantidad.getText().toString();
        if  (!nombre.isEmpty()&& !valor.isEmpty()&& !cantidad.isEmpty())  {
            double total = Double.parseDouble(valor)*Integer.parseInt(cantidad);
            double totalIva = total*1.12;
            textViewResultado.setText(String.valueOf(totalIva));
        }
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnMostrar:
                this.calcular();
                break;
        }
    }
}