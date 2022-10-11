package com.sgonzalez.myappswlocal.complementos;

import android.content.Context;

import com.android.volley.Response;
import com.sgonzalez.myappswlocal.basedatossw.ProductoVO;

import org.json.JSONObject;

import java.util.ArrayList;

public interface ConsultasDAO {
    public boolean insertarSW(ProductoVO pvo, Context context);
    public boolean buscarIdSW(ProductoVO pvo, Context context,Response.Listener listener,Response.ErrorListener errorListener) ;
    public boolean respuestaBusquedaID(ProductoVO pvo,JSONObject respuesta);
    public boolean listarMostrarSW(ProductoVO pvo,Context context,Response.Listener listener,Response.ErrorListener errorListener);
    public ArrayList<ProductoVO> respuestaListarMostrar(JSONObject respuesta);
    public boolean actualizarSW(ProductoVO pvo, Context context);
    public boolean eliminarSW(ProductoVO pvo,Context context);
}
