package com.sgonzalez.myapppinturas;

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

public class AdapterPersonalizadoPintura extends BaseAdapter {
    private Context context;
    private int referenciaLista;
    private ArrayList<Integer>  imgPinturaDato = new ArrayList<>();
    private ArrayList<String> nomPinturaDato = new ArrayList<>();
    private ArrayList<Integer> precioPinturaDato = new ArrayList<>();
    private ArrayList<String> desPinturaDato = new ArrayList<>();

    public AdapterPersonalizadoPintura(Context context,
                                       int referenciaLista,
                                       ArrayList<Integer> imgPinturaDato,
                                       ArrayList<String> nomPinturaDato,
                                       ArrayList<Integer> precioPinturaDato,
                                       ArrayList<String> desPinturaDato){
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.imgPinturaDato = imgPinturaDato;
        this.nomPinturaDato = nomPinturaDato;
        this.precioPinturaDato=precioPinturaDato;
        this.desPinturaDato=desPinturaDato;
    }

    @Override
    public int getCount() {
        return this.nomPinturaDato.size();
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
        v = layoutInflater.inflate(R.layout.lista_personalizada_pinturas,null);

        int imgPinturaDato = this.imgPinturaDato.get(i);
        String nomPinturaDato = this.nomPinturaDato.get(i);
        int precioPinturaDato = this.precioPinturaDato.get(i);
        String desPinturaDato = this.desPinturaDato.get(i);

        ImageView imageViewImg= v.findViewById(R.id.imgListaPintura);
        TextView  textViewNom = v.findViewById(R.id.txtNomPintura);
        TextView textViewPre = v.findViewById(R.id.txtPrecioPintura);
        TextView textViewDes = v.findViewById(R.id.txtDesPintura);
        Button button = v.findViewById(R.id.btnVerPintura);

        imageViewImg.setImageResource(imgPinturaDato);
        textViewNom.setText(String.valueOf(nomPinturaDato));
        textViewPre.setText(String.valueOf(precioPinturaDato));
        textViewDes.setText(String.valueOf(desPinturaDato));

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
            //    Toast.makeText(context,"El estado de "+nomPinturaDato+" es Activo",Toast.LENGTH_SHORT).show();
            trasladoAdapter(imgPinturaDato,nomPinturaDato,precioPinturaDato);
            }
        });

        return v;
    }

    private void trasladoAdapter(int img, String nombre, int precio ){
        Intent intent = new Intent(context, MainCompra.class);
        intent.putExtra("img",img);
        intent.putExtra("nombre",nombre);
        intent.putExtra("precio",precio);
        context.startActivity(intent);

    }
}
