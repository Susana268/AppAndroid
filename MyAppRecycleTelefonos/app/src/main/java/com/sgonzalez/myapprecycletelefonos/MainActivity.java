package com.sgonzalez.myapprecycletelefonos;

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
        datos.add(new DatosVo("Pedro Perez","54852569",R.drawable.ic_hombre));
        datos.add(new DatosVo("Juana Lopez","56458575",R.drawable.ic_soltera));
        datos.add(new DatosVo("Abue Papa","78451295",R.drawable.ic_abue));
        datos.add(new DatosVo("Anita Pereira","95854563",R.drawable.ic_persona));
        datos.add(new DatosVo("Jose Matias","23524156",R.drawable.ic_silu));
        datos.add(new DatosVo("Veterinaria","87456985",R.drawable.ic_perro));
        datos.add(new DatosVo("Comida Gato","86325478",R.drawable.ic_gato));
        datos.add(new DatosVo("Romeo Ruiz","84521232",R.drawable.ic_ava));
        datos.add(new DatosVo("Servicios","73714965",R.drawable.ic_telefono));
        datos.add(new DatosVo("Abue Mama","65251478",R.drawable.ic_abue));
        return datos;
    }
}