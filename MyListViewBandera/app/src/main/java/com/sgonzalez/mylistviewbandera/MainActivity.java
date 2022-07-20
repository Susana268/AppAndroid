package com.sgonzalez.mylistviewbandera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<String> paises = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listPaises);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,paises());
        listView.setAdapter(arrayAdapter);
        this.clickItem();
    }

    public void clickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                traslado(i);
            }
        });
    }
    private ArrayList<String> paises(){
        this.paises.add("Guatemala");
        this.paises.add("El Salvador");
        this.paises.add("Honduras");
        this.paises.add("Nicaragua");
        this.paises.add("Costa Rica");
        this.paises.add("Panama");
        this.paises.add("Brasil");
        this.paises.add("Chile");
        this.paises.add("Ecuador");
        this.paises.add("Venezuela");
        return paises;
    }
     // Metodo que retorna un array para imagenes
    private ArrayList<Integer> imagenes(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_guatemala);
        img.add(R.drawable.ic_el_salvador);
        img.add(R.drawable.ic_honduras);
        img.add(R.drawable.ic_nicaragua);
        img.add(R.drawable.ic_costa_rica);
        img.add(R.drawable.ic_panama);
        img.add(R.drawable.ic_brasil);
        img.add(R.drawable.ic_chile);
        img.add(R.drawable.ic_ecuador);
        img.add(R.drawable.ic_venezuela);
        return img;
    }
    // Metodo que retorna un array con los datos
    private ArrayList<Integer> informacion(){
        ArrayList<Integer> info = new ArrayList<>();
        info.add(R.string.PGuatemala);
        info.add(R.string.PSalvador);
        info.add(R.string.PHonduras);
        info.add(R.string.PNicaragua);
        info.add(R.string.PCostaRica);
        info.add(R.string.PPanama);
        info.add(R.string.PBrasil);
        info.add(R.string.PChile);
        info.add(R.string.PEcuador);
        info.add(R.string.PVenezuela);
        return info;
    }
    //Metodo que hara la apertura y traslado de datos a otra activity
    private void traslado(int position){
        Intent intent = new Intent(this,MainPaises.class);
        intent.putExtra("imagenes",imagenes().get(position));
        intent.putExtra("informacion",informacion().get(position));
        startActivity(intent);
    }
}