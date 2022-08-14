package com.sgonzalez.myapprecycleviewvo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdaptadorRecycleView adaptadorRecycleView = new AdaptadorRecycleView(this.datosVo());
        recyclerView.setAdapter(adaptadorRecycleView);
    }

    private ArrayList<DatosVo> datosVo(){
        ArrayList<DatosVo> datos = new ArrayList<>();
        datos.add(new DatosVo("La hamburguesa gigante","Muy deliciosas y gigantes",R.drawable.ic_ham));
        datos.add(new DatosVo("Pizza X2","Muy deliciosas y gigantes",R.drawable.ic_papas));
        datos.add(new DatosVo("Super Tacos","Muy deliciosas y gigantes",R.drawable.ic_taco));

        return datos;
    }
    }