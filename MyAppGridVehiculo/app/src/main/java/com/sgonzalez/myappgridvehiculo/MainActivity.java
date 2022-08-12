package com.sgonzalez.myappgridvehiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridVehiculos);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,this.vehiculos());
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"A pulsado"+vehiculos().get(i),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<String> vehiculos(){
        ArrayList<String> vehiculos = new ArrayList<>();
        vehiculos.add("Toyota");
        vehiculos.add("Mazda");
        vehiculos.add("Audi");
        vehiculos.add("Camaro");
        vehiculos.add("Volks Wagen");
        vehiculos.add("Zusuki");
        vehiculos.add("Corvet");
        vehiculos.add("Chevrolet");
        vehiculos.add("Nissan");
        vehiculos.add("Hyundai");
        return vehiculos;

    }


}