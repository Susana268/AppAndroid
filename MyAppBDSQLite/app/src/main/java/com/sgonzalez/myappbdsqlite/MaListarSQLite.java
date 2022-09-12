package com.sgonzalez.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sgonzalez.myappbdsqlite.basededatos.BebidaDAO;
import com.sgonzalez.myappbdsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public class MaListarSQLite extends AppCompatActivity {
    private ListView listView;
    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_listar_sqlite);
        listView = findViewById(R.id.lvListadoBebidas);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,llenarLista());
        this.clickItemLista();
        listView.setAdapter(arrayAdapter);

    }
    private void clickItemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                trasladarDatos(i,MADetalle.class);
            }
        });
    }

    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarIdBebida(bvo,getApplicationContext()) !=null  ) {
            for (BebidaVO listaVO: bdao.listarIdBebida(bvo,getApplicationContext())) {
                lista.add(listaVO.getNombreBebida());
            }
        }
        return lista;
    }

    private void trasladarDatos(int position,Class actividad){
        Intent intent = new Intent(this,MADetalle.class);
        intent.putExtra("codigo",bdao.listarIdBebida(bvo,getApplicationContext()).get(position).getCodBebida());
        intent.putExtra("nombre",bdao.listarIdBebida(bvo,getApplicationContext()).get(position).getNombreBebida());
        intent.putExtra("sabor",bdao.listarIdBebida(bvo,getApplicationContext()).get(position).getSaborBebida());
        intent.putExtra("presentacion",bdao.listarIdBebida(bvo,getApplicationContext()).get(position).getPresentacionBebida());
        intent.putExtra("tipo",bdao.listarIdBebida(bvo,getApplicationContext()).get(position).getTipoBebida());
        intent.putExtra("precio",bdao.listarIdBebida(bvo,getApplicationContext()).get(position).getPrecioBebida());

        startActivity(intent);
    }
}