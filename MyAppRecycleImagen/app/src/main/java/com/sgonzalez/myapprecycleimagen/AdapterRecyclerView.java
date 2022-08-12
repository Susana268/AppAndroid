package com.sgonzalez.myapprecycleimagen;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<Integer> fotos = new ArrayList<>();
    public AdapterRecyclerView(ArrayList<String> nombres,
                               ArrayList<Integer> fotos) {
        this.nombres = nombres;
        this.fotos = fotos;
    }

    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterRecyclerView.ViewHolder holder, int position) {
        holder.asignarDatos(nombres.get(position),fotos.get(position));
    }

    @Override
    public int getItemCount() {
        return this.nombres.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtNombre);
            imageView= itemView.findViewById(R.id.txtImagen);

        }
        // Asignar los valores provienentes del arraylis a nuestros elementos view
        public void asignarDatos(String texto1,Integer image1){
            textView.setText(String.valueOf(texto1));
            imageView.setImageResource(image1);
        }
    }
}
