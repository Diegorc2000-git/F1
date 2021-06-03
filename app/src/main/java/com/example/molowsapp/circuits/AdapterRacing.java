package com.example.molowsapp.circuits;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.molowsapp.R;

import java.util.ArrayList;

public class AdapterRacing extends RecyclerView.Adapter<AdapterRacing.ItemViewHolder> implements View.OnClickListener {

    private ArrayList<Item_Racing> datos;
    private View.OnClickListener listener;

    public AdapterRacing(ArrayList<Item_Racing> datos) { this.datos = datos; }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.circuitos_item_layout, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return  ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindItem(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView fecha;
        private TextView titulo;
        private TextView pais;
        private TextView descripcion;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.tvFechaR);
            titulo = itemView.findViewById(R.id.tvTituloR);
            pais = itemView.findViewById(R.id.tvPaisR);
            descripcion = itemView.findViewById(R.id.tvDescripcionR);
        }

        public void bindItem(Item_Racing item) {
            fecha.setText(item.getFecha());
            titulo.setText(item.getTitulo());
            pais.setText(item.getPais());
            descripcion.setText(item.getDescripcion());
        }
    }
}
