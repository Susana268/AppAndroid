package com.sgonzalez.myappfragmentcine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rvid);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(this.setItem());

        clickRecycler(adaptadorRecyclerView);

        recyclerView.setAdapter(adaptadorRecyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemCuadro:
                recyclerView.setLayoutManager(new GridLayoutManager(this,2));
                //Toast.makeText(this, "Cuadro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemLista:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //Toast.makeText(this, "Lista", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void clickRecycler(AdaptadorRecyclerView adaptadorRecyclerView){
        adaptadorRecyclerView.setItemClickListener(new ClickListener() {
            @Override
            public void itemClick(Integer position, View v) {

                        trasladarDatosPrincipales(position);
//                        trasladarInformacionAdicional(position);

            }
        });
    }

    private ArrayList<DatosVo> setItem(){
        ArrayList<DatosVo> item = new ArrayList<>();
        item.add(new DatosVo(R.drawable.ic_lachica,R.string.nombre01,R.string.duracion01,R.string.precio01));
        item.add(new DatosVo(R.drawable.ic_thor,R.string.nombre02,R.string.duracion02,R.string.precio02));
        item.add(new DatosVo(R.drawable.ic_elfantasma,R.string.nombre03,R.string.duracion03,R.string.precio03));
        item.add(new DatosVo(R.drawable.ic_titanic,R.string.nombre04,R.string.duracion04,R.string.precio04));
        item.add(new DatosVo(R.drawable.ic_alarido,R.string.nombre05,R.string.duracion05,R.string.precio05));
        item.add(new DatosVo(R.drawable.ic_nop,R.string.nombre06,R.string.duracion06,R.string.precio06));
        return item;
    }

    private void trasladarDatosPrincipales(int position){
        Intent intent = new Intent(getApplicationContext(),MaInformacionAdicional.class);
        intent.putExtra("nombreD",setItem().get(position).getNombre());
        intent.putExtra("imagenD",setItem().get(position).getImagen());
        intent.putExtra("precioD",setItem().get(position).getPrecio());

        intent.putExtra("sinopsisD",datosInformacionAdicional().get(position).getSinopsis());
        intent.putExtra("directorD",datosInformacionAdicional().get(position).getDirector());
        intent.putExtra("puntuacionD",datosInformacionAdicional().get(position).getPuntuacion());

        startActivity(intent);
    }

    private ArrayList<DatosVo> datosInformacionAdicional(){
        ArrayList<DatosVo> datosInfo = new ArrayList<>();
        datosInfo.add(new DatosVo(R.string.sinopsis01,R.string.director01,R.string.puntuacion01));
        datosInfo.add(new DatosVo(R.string.sinopsis02,R.string.director02,R.string.puntuacion02));
        datosInfo.add(new DatosVo(R.string.sinopsis03,R.string.director03,R.string.puntuacion03));
        datosInfo.add(new DatosVo(R.string.sinopsis04,R.string.director04,R.string.puntuacion04));
        datosInfo.add(new DatosVo(R.string.sinopsis05,R.string.director05,R.string.puntuacion05));
        datosInfo.add(new DatosVo(R.string.sinopsis06,R.string.director06,R.string.puntuacion06));
        return datosInfo;
    }


}