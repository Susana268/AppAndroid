package com.sgonzalez.myapprecycleclickfragmenttraslado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    // Paso 2
    private static ClickListener clickListener;

    private ArrayList<DatosVo> datosVo = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVo> datosVo){
        this.datosVo=datosVo;
    }

    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.setData(datosVo.get(position).getImagen(),
                datosVo.get(position).getNombre(),
                datosVo.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return this.datosVo.size();
    }

    // Paso 3
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textViewNombre, textViewPrecio;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView= itemView.findViewById(R.id.imgRecycler);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycler);
            textViewPrecio = itemView.findViewById(R.id.txtPrecioRecycler);
            //Paso 6
            itemView.setOnClickListener(this);

        }
        private void setData(Integer img,Integer nombre,Integer precio){
            imageView.setImageResource(img);
            textViewNombre.setText(nombre);
            textViewPrecio.setText(precio);
        }
        //Paaso 4
        @Override
        public void onClick(View view) {
            // Paso 7
            clickListener.itemClick(getAdapterPosition(),view);
        }
    }

    // Paso # 5
    public void setItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;

    }


}
