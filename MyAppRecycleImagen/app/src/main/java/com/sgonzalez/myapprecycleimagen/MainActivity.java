package com.sgonzalez.myapprecycleimagen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvid);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
       recyclerView.setLayoutManager(new GridLayoutManager(this,3));
       //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(nombreImagen(),fotoImagen());
        recyclerView.setAdapter(adapterRecyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemCuadro:
                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
               // Toast.makeText(this,"Cuadrado",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemLista:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //Toast.makeText(this,"Lista",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<String> nombreImagen(){
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Arbol");
        nombres.add("Copo");
        nombres.add("Diseño");
        nombres.add("Estrella");
        nombres.add("Flor Cerezo");
        nombres.add("Flor Lavanda");
        nombres.add("Luna");
        nombres.add("Ola");
        nombres.add("Cubo de Hielo");
        nombres.add("Sol");
        return nombres;
    }
    private ArrayList<Integer> fotoImagen(){
        ArrayList<Integer> fotos = new ArrayList<>();
        fotos.add(R.drawable.ic_arbol);
        fotos.add(R.drawable.ic_copo);
        fotos.add(R.drawable.ic_flor_cerezo);
        fotos.add(R.drawable.ic_estrella);
        fotos.add(R.drawable.ic_flor_cerezo);
        fotos.add(R.drawable.ic_flor_lavanda);
        fotos.add(R.drawable.ic_luna);
        fotos.add(R.drawable.ic_ola);
        fotos.add(R.drawable.ic_pescado);
        fotos.add(R.drawable.ic_sol);
        return fotos;
    }

}