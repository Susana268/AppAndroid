package com.sgonzalez.myapppinturas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<String> artistas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listArtistas);
  //      ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,artistas());
  //      listView.setAdapter(arrayAdapter);
        AdapterPersonalizadoAutor adapterPersonalizadoAutor= new AdapterPersonalizadoAutor(getApplicationContext(),
                                                                 R.layout.lista_personalizada,
                                                                 artistas());
        listView.setAdapter(adapterPersonalizadoAutor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                traslado(i);
            }
        });


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
                Toast.makeText(this,"Esta etapa incluye El Renacimiento, Barroco y Clasicismo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this,"Esta etapa incluye El Impresionismo, Romanticismo,Cubismo, Expresionismo y Neoclasicismo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this,"Esta etapa incluye Arte Vanguardista, Arte Virtual y Arte Graffiti ",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<String> artistas(){
        this.artistas.add("Rembrandt");
        this.artistas.add("Leonardo Da Vinci");
        this.artistas.add("Claude Monet");
        this.artistas.add("Van Gogh");
        this.artistas.add("Picasso");
        this.artistas.add("Salvador Dali");
        return artistas;
    }

    private void traslado(int position){
        Intent intent = new Intent(getApplicationContext(),MainPinturas.class);
        intent.putExtra("artista",artistas().get(position));
        startActivity(intent);
        finish();
    }


}