package com.sgonzalez.myappfragmentcine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MaCompra extends AppCompatActivity {
    private TextView textViewPrecio,textViewTotalCompra;
    private EditText editTextCantidad;
    double total;
    private Button buttonConfirmaComprar;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_compra);
        textViewPrecio = findViewById(R.id.txtPrecioCompra);
        editTextCantidad =findViewById(R.id.edtCantidad);
        textViewTotalCompra = findViewById(R.id.txtTotalCompra);
        buttonConfirmaComprar = findViewById(R.id.btnConfirmaCompra);
        this.obtener();

        EventoTeclado teclado = new EventoTeclado();
        editTextCantidad.setOnEditorActionListener(teclado);
        this.eventos();
    }

    private void eventos(){
        buttonConfirmaComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 confirmaCompra();
            }
        });

    }

    private void confirmaCompra(){
        Toast.makeText( this,"Compra Confirmada",Toast.LENGTH_SHORT).show();
    }


    private void obtener(){
        Bundle bundle = getIntent().getExtras();
        int precio = bundle.getInt("precioD");
       // textViewPrecio.setText(String.valueOf(precio));
        textViewPrecio.setText(precio);
    }

    private void calculoTotal(){
        if(Double.parseDouble(editTextCantidad.getText().toString())>0 &
           Double.parseDouble(textViewPrecio.getText().toString())>0  )
            total = Double.parseDouble(editTextCantidad.getText().toString()) *
           Double.parseDouble(textViewPrecio.getText().toString()) ;
        else {
            total=0;
        }
      textViewTotalCompra.setText(""+total);
    }

    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            calculoTotal();
            return false;
        }
    }
}