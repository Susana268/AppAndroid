package com.sgonzalez.myappsaredcuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre, editTextApellido, editTextEdad, editTextDireccion;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextApellido = findViewById(R.id.edtApellido);
        editTextEdad = findViewById(R.id.edtEdad);
        editTextDireccion = findViewById(R.id.edtDireccion);
        button = findViewById(R.id.btnAlmacenarSP);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                almacenarDatos();
            }
        });
    this.obtenerDatos();

    }
    private void almacenarDatos(){
        if(!editTextNombre.getText().toString().isEmpty()&&
           !editTextApellido.getText().toString().isEmpty()&&
           !editTextEdad.getText().toString().isEmpty()&&
           !editTextDireccion.getText().toString().isEmpty() ){
            //Instanciar la clase SharedPreference
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);

            String nombre = editTextNombre.getText().toString();
            String apellido = editTextApellido.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());
            String direccion = editTextDireccion.getText().toString();

            //Almacenar los datos
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre",nombre);
            editor.putString("apellido",apellido);
            editor.putInt("edad",edad);
            editor.putString("direccion",direccion);
            editor.commit();
            if (editor.commit()==true){
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextEdad.setText("");
                editTextDireccion.setText("");
                Toast.makeText(this, "Datos Almacenados", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Almacenamiento de los datos", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Debe llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
    private void obtenerDatos(){
        SharedPreferences preferences= getSharedPreferences("DatosPreferidos",Context.MODE_PRIVATE);
        //Se asignan los datos
        String nombre = preferences.getString("nombre","");
        String apellido = preferences.getString("apellido","");
        int edad = preferences.getInt("edad",0);
        String direccion = preferences.getString("direccion","");
        editTextNombre.setText(String.valueOf(nombre));
        editTextApellido.setText(String.valueOf(apellido));
        editTextEdad.setText(String.valueOf(edad));
        editTextDireccion.setText(String.valueOf(direccion));

    }

}