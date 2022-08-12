package com.sgonzalez.myappgridcolores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGrid extends BaseAdapter {
    private Context context;
    int referenceaGrid;
    ArrayList<Integer> imagenes = new ArrayList<>();

    public AdapterGrid(Context context, int referenceaGrid,
                       ArrayList<Integer>imagenes){
        this.context=context;
        this.referenceaGrid=referenceaGrid;
        this.imagenes=imagenes;
    }

    @Override
    public int getCount() {
        return this.imagenes.size();
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
        LayoutInflater layoutInflater= LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.grid_personalizado,null);
        int imagenDato = imagenes.get(i);

        ImageView imageView = v.findViewById(R.id.imgColor);
        imageView.setImageResource(imagenDato);

        return v;
    }
}
