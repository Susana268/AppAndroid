package com.sgonzalez.myapplistview;

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
    ArrayList<String> vocales = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       listView=findViewById(R.id.listVocales);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,vocales());
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

    private ArrayList<String> vocales(){
        this.vocales.add("A");
        this.vocales.add("E");
        this.vocales.add("I");
        this.vocales.add("O");
        this.vocales.add("U");
        return vocales;
    }

    private ArrayList<Integer > imagenes (){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_a);
        img.add(R.drawable.ic_e);
        img.add(R.drawable.ic_i);
        img.add(R.drawable.ic_o);
        img.add(R.drawable.ic_u);
        return img;
    }
    private ArrayList<Integer> informacion(){
        ArrayList<Integer> info= new ArrayList<>();
        info.add(R.string.vocalA);
        info.add(R.string.vocalE);
        info.add(R.string.vocalI);
        info.add(R.string.vocalO);
        info.add(R.string.vocalU);
        return info;
    }
    private void traslado(int position){
        Intent intent = new Intent(this, MainActivityVocales.class);
        intent.putExtra("imagenes",imagenes().get(position));
        intent.putExtra("informacion",informacion().get(position));
        startActivity(intent);
    }
}