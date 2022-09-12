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

public class MAActualizarSQL extends AppCompatActivity {
    private ListView listView;
    private EditText editTextNombre,editTextSabor,editTextPresentacion,editTextTipo,editTextPrecio;
    private Button button;
    private BebidaVO bvo = new BebidaVO();
    private BebidaDAO bdao = new BebidaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maactualizar_sql);
        listView = findViewById(R.id.lvBebidasActualizar);
        editTextNombre = findViewById(R.id.edtNombreBebidaActualizar);
        editTextSabor = findViewById(R.id.edtSaborBebidaActualizar);
        editTextPresentacion = findViewById(R.id.edtPresentacionBebidaActualizar);
        editTextTipo = findViewById(R.id.edtTipoBebidaActualizar);
        editTextPrecio = findViewById(R.id.edtPrecioBebidaActualizar);

        button = findViewById(R.id.btnActualizarRegistro);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,llenarListaActualizar());
        clickItemLista();
        listView.setAdapter(arrayAdapter);
        this.clickActualizar();
    }

    private void clickItemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                llenarEditTextActualiar(i);
            }
        });
    }
    private void clickActualizar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarRegistro();
            }
        });
    }



    private ArrayList<String> llenarListaActualizar(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarIdBebida(bvo,getApplicationContext())!=null){
            for (BebidaVO listaVO : bdao.listarIdBebida(bvo,getApplicationContext()) ){
                lista.add(listaVO.getCodBebida()+". "+listaVO.getNombreBebida());

            }
        }
        return lista;
    }
    private void llenarEditTextActualiar(int position){
        ArrayList<BebidaVO> datosAcualizar = bdao.listarIdBebida(bvo,getApplicationContext());

        editTextNombre.setText(datosAcualizar.get(position).getNombreBebida());
        editTextSabor.setText(datosAcualizar.get(position).getSaborBebida());
        editTextPresentacion.setText(String.valueOf(datosAcualizar.get(position).getPresentacionBebida()));
        editTextTipo.setText(datosAcualizar.get(position).getTipoBebida());
        editTextPrecio.setText(String.valueOf(datosAcualizar.get(position).getPrecioBebida() ));
        bvo.setCodBebida(datosAcualizar.get(position).getCodBebida());
    }

    private void actualizarRegistro(){
        if(!editTextNombre.getText().toString().isEmpty() &&
           !editTextSabor.getText().toString().isEmpty() &&
           !editTextPresentacion.getText().toString().isEmpty() &&
            !editTextTipo.getText().toString().isEmpty()&&
            !editTextPrecio.getText().toString().isEmpty() ){

                bvo.setNombreBebida(editTextNombre.getText().toString());
                bvo.setSaborBebida(editTextSabor.getText().toString());
                bvo.setPresentacionBebida(Integer.parseInt(editTextPresentacion.getText().toString()));
                bvo.setTipoBebida(editTextTipo.getText().toString());
                bvo.setPrecioBebida(Double.parseDouble(editTextPrecio.getText().toString()));


            if(bdao.actualizarBebida(bvo,getApplicationContext())) {
                editTextNombre.setText("");
                editTextSabor.setText("");
                editTextPresentacion.setText("");
                editTextTipo.setText("");
                editTextPrecio.setText("");

                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,llenarListaActualizar());
                listView.setAdapter(arrayAdapter);

                Toast.makeText(this,"Bebida Actualizada Correctamente",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Error en la actualizacion",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this,"Debe de llenar todos los datos",Toast.LENGTH_SHORT).show();
        }
    }
}