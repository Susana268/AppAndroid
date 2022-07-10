package com.sgonzalez.myappnombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre,editTescEdad;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre=findViewById(R.id.edtNombre);
        textViewResultado=findViewById(R.id.textResultado);
        editTescEdad=findViewById(R.id.edtEdad);

    }

    private  void mostrar(){
        String nombre=editTextNombre.getText().toString();
        String edad=editTescEdad.getText().toString();
        if(!nombre.isEmpty() && !edad.isEmpty(){
            Calendar c= Calendar.getInstance();
            int nacimiento = c.get(Calendar.YEAR) - Integer.parseInt(edad);
            textViewResultado.setText("Su nombre es "+nombre+" y  su nacimiento  "+nacimiento );
        }else {
            Toast.makeText(this, "Dato incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnMostrar:
                this.mostrar();
                break;
        }
    }

}