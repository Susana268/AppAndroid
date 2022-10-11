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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,null,this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;


        }catch (Exception e ){
            Toast.makeText(context,"Error en la conexion"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }

    @Override
    public boolean buscarIdSW(ProductoVO pvo, Context context,Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"appRestPhpSw2022/buscarId.php?codigoProducto="+pvo.getCodProducto();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
            resultado= true;
        }catch(Exception e){
            Toast.makeText(context,"Error en la conexion"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }


    @Override
    public boolean respuestaBusquedaID(ProductoVO pvo,JSONObject respuesta) {
        boolean resultado = false;
        JSONArray jsonArray = respuesta.optJSONArray("producto");
        try{
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            pvo.setCodProducto(jsonObject.optInt("cod_producto"));
            pvo.setNombreProducto(jsonObject.optString("nombre_producto"));
            pvo.setMarcaProducto(jsonObject.optString("marca"));
            pvo.setModeloProducto(jsonObject.optString("modelo"));
            pvo.setFechaIngresoProducto(jsonObject.optString("fecha_ingreso"));
            pvo.setUnidadMedidaProducto(jsonObject.optDouble("unidad_medida"));
            //Validacion del error en la obtencion de datos
            String identificadorDeError = jsonObject.optString("error");
            if(identificadorDeError.isEmpty())
                resultado = true;
            else
                resultado = false;
        }catch (JSONException e){
             System.err.println(e.getMessage());
             e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean listarMostrarSW(ProductoVO pvo, Context context, Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try{
            String url = Constantes.IPSERVER+"appRestPhpSw2022/listarMostrar.php";
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                    listener,errorListener);
            requestQueue.add(jsonObjectRequest);
            resultado=true;

        }catch (Exception e){
            Toast.makeText(context,"Error en la conexion"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }

    @Override
    public ArrayList<ProductoVO> respuestaListarMostrar(JSONObject respuesta) {
        ArrayList<ProductoVO> arrayListVo = new ArrayList<>();
        JSONArray jsonArray = respuesta.optJSONArray("producto");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                ProductoVO pVO = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                pVO.setCodProducto(jsonObject.optInt("cod_producto"));
                pVO.setNombreProducto(jsonObject.optString("nombre_producto"));
                pVO.setMarcaProducto(jsonObject.optString("marca"));
                pVO.setModeloProducto(jsonObject.optString("modelo"));
                pVO.setFechaIngresoProducto(jsonObject.optString("fecha_ingreso"));
                pVO.setUnidadMedidaProducto(jsonObject.optDouble("Unidad_medida"));
                arrayListVo.add(pVO);
            }

        }catch (JSONException e) {
            System.err.println("----" + e.getMessage());
            e.printStackTrace();
        }
        return arrayListVo;
    }

    @Override
    public boolean actualizarSW(ProductoVO pvo, Context context) {
        boolean resultado = false;
        banderaDeUso = Constantes.ACTUALIZAR;
        try {
            String url = Constantes.IPSERVER + "appRestPhpSw2022/actualizar.php?nombreProducto=" + pvo.getNombreProducto()
                    + "&marcaProducto=" + pvo.getMarcaProducto()
                    + "&modeloProducto=" + pvo.getModeloProducto()
                    + "&fechaIngreso=" + pvo.getFechaIngresoProducto()
                    + "&unidaMedida=" + pvo.getUnidadMedidaProducto()
                    + "&codigoProducto=" + pvo.getCodProducto();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,null,this);
            requestQueue.add(jsonObjectRequest);
            resultado=true;
        }catch(Exception e){
            Toast.makeText(context,"Error en la conexion"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
            return resultado;

    }

    @Override
    public boolean eliminarSW(ProductoVO pvo, Context context) {
        boolean resultado = false;
        banderaDeUso = Constantes.ELIMINAR;
        try{
            String url = Constantes.IPSERVER+"appRestPhpSw2022/eliminar.php?codigoProducto = "+pvo.getCodProducto();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,null,this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;

        }catch(Exception e){
            Toast.makeText(context,"Error en la conexion"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }

    @Override
    public void onResponse(JSONObject response) {

        switch (banderaDeUso){


        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        switch (banderaDeUso){
            case 1:  //Insertar
                System.err.println(error);
                break;
            case 2: //Actualizar
                System.err.println(error);
                break;
            case 3:
                System.err.println(error);
                break;

        }
    }


}
