package com.sgonzalez.myapppinturas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizadoAutor extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    ArrayList<String> nombreArtista = new ArrayList<>();


    public AdapterPersonalizadoAutor(Context context, int referenciaLista,
                                     ArrayList<String>nombreArtista){
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.nombreArtista = nombreArtista;

    }

    @Override
    public int getCount() {
        return this.nombreArtista.size();
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
        v = layoutInflater.inflate(R.layout.lista_personalizada,null);

        String nombreDeArtista = this.nombreArtista.get(i);

        TextView textViewNomArtista = v.findViewById(R.id.txtNomArtista);

        textViewNomArtista.setText(String.valueOf(nombreDeArtista));

        return v;
    }
}
