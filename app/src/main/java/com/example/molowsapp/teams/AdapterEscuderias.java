package com.example.molowsapp.teams;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molowsapp.R;

import java.util.ArrayList;

public class AdapterEscuderias extends RecyclerView.Adapter<AdapterEscuderias.ItemViewHolder>
        implements View.OnClickListener {

    private ArrayList<Item_Escuderias> datos;
    private View.OnClickListener listener;

    public AdapterEscuderias(ArrayList<Item_Escuderias> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.escuderias_adapter_activity, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
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
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView posicion;
        private TextView escuderia;
        private TextView pilotos;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            posicion = itemView.findViewById(R.id.tvPosicion);
            escuderia = itemView.findViewById(R.id.tvEscuderia);
            pilotos = itemView.findViewById(R.id.tvPilotos);
        }

        public void bindItem(Item_Escuderias item) {
            posicion.setText(item.getPosicion());
            escuderia.setText(item.getEscuderia());
            pilotos.setText(item.getPilotos());
        }
    }
}
