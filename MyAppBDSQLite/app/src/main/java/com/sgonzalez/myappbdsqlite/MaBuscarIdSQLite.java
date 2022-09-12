package com.sgonzalez.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sgonzalez.myappbdsqlite.basededatos.BebidaDAO;
import com.sgonzalez.myappbdsqlite.basededatos.BebidaVO;

public class MaBuscarIdSQLite extends AppCompatActivity {
    private EditText editTextCodigo;
    private ImageButton imageButton;
    private TextView textViewCodigo, textViewNombre, textViewSabor, textViewPresentacion,
                     textViewTipo, textViewPrecio;
    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_buscar_id_sqlite);
        editTextCodigo = findViewById(R.id.edtCodigoBuscar);
        textViewCodigo= findViewById(R.id.txtCodigoBuscar);
        textViewNombre = findViewById(R.id.txtNombreBuscar);
        textViewSabor = findViewById(R.id.txtSaborBuscar);
        textViewPresentacion = findViewById(R.id.txtPresentacionBuscar);
        textViewTipo = findViewById(R.id.txtTipoBuscar);
        textViewPrecio = findViewById(R.id.txtPrecioBuscar);
        imageButton = findViewById(R.id.imgBuscar);
        this.clickBuscar();
    }

    private void clickBuscar(){
        imageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                buscarIdBebida();
            }
        });
    }

    private void buscarIdBebida(){
        if(!editTextCodigo.getText().toString().isEmpty()){

            bvo.setCodBebida(Integer.parseInt(editTextCodigo.getText().toString()));
            if(  bdao.buscarIdBebida(bvo,getApplicationContext())!=null  ) {
                if(  bdao.buscarIdBebida(bvo,getApplicationContext()).getCount()>0  ) {
                    textViewCodigo.setText(String.valueOf(bvo.getCodBebida()));
                    textViewNombre.setText(String.valueOf(bvo.getNombreBebida()));
                    textViewSabor.setText(String.valueOf(bvo.getSaborBebida()));
                    textViewPresentacion.setText(String.valueOf(bvo.getPresentacionBebida()));
                    textViewTipo.setText(String.valueOf(bvo.getTipoBebida()));
                    textViewPrecio.setText(String.valueOf(bvo.getPrecioBebida()));
                } else {
                    textViewCodigo.setText("");
                    textViewNombre.setText("");
                    textViewSabor.setText("");
                    textViewPresentacion.setText("");
                    textViewTipo.setText("");
                    textViewPrecio.setText("");
                    Toast.makeText(getApplicationContext(),"No se encontro Bebida con ese Codigo", Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(getApplicationContext(),"Error en la Busqueda", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getApplicationContext(),"Debe de llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }
}