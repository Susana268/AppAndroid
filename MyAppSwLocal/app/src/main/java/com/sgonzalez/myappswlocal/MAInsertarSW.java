package com.sgonzalez.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sgonzalez.myappswlocal.basedatossw.ProductoDAO;
import com.sgonzalez.myappswlocal.basedatossw.ProductoVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MAInsertarSW extends AppCompatActivity {
    private  TextInputEditText editTextNombre, editTextMarca, editTextModelo,editTextFechaIngreso,editTextUnidadMedida;
    private MaterialButton button;
    ProductoVO pvo = new ProductoVO();
    ProductoDAO pdao = new ProductoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsertar_sw);
        editTextNombre = findViewById(R.id.tfmNombreInsertar);
        editTextMarca = findViewById(R.id.tfmMarcaInsertar);
        editTextModelo = findViewById(R.id.tfmModeloInsertar);
        editTextFechaIngreso = findViewById(R.id.tfmFechaInsertar);
        editTextUnidadMedida = findViewById(R.id.tfmUnidadMedidaInsertar);
        button = findViewById(R.id.btnmInsertarProducto );
        this.clickRegistrar();

    }

    private void clickRegistrar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarProducto();
            }
        });
    }

    private void registrarProducto(){
        if(!editTextNombre.getText().toString().isEmpty() &&
           !editTextMarca.getText().toString().isEmpty() &&
           !editTextModelo.getText().toString().isEmpty() &&
           !editTextFechaIngreso.getText().toString().isEmpty() &&
           !editTextUnidadMedida.getText().toString().isEmpty() )   {
            pvo.setNombreProducto(editTextNombre.getText().toString());
            pvo.setMarcaProducto(editTextMarca.getText().toString());
            pvo.setModeloProducto(editTextModelo.getText().toString());

           SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy/MM/dd");

           String fecha =editTextFechaIngreso.getText().toString();
           DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

           try{
               Date date = formato.parse(fecha);
               String fechaFormato = new SimpleDateFormat("yyyy/MM/dd").format(date);
               pvo.setFechaIngresoProducto(fechaFormato);
           } catch(ParseException e){
               e.getMessage();
           }

            // pvo.setFechaIngresoProducto(editTextFechaIngreso.getText().toString());
            pvo.setUnidadMedidaProducto(Double.parseDouble(editTextUnidadMedida.getText().toString()));

            if (pdao.insertarSW(pvo,getApplicationContext())){
                editTextNombre.setText("");
                editTextMarca.setText("");
                editTextModelo.setText("");
                editTextFechaIngreso.setText("");
                editTextUnidadMedida.setText("");
                Toast.makeText(this,"Producto Insertado correctamente",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Error en el Registro",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"Debe de llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }


}