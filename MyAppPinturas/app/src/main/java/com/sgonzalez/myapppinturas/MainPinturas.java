package com.sgonzalez.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainPinturas extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pinturas);
        listView = findViewById(R.id.listPinturas);

        obtenerDatos();
        llenarLista();
    }

    private String obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String artista = bundle.getString("artista");
        return artista;
    }

    private void llenarLista(){
        AdapterPersonalizadoPintura secundario;
        switch (obtenerDatos()){
            case "Rembrandt":
                secundario = new AdapterPersonalizadoPintura(this,R.layout.lista_personalizada_pinturas,
                                                            rembrantImg(),
                                                            rembrantNombre(),
                                                            rembrantPrecio(),
                                                            rembrantDesc()) ;
                listView.setAdapter(secundario);
                break;
            case "Leonardo Da Vinci":
                secundario = new AdapterPersonalizadoPintura(this,R.layout.lista_personalizada_pinturas,
                                                            leonardoImg(),
                                                            leonardoNombre(),
                                                            leonardoPrecio(),
                                                            leonardoDesc());
                listView.setAdapter(secundario);
                break;
            default:
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private ArrayList<Integer> rembrantImg(){
        ArrayList<Integer> images  = new ArrayList<>();
        images.add(R.drawable.ic_ronda_noche);
        images.add(R.drawable.ic_angel);
        return images;
    }
    private ArrayList<String> rembrantNombre(){
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ronda de Noche");
        nombres.add("Jacob Wrestling with the Angel");
        return nombres;
    }
    private ArrayList<Integer> rembrantPrecio(){
        ArrayList<Integer> precios = new ArrayList<>();
        precios.add(1500000);
        precios.add(2000000);
        return precios;
    }
    private ArrayList<String> rembrantDesc(){
        ArrayList<String> descs = new ArrayList<>();
        descs.add("La pintura que ahora conocemos como La ronda de noche originalmente se llamaba La compañía militar del capitán Frans Banninck Cocq y el teniente Willem van Ruytenburgh. Fue un encargo hecho en 1639 por el capitán Banninck Cocq y 17 miembros de sus guardias de la milicia cívica. El cuadro estaba destinado a ser exhibido en el salón de banquetes del Salón de Reuniones de Mosqueteros en Ámsterdam.");
        descs.add("Menos una lucha que un abrazo. La acción, que en la década de 1630 habría sido un furioso torbellino de energía muscular, es tranquila y dormida, pesada con el tipo de desaceleración misteriosa experimentada en los sueños. Aunque la Biblia sólo dice que Jacob luchó hasta el amanecer, Rembrandt le ha dado la cualidad de un encuentro sonámbulo, intensamente sentido pero físicamente inmaterial. El ángel, a quien Rembrandt le ha dado el rostro más hermoso de toda su pintura (tal vez una versión idealizada de Tito), enmarcado por una corona de rizos gruesos y elásticos, uno de los cuales sacacorchos por su cuello, mira tiernamente desde debajo de los párpados brillantes a los ojos cerrados de Jacob");
        return descs;
    }

    private ArrayList<Integer>  leonardoImg(){
        ArrayList<Integer> images  = new ArrayList<>();
        images.add(R.drawable.ic_mona_lisa);
        images.add(R.drawable.ic_anatomia);
        return images;
    }
    private ArrayList<String> leonardoNombre(){
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("La Mona Lisa");
        nombres.add("El Hombre de Vitruvio");
        return nombres;
    }
    private ArrayList<Integer> leonardoPrecio(){
        ArrayList<Integer> precios = new ArrayList<>();
        precios.add(1500000);
        precios.add(2000000);
        return precios;
    }
    private ArrayList<String> leonardoDesc(){
        ArrayList<String> descs = new ArrayList<>();
        descs.add("La historia de la pintura también conocida como “La Gioconda”, inició alrededor de 1503 en Florencia. Aunque es un misterio quién es la mujer que fue pintada por Leonardo da Vinci, muchos especialistas afirman que fue Lisa Gherardini, esposa de un comerciante de telas de nombre Francesco del Giocondo, de ahí el nombre alternativo de la pintura");
        descs.add("Se llama Hombre de Vitruvio a un dibujo elaborado por el pintor renacentista Leonardo da Vinci, basado en el trabajo del arquitecto romano Marco Vitruvio Polión.");
        return descs;
    }



}