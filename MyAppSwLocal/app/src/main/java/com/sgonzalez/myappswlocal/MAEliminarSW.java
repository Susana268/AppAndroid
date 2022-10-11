package com.sgonzalez.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sgonzalez.myappswlocal.basedatossw.ProductoDAO;
import com.sgonzalez.myappswlocal.basedatossw.ProductoVO;

import org.json.JSONObject;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MAEliminarSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener   {
    private ListView listView;
    private EditText editTextNom, editTextMarca, editTextModelo, editTextFecha,editTextUnidad;
    private Button button;
    ProductoVO pvo= new ProductoVO();
    ProductoDAO pdao = new ProductoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maeliminar_sw);

        listView  = findViewById(R.id.lvListarEliminarProductos);
        editTextNom= findViewById(R.id.edtNombreProductoE);
        editTextMarca = findViewById(R.id.edtMarcaProductoE);
        editTextModelo = findViewById(R.id.edtModeloProductoE);
        editTextFecha = findViewById(R.id.edtFechaIngresoE);
        editTextUnidad = findViewById(R.id.edtUnidadMedidaE);

        button = findViewById(R.id.btnEliminarProductoE);
        pdao.listarMostrarSW(pvo,getApplicationContext(),this,this);
        this.clickEliminar();
    }

    private void clickEliminar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCliente();
            }
        });
    }

    public void eliminarCliente(){
        if(!editTextNom.getText().toString().isEmpty() &&
            !editTextMarca.getText().toString().isEmpty()&&
            !editTextModelo.getText().toString().isEmpty()&&
            !editTextFecha.getText().toString().isEmpty()&&
            !editTextUnidad.getText().toString().isEmpty()){

            if(pdao.eliminarSW(pvo,getApplicationContext())){
                editTextNom.setText("");
                editTextMarca.setText("");
                editTextModelo.setText("");
                editTextFecha.setText("");
                editTextUnidad.setText("");
                Toast.makeText(this,"Eliminado Correctamente",Toast.LENGTH_SHORT).show();
                this.recreate();

            }else{
                Toast.makeText(this,"Error en Eliminacion",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this,"Campos ara poder Eliminar",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> lista = new ArrayList<>();
        if(pdao.respuestaListarMostrar(response)!=null){
            for (ProductoVO pvo:pdao.respuestaListarMostrar(response)){
                lista.add(pvo.getNombreProducto());

            }

        }else{
            Toast.makeText(this,"rror, no exite dato",Toast.LENGTH_SHORT).show();
            lista.add("ERROR");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(arrayAdapter);
        //Comportamiento de la lista al pulsar los items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<ProductoVO> llenarEditText = pdao.respuestaListarMostrar(response);
                editTextNom.setText(llenarEditText.get(i).getNombreProducto());;
                editTextMarca.setText(llenarEditText.get(i).getMarcaProducto());
                editTextModelo.setText(llenarEditText.get(i).getModeloProducto());;
                String fecha = llenarEditText.get(i).getFechaIngresoProducto();
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                try{
                    Date date = formato.parse(fecha);
                    String fechaFormato = new SimpleDateFormat("dd/MM/yyyy").format(date);
                    editTextFecha.setText(fechaFormato);
                }catch(Exception e){
                    e.getMessage();
                }


                editTextUnidad.setText(String.valueOf(llenarEditText.get(i).getUnidadMedidaProducto()));
                pvo.setCodProducto(llenarEditText.get(i).getCodProducto());

            }
        });


    }
}