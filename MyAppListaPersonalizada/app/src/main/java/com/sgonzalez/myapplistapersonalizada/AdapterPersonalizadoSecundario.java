package com.sgonzalez.myapplistapersonalizada;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AdapterPersonalizadoSecundario extends BaseAdapter {
    private Context context;
    private int referenciaLista;
    private ArrayList<Integer> imgDetalleDato = new ArrayList<>();
    private ArrayList<String> nomDetalleDato = new ArrayList<>();
    private ArrayList<String> apeDetalleDato = new ArrayList<>();
    private ArrayList<Integer> edadDetalleDato = new ArrayList<>();

    public AdapterPersonalizadoSecundario(Context context,int referenciaLista,
                                          ArrayList<Integer> imgDetalleDato,
                                          ArrayList<String> nomDetalleDato,
                                          ArrayList<String> apeDetalleDato,
                                          ArrayList<Integer> edadDetalleDato ){
        this.context = context;
        this.referenciaLista=referenciaLista;
        this.imgDetalleDato=imgDetalleDato;
        this.nomDetalleDato=nomDetalleDato;
        this.apeDetalleDato=apeDetalleDato;
        this.edadDetalleDato=edadDetalleDato;
    }

    @Override
    public int getCount() {
        return this.nomDetalleDato.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.lista_personalizada_secundaria,null);
        int imgDetalleDato = this.imgDetalleDato.get(i);
        String nomDetalleDato = this.nomDetalleDato.get(i);
        String apeDetalleDato = this.apeDetalleDato.get(i);
        int edadDetalleDato = this.edadDetalleDato.get(i);

        ImageView imageView= v.findViewById(R.id.imgUserDetalle);
        TextView textViewNom = v.findViewById(R.id.txtNombreDetalle);
        TextView textViewApe = v.findViewById(R.id.txtApellidoDetalle);
        TextView textViewEdad = v.findViewById(R.id.txtEdadDetalle);
        Button button = v.findViewById(R.id.btnEstadoDetalle);

        imageView.setImageResource(imgDetalleDato);
        textViewNom.setText(String.valueOf(nomDetalleDato));
        textViewApe.setText(String.valueOf(apeDetalleDato));
        textViewEdad.setText(String.valueOf(edadDetalleDato));

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
            //    Toast.makeText(context,"El estado de "+nomDetalleDato+" es "+
            //            estado(edadDetalleDato),
            //            Toast.LENGTH_SHORT).show();
                trasladoAdapter(imgDetalleDato,
                                nomDetalleDato,
                                apeDetalleDato,
                                edadDetalleDato,
                                estado(edadDetalleDato)
                        );
            }
        });
        return v;
    }
    private String estado(int edad){
        String estado;
        if (edad>26){
            estado = "Activo";
        }
        else {
            estado = "Inactivo";
        }
        return estado;
    }
    private void trasladoAdapter(int img,
                                 String nombre,
                                 String apellido,
                                 int edad,
                                 String estado){
        Intent intent = new Intent(context,MADatosAdicionales.class);
        //intent tiene metodo que hace un traslado de informacion
        intent.putExtra("img",img);
        intent.putExtra("nombre",nombre);
        intent.putExtra("apellido",apellido);
        intent.putExtra("edad",edad);
        intent.putExtra("estado",estado);
        context.startActivity(intent);

    }
}
