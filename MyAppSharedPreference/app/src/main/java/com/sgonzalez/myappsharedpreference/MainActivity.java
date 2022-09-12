package com.sgonzalez.myappsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre, editTextEdad;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre= findViewById(R.id.edtNombreSP);
        editTextEdad= findViewById(R.id.edEdadSP);
        button = findViewById(R.id.btnAlpacenarSP);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                almacenarDatos();
            }
        });
        this.obtenerDados();
    }

    private void almacenarDatos(){
        if(!editTextNombre.getText().toString().isEmpty() && !editTextEdad.getText().toString().isEmpty()){
            //Instanciar la clase SharedPreference para utilizar su objeto
            // realizar la operacion de almacenado
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
            String nombre = editTextNombre.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());
            // Almacenar los datos que se encuentran en las variables
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre",nombre);
            editor.putInt("edad",edad);
            editor.commit();
            if(editor.commit()==true){
                editTextEdad.setText("");
                editTextNombre.setText("");
                Toast.makeText(this,"Datos Almacenados",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Almacenamiento de los datos",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }
    private void obtenerDados(){
        SharedPreferences preferences = getSharedPreferences("DatosPreferidos",Context.MODE_PRIVATE);
        // se asignan los datos que estan almacenados en el preference
        // Luego definimos valores por defecto ya que el archivo puede estar vacio
        String nombre = preferences.getString("nombre","--");
        int edad = preferences.getInt("edad",0);
        editTextNombre.setText(String.valueOf(nombre));
        editTextEdad.setText(String.valueOf(edad));
    }
}