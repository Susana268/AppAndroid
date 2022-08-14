package com.sgonzalez.myapprecycleviewvo;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycleView extends RecyclerView.Adapter<AdaptadorRecycleView.ViewHolder>{

    private ArrayList<DatosVo> datosVo = new ArrayList<>();

    public AdaptadorRecycleView(ArrayList<DatosVo> datosVo){
        this.datosVo=datosVo;
    }

    @NonNull
    @Override
    public AdaptadorRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycleView.ViewHolder holder, int position) {
        holder.asignarDatos(datosVo.get(position).getNombreRestaurante(),
                            datosVo.get(position).getCalidadRestaurante(),
                            datosVo.get(position).getImagenRestaurante());
    }

    @Override
    public int getItemCount() {
        return this.datosVo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombre, textViewCalidad;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycle);
            textViewCalidad= itemView.findViewById(R.id.txtCalidadRecyce);
            imageView=itemView.findViewById(R.id.imgRecycle);
        }
        private void asignarDatos(String nombre,String calidad, Integer imagen){
            textViewNombre.setText(String.valueOf(nombre));
            textViewCalidad.setText(String.valueOf(calidad));
            imageView.setImageResource(imagen);
        }
    }
}
