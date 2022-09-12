package com.sgonzalez.myappswlocal.basedatossw;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sgonzalez.myappswlocal.complementos.Constantes;
import com.sgonzalez.myappswlocal.complementos.ConsultasDAO;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductoDAO implements ConsultasDAO, Response.Listener<JSONObject>,Response.ErrorListener {
    private Integer banderaDeUso = 0;
    @Override
    public boolean insertarSW(ProductoVO pvo, Context context) {
        boolean resultado = false;
        banderaDeUso=Constantes.INSERTAR;
        try{
            //URL por donde se trasladaran los valores a los campos definidos
            String url = Constantes.IPSERVER+"appRestPhpSw2022/insertar.php?nombreProducto="+pvo.getNombreProducto()+
                    "&marcaProducto="+pvo.getMarcaProducto()+
                    "&modeloProducto="+pvo.getModeloProducto()+
                    "&fechaIngreso="+pvo.getFechaIngresoProducto() +
                    "&unidadMedida="+pvo.getUnidadMedidaProducto();
            //Proceso de iteraccion con la API
            RequestQueue requestQueue = Volley.newRequestQueue(context); //define el acceso a la activity para salir a consumir el servicio SW
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;


        }catch (Exception e ){
            Toast.makeText(context,"Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }

    @Override
    public boolean buscarIdSW(ProductoVO pvo, Context context) {
        boolean resultado = false;
        banderaDeUso = Constantes.BUSCARid;
        try {
            String url = Constantes.IPSERVER+"apiRestPhpSw2020/buscrId.php?codigoProducto="+pvo.getCodProducto();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
            requestQueue.add(jsonObjectRequest);
            resultado= true;
        }catch(Exception e){
            Toast.makeText(context,"Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }


    @Override
    public void respuestaBusquedaID(ProductoVO pvo,Context context, JSONObject respuesta) {
        JSONArray jsonArray = respuesta.optJSONArray("producto");
        try{
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            pvo.setCodProducto(jsonObject.optInt("cod_producto"));
            pvo.setNombreProducto(jsonObject.optString("nombre_producto"));
            pvo.setMarcaProducto(jsonObject.optString("marca"));
            pvo.setModeloProducto(jsonObject.optString("modelo"));
            pvo.setFechaIngresoProducto(jsonObject.optString("fecha_ingreso"));
            pvo.setUnidadMedidaProducto(jsonObject.optDouble("unidad_medida"));

        }catch (Exception e){
            e.getMessage();
        }
    }


    @Override
    public void onResponse(JSONObject response) {

        switch (banderaDeUso){
            case 1:
                System.out.println("------ Se Inserto Correctamente-------");
                break;
            case 2:
                ProductoVO pvo = new ProductoVO();
                respuestaBusquedaID(pvo, context,response);
                break;
        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        switch (banderaDeUso){
            case 1:  //Insertar
                System.out.println("------ Error al Insertar-------"+error);
                break;
            case 2:
                break;
        }
    }


}
