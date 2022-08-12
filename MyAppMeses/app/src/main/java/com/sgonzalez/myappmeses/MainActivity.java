package com.sgonzalez.myappmeses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listMeses);
       // ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,meses());
        AdapterPersonalizado adapterPersonalizado= new AdapterPersonalizado(this,R.layout.list_personalizada,
                numeroMes(),meses(),
                descripcionCelebracionMes(),
                celebracionMes());
        listView.setAdapter(adapterPersonalizado);

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
            case R.id.item1:
            Toast.makeText(this,"Los meses del año son Enero,Febrero,Marzo,Abril,Mayo,Junio,Julio,Agosto,Septiembre,Octurbre,Noviembre,Diciembre",Toast.LENGTH_SHORT).show();
            break;
            case R.id.item2:
            Toast.makeText(this,"Enero,Marzo,Mayo,Julio,Agosto,Octubre,Diciembre tiene 31 duas, Febrero 28 y el resto 30",Toast.LENGTH_SHORT).show();
            break;
        }
        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Integer> numeroMes(){
        ArrayList<Integer> numeroMes = new ArrayList<>();
        for(int i = 1 ; i<=12;i++ ){
            numeroMes.add(i);
        }

        return numeroMes;
    }
    private ArrayList<String> meses(){
        ArrayList<String> meses = new ArrayList<>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");
        return meses;
    }
    private ArrayList<String> celebracionMes(){
        ArrayList<String> celebracionMes = new ArrayList<>();
        celebracionMes.add("Celebración: Año Nuevo");
        celebracionMes.add("Celebración: Huelga de Dolores");
        celebracionMes.add("Celebración: Semana Santa");
        celebracionMes.add("Celebración: Semana Santa");
        celebracionMes.add("Celebración: Santa Cruz");
        celebracionMes.add("Celebración: Baile de los Gigantes");
        celebracionMes.add("Celebración: Fiesta Nacional Indígena Rabin Ajaw");
        celebracionMes.add("Celebración: Festival Folklórico Nacional El Paab’anc");
        celebracionMes.add("Celebración: Día de la Independencia");
        celebracionMes.add("Celebración: San Francisco de Asís");
        celebracionMes.add("Celebración: Todos los Santos");
        celebracionMes.add("Celebración: Quema del Diablo");
        return celebracionMes;

    }

    private ArrayList<Integer> descripcionCelebracionMes(){
        ArrayList<Integer> descripcionCelebracionMes = new ArrayList<>();
        descripcionCelebracionMes.add(R.string.mes1);
        descripcionCelebracionMes.add(R.string.mes2);
        descripcionCelebracionMes.add(R.string.mes3);
        descripcionCelebracionMes.add(R.string.mes4);
        descripcionCelebracionMes.add(R.string.mes5);
        descripcionCelebracionMes.add(R.string.mes6);
        descripcionCelebracionMes.add(R.string.mes7);
        descripcionCelebracionMes.add(R.string.mes8);
        descripcionCelebracionMes.add(R.string.mes9);
        descripcionCelebracionMes.add(R.string.mes10);
        descripcionCelebracionMes.add(R.string.mes11);
        descripcionCelebracionMes.add(R.string.mes12);
        return(descripcionCelebracionMes);
    }
}