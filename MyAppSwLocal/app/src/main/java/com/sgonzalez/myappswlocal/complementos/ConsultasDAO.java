package com.sgonzalez.myappswlocal.complementos;

import android.content.Context;

import com.sgonzalez.myappswlocal.basedatossw.ProductoVO;

import org.json.JSONObject;

public interface ConsultasDAO {
    public boolean insertarSW(ProductoVO pvo, Context context);
    public boolean buscarIdSW(ProductoVO pvo, Context context);
    public void respuestaBusquedaID(ProductoVO pvo,Context context,JSONObject respuesta);

}
