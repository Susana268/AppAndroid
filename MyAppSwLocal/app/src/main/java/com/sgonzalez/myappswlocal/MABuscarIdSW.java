package com.sgonzalez.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sgonzalez.myappswlocal.basedatossw.ProductoDAO;
import com.sgonzalez.myappswlocal.basedatossw.ProductoVO;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MABuscarIdSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
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
        textViewCod = findViewById(R.id.txtCodigoBuscar);
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
            if(!pdao.buscarIdSW(pvo,getApplicationContext(),this,this)){
                textViewCod.setText("Codigo: ");
                textViewNom.setText("Nombre: ");
                textViewMa.setText("Marca :");
                textViewMo.setText("Modelo ");
                textViewFecha.setText("Fecha Ingreso: ");
                textViewUnidad.setText("Unidad de Medida:");
                Toast.makeText(this,"Error en la comunicacoin con el servidor de la informacion",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this,"Debe de llenar el cmapo a buscar",Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onResponse(JSONObject response) {
        if(pdao.respuestaBusquedaID(pvo,response)) {

            textViewCod.setText("Codigo: " + pvo.getCodProducto());
            textViewNom.setText("Nombre: " + pvo.getNombreProducto());
            textViewMa.setText("Marca: " + pvo.getMarcaProducto());
            textViewMo.setText("Modelo: " + pvo.getModeloProducto());
      //      textViewFecha.setText("Fecha de Ingreso: " + pvo.getFechaIngresoProducto());
            textViewUnidad.setText("Unidad de Medida :" + pvo.getUnidadMedidaProducto());

            String fecha = pvo.getFechaIngresoProducto();
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             try{
                 Date date = formato.parse(fecha);
                 String fechaFormato = new SimpleDateFormat("dd/MM/yyyy").format(date);
                 textViewFecha.setText("Fecha Ingrso:"+fechaFormato);
             }catch (Exception e){
                 e.getMessage();
             }


        }else{
            textViewCod.setText("Codigo: ");
            textViewNom.setText("Nombre: ");
            textViewMa.setText("Marca :");
            textViewMo.setText("Modelo ");
            textViewFecha.setText("Fecha de Ingreso: ");
            textViewUnidad.setText("Unidad de Medida:");

            Toast.makeText(this,"Datos no encontrados",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }
}