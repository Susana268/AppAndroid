package com.sgonzalez.myapplistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityVocales extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vocales);

        textView=findViewById(R.id.txtVocal);
        imageView=findViewById(R.id.imgVocal);
        this.obtener();
    }
    private void obtener(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagenes");
        int info = bundle.getInt("informacion");
        imageView.setImageResource(imagen);
        textView.setText(info);
    }
}