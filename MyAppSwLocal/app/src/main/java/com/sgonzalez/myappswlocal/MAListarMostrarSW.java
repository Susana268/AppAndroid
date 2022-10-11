package com.sgonzalez.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sgonzalez.myappswlocal.basedatossw.ProductoDAO;
import com.sgonzalez.myappswlocal.basedatossw.ProductoVO;

import org.json.JSONObject;

import java.util.ArrayList;

public class MAListarMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    private ListView listView;
    private ProductoVO pvo = new ProductoVO();
    private ProductoDAO pdao = new ProductoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malistar_mostrar_sw);
        listView = findViewById(R.id.lvListarProducto);

        pdao.listarMostrarSW(pvo,getApplicationContext(),this,this);

    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> lista = new ArrayList<>();
        if (pdao.respuestaListarMostrar(response) != null) {
            for(ProductoVO productoVO: pdao.respuestaListarMostrar(response)){
                lista.add(productoVO.getCodProducto()+"."+productoVO.getNombreProducto());
            }
        }else {
            Toast.makeText(this,"Error no existen datos",Toast.LENGTH_SHORT).show();
            lista.add("Error");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }
}