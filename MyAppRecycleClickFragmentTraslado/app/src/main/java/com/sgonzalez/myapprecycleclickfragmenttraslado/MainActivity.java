package com.sgonzalez.myapprecycleclickfragmenttraslado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rvid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(this.setItem());
        clickRecycler(adaptadorRecycler);

        recyclerView.setAdapter(adaptadorRecycler);

    }

    private void clickRecycler(AdaptadorRecycler adaptadorRecycler){
        adaptadorRecycler.setItemClickListener(new ClickListener(){
            @Override
            public void itemClick(Integer position, View v) {
                trasladarDatosCompletos(position);
                }
        });
    }

    private ArrayList<DatosVo> setItem(){
        ArrayList<DatosVo> item = new ArrayList<>();
        item.add(new DatosVo(R.drawable.ic_tel,
                             R.string.nombre01,
                            R.string.precio01)) ;
        item.add(new DatosVo(R.drawable.ic_lap,
                R.string.nombre02,
                R.string.precio01)) ;
        item.add(new DatosVo(R.drawable.ic_aur,
                R.string.nombre03,
                R.string.precio01)) ;
        item.add(new DatosVo(R.drawable.ic_telev,
                R.string.nombre04,
                R.string.precio01)) ;

        return  item;
    }

    private void trasladarDatosCompletos(int position){
        Intent intent = new Intent(getApplicationContext(),MaInformacionAdicional.class);
        intent.putExtra("nombreD",setItem().get(position).getNombre());
        intent.putExtra("imgD",setItem().get(position).getImagen());
        intent.putExtra("detalle0",datosInformacionAdicional().get(position).getDetalle());
        intent.putExtra("especificacionesD",datosInformacionAdicional().get(position).getEspecificaciones());
        startActivity(intent);

    }

    private ArrayList<DatosVo> datosInformacionAdicional(){
        ArrayList<DatosVo> datosInfo = new ArrayList<>();
        datosInfo.add(new DatosVo(R.string.detalle01,R.string.especificaciones01));
        datosInfo.add(new DatosVo(R.string.detalle02,R.string.especificaciones02));
        datosInfo.add(new DatosVo(R.string.detalle03,R.string.especificaciones03));
        datosInfo.add(new DatosVo(R.string.detalle04,R.string.especificaciones04));
        return datosInfo;
    }

}