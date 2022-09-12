package com.sgonzalez.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.sgonzalez.myappbdsqlite.basededatos.BebidaDAO;
import com.sgonzalez.myappbdsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public class MAEliminarSQLite extends AppCompatActivity {

    private ListView listView;
    private EditText editTextNombre;
    private Button button;
    private BebidaVO bvo = new BebidaVO();
    private BebidaDAO bdao = new BebidaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maeliminar_sqlite);

        listView = findViewById(R.id.lvBebidasEliminar);
        editTextNombre = findViewById(R.id.edtNombreBebidaEliminar);
        button = findViewById(R.id.btnEliminarRegistro);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,llenarLista());
        this.clickIemLista();
        listView.setAdapter(arrayAdapter);
        this.clickEliminar();
    }

    private void clickIemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                llenarEditTextNombre(i);
            }
        });

    }

    private void clickEliminar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarRegistro();
            }
        });

    }
    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<>();

        if(bdao.listarIdBebida(bvo,getApplicationContext()) != null){

        for (BebidaVO vo : bdao.listarIdBebida(bvo,getApplicationContext())){
            lista.add(vo.getCodBebida()+". "+vo.getNombreBebida());
        }
        }
        return lista;
    }

    private void llenarEditTextNombre(int position){
        ArrayList<BebidaVO> datoEliminar = bdao.listarIdBebida(bvo,getApplicationContext());
        editTextNombre.setText(datoEliminar.get(position).getNombreBebida());
        bvo.setCodBebida(datoEliminar.get(position).getCodBebida());
    }

    private void eliminarRegistro(){
        if (!editTextNombre.getText().toString().isEmpty()){
            if(bdao.eliminarrBebida(bvo,getApplicationContext())){
                editTextNombre.setText("");
                Toast.makeText(this,"Bebida Eliminada Correctamente",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Error en la eliminacion",Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this,"Debe Elegir una bebida para eliminar",Toast.LENGTH_SHORT).show();
        }
    }
}
