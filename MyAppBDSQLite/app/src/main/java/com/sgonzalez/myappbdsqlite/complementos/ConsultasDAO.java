package com.sgonzalez.myappbdsqlite.complementos;

import android.content.Context;
import android.database.Cursor;

import com.sgonzalez.myappbdsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public interface ConsultasDAO {

    public boolean insertarBebida(BebidaVO bvo, Context context);
    public Cursor buscarIdBebida(BebidaVO bvo, Context context);
    public ArrayList<BebidaVO> listarIdBebida(BebidaVO bvo, Context context);
    public boolean actualizarBebida(BebidaVO bvo,Context context);
    public boolean eliminarrBebida(BebidaVO bvo,Context context);

}
