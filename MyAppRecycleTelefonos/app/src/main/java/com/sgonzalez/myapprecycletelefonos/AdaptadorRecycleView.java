package com.sgonzalez.myapprecycletelefonos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class AdaptadorRecycleView extends RecyclerView.Adapter<AdaptadorRecycleView.ViewHolder> {

    private ArrayList<DatosVo> datosVo = new ArrayList<>();

    public AdaptadorRecycleView(ArrayList<DatosVo> datosVo){
        this.datosVo = datosVo;
    }

    @NonNull
    @Override
    public AdaptadorRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycleView.ViewHolder holder, int position) {
        holder.asigarDatos(datosVo.get(position).getNombreTelefono(),
                           datosVo.get(position).getNumeroTelefono(),
                           datosVo.get(position).getImageTelefono());
    }

    @Override
    public int getItemCount() {
        return this.datosVo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewNombre, textViewNumero;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycler);
            textViewNumero = itemView.findViewById(R.id.txtNumeroRecycler);
            imageView = itemView.findViewById(R.id.imgRecycle);
        }
        private void asigarDatos(String nombre,String numero,Integer imagen){
            textViewNombre.setText(String.valueOf(nombre));
            textViewNumero.setText(String.valueOf(numero));
            imageView.setImageResource(imagen);
        }
    }
}
