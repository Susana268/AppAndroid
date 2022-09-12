package com.sgonzalez.myappfragmentcine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {
    // Paso 1
    private static ClickListener clickListener;

    private ArrayList<DatosVo> datosVo = new ArrayList<>();

    public AdaptadorRecyclerView(ArrayList<DatosVo> datosVo) {

        this.datosVo = datosVo;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerView.ViewHolder holder, int position) {
        holder.setData(datosVo.get(position).getImagen(),
                datosVo.get(position).getNombre(),
                datosVo.get(position).getDuracion());

    }

    @Override
    public int getItemCount() {

        return this.datosVo.size();
    }

    //Paso 3
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textViewNombre, textViewDuracion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgRecycle);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycle);
            textViewDuracion = itemView.findViewById(R.id.txtDuraRecycle);
            // Paso 6
            itemView.setOnClickListener(this);

        }

        private void setData(Integer img, Integer nombre, Integer duracion) {
            imageView.setImageResource(img);
            textViewNombre.setText(nombre);
            textViewDuracion.setText(duracion);
        }

        // Paso 4
        @Override
        public void onClick(View view) {
        // Paso 7
            clickListener.itemClick(getAdapterPosition(),view);
        }
    }

    // Paso 5
    public void setItemClickListener(ClickListener clickListener){
        AdaptadorRecyclerView.clickListener = clickListener;
    }
}
