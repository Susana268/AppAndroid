package com.sgonzalez.myappgridcolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridColores);
     //   ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,this.imagenes());
     //   gridView.setAdapter(arrayAdapter);

        AdapterGrid adapterGrid = new AdapterGrid(this,R.layout.grid_personalizado,this.imagenes());
        gridView.setAdapter(adapterGrid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                traslado(i);
            }
        });

    }

    private ArrayList<Integer> imagenes(){
        ArrayList<Integer> imagenes = new ArrayList<>();
        imagenes.add(R.color.amarillo);
        imagenes.add(R.color.gris);
        imagenes.add(R.color.morado);
        imagenes.add(R.color.rojo);
        return imagenes;
    }

    private ArrayList<String> valores(){
        ArrayList<String> valores = new ArrayList<>();
        valores.add("#FAFA32");
        valores.add("#AEB6BF");
        valores.add("#8E32FA");
        valores.add("#FA3241");
        return valores;
    }
    private void traslado(int position){
        Intent intent = new Intent(this,MaImagen.class);
        intent.putExtra("imagen",this.imagenes().get(position));
        intent.putExtra("valor",this.valores().get(position));
        startActivity(intent);
    }
}