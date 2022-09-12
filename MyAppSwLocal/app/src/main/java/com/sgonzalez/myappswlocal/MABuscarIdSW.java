package com.sgonzalez.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sgonzalez.myappswlocal.basedatossw.ProductoDAO;
import com.sgonzalez.myappswlocal.basedatossw.ProductoVO;

public class MABuscarIdSW extends AppCompatActivity {
    private EditText editTextCodigo;
    private TextView textViewCod, textViewNom, textViewMa, textViewMo, textViewFecha, textViewUnidad;
    private ImageButton imageButton;
    ProductoDAO pdao = new ProductoDAO();
    ProductoVO pvo = new ProductoVO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabuscar_id_sw);
        editTextCodigo = findViewById(R.id.edtCodigoProductoBuscar);
        textViewCod = findViewById(R.id.edtCodigoProductoBuscar);
        textViewNom = findViewById(R.id.txtNombreBuscar);
        textViewMa = findViewById(R.id.txtMarcaBuscar);
        textViewMo = findViewById(R.id.txtModeloBuscar);
        textViewFecha= findViewById(R.id.txtFechaBuscar);
        textViewUnidad = findViewById(R.id.txtUnidadBuscar);
        imageButton = findViewById(R.id.imbBuscar);
        this.clickBuscar();

    }

    private void clickBuscar(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarClientePorCodigo();
            }
        });
    }
    private void buscarClientePorCodigo(){
        if(!editTextCodigo.getText().toString().isEmpty()){
            pvo.setCodProducto(Integer.parseInt(editTextCodigo.getText().toString()));
            if(pdao.buscarIdSW(pvo,getApplicationContext())){
                textViewCod.setText("Codigo: "+pvo.getCodProducto());
                textViewNom.setText("Nombre: "+pvo.getNombreProducto());
                textViewMa.setText("Marca: "+pvo.getMarcaProducto());
                textViewMo.setText("Modelo: "+pvo.getModeloProducto());
                textViewFecha.setText("Fecha: "+pvo.getFechaIngresoProducto());
                textViewUnidad.setText("Unidad :"+pvo.getUnidadMedidaProducto() );
            }else{
                textViewCod.setText("Codigo: ");
                textViewNom.setText("Nombre: ");
                textViewMa.setText("Marca :");
                textViewMo.setText("Modelo ");
                textViewFecha.setText("Fecha: ");
                textViewUnidad.setText("Unidad:");
                //Ponerlo como el la patalla
                Toast.makeText(this,"Datos No Encontrados",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this,"Sin datos",Toast.LENGTH_SHORT).show();
        }
    }
}