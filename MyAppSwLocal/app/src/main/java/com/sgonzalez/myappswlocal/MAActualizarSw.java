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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MAActualizarSw extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    private ListView listView;
    private EditText editTextNombre,editTextMarca, editTextModelo,editTextFecha, editTextUnidad;
    private Button button;
    ProductoVO pvo =  new ProductoVO();
    ProductoDAO pdao = new ProductoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maactualizar_sw);
        listView = findViewById(R.id.lvListarActualizarProductos);
        editTextNombre = findViewById(R.id.edtNombreProducto);
        editTextMarca = findViewById(R.id.edtMarcaProducto);
        editTextModelo = findViewById(R.id.edtModeloProducto);
        editTextFecha = findViewById(R.id.edtFechaIngreso);
        editTextUnidad = findViewById(R.id.edtUnidadMedida);

        button = findViewById(R.id.btnActualiarProducto);
        pdao.listarMostrarSW(pvo,getApplicationContext(),this,this);
        this.clickActualiar();
    }

    private void clickActualiar() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarProducto();
            }
        });
    }

    private  void actualizarProducto(){
        if(!editTextNombre.getText().toString().isEmpty() &&
            !editTextMarca.getText().toString().isEmpty() &&
            !editTextModelo.getText().toString().isEmpty() &&
            !editTextFecha.getText().toString().isEmpty() &&
            !editTextUnidad.getText().toString().isEmpty() ){
                pvo.setNombreProducto(editTextNombre.getText().toString());
                pvo.setMarcaProducto(editTextMarca.getText().toString());
                pvo.setModeloProducto(editTextModelo.getText().toString());
                String fecha =editTextFecha.getText().toString();
                DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                try{
                    Date date = formato.parse(fecha);
                    String fechaFormato = new SimpleDateFormat("yyyy/MM/dd").format(date);
                    pvo.setFechaIngresoProducto(fechaFormato);
                } catch(ParseException e){
                    e.getMessage();
                }
                pvo.setUnidadMedidaProducto(Double.parseDouble(editTextUnidad.getText().toString()));

                if(pdao.actualizarSW(pvo,getApplicationContext())){
                    editTextNombre.setText("");
                    editTextMarca.setText("");
                    editTextModelo.setText("");
                    editTextFecha.setText("");
                    editTextUnidad.setText("");
                    Toast.makeText(this,"Cliente Actualiado Correctamente",Toast.LENGTH_SHORT).show();
                    this.recreate();
                }else {
                    Toast.makeText(this,"Error en la actualizacoion",Toast.LENGTH_SHORT).show();
                }

        }else {
            Toast.makeText(this,"Debe llenar todos los campos para poder actualixar",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> lista = new ArrayList<>();
        if(pdao.respuestaListarMostrar(response) != null){
            for (ProductoVO productoVO : pdao.respuestaListarMostrar(response)){
                lista.add(productoVO.getNombreProducto());
            }
        }else{
            Toast.makeText(this,"Errorm no Existen datos",Toast.LENGTH_SHORT).show();
            lista.add("Error");
        }
        //LLenado de la lista a visualizar
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(arrayAdapter);
        //LLenado de los Edit text de forma visual que seran que seran los datos a actualizar
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<ProductoVO> setearEditText= pdao.respuestaListarMostrar(response);
                editTextNombre.setText(setearEditText.get(i).getNombreProducto());
                editTextMarca.setText(setearEditText.get(i).getMarcaProducto());
                editTextModelo.setText(setearEditText.get(i).getModeloProducto());

                String fecha = setearEditText.get(i).getFechaIngresoProducto();
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = formato.parse(fecha);
                    String fechaFormato = new SimpleDateFormat("dd/MM/yyyy").format(date);
                   editTextFecha.setText(fechaFormato);
                }catch (Exception e){
                    e.getMessage();
                }
                editTextUnidad.setText(String.valueOf(setearEditText.get(i).getUnidadMedidaProducto()));
                pvo.setCodProducto(setearEditText.get(i).getCodProducto());
            }
        } );

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }


}