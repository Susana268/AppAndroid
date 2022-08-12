package com.sgonzalez.myappgridcolores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MaImagen extends AppCompatActivity {
    private ImageView imageView;
    private TextView textViewHex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_imagen);
        imageView=findViewById(R.id.imgColor);
        textViewHex=findViewById(R.id.txtHexColor);

        this.obtener();
    }

    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        Integer imagen = bundle.getInt("imagen");
        String valor = bundle.getString("valor");
        //----
        imageView.setImageResource(imagen);
        textViewHex.setText(String.valueOf(valor));




    }
}