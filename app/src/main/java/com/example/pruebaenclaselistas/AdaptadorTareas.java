package com.example.pruebaenclaselistas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorTareas extends RecyclerView.Adapter<AdaptadorTareas.HolderTarea> {

    Context contexto;
    List<Tarea> dataSet;

    public AdaptadorTareas(List<Tarea> listaTareas) {
        this.dataSet = listaTareas;
    }

    @NonNull
    @Override
    public AdaptadorTareas.HolderTarea onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.contexto= parent.getContext();
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_tarea,parent,false);
        return new HolderTarea(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorTareas.HolderTarea holder, int position) {
        Tarea tarea = dataSet.get(position);
        holder.imgImagen.setImageResource(tarea.getImagen());
        holder.txtNombre.setText(tarea.getNombre());
        holder.txtFecha.setText(tarea.getFecha());
        holder.txtHora.setText(tarea.getHora());

        holder.card.setOnClickListener(v -> {
            Intent i = new Intent(contexto, MainActivityEditarTarea.class);
            int posicion = holder.getAdapterPosition();
            i.putExtra("posicion",posicion);
            contexto.startActivity(i);

        });


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class HolderTarea extends RecyclerView.ViewHolder{
        ImageView imgImagen;
        TextView txtNombre;
        TextView txtFecha;
        TextView txtHora;
        CardView card;
        public HolderTarea(@NonNull View itemView) {
            super(itemView);
            imgImagen = itemView.findViewById(R.id.imgImagen);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtFecha = itemView.findViewById(R.id.txtFecha);
            txtHora = itemView.findViewById(R.id.txtHora);
            card = itemView.findViewById(R.id.cardView);
        }
    }
}
