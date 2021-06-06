package com.example.molowsapp.pilots;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molowsapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterPilots extends RecyclerView.Adapter<AdapterPilots.ItemViewHolder>
        implements View.OnClickListener{

    private ArrayList<pilots> pilots;
    private View.OnClickListener listener;

    public AdapterPilots(ArrayList<com.example.molowsapp.pilots.pilots> pilots) {
        this.pilots = pilots;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pilots, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPilots.ItemViewHolder holder, int position) {
        holder.bindItem(pilots.get(position));
    }

    @Override
    public int getItemCount() {
        return pilots.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView nickName;
        private CircleImageView city;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            nickName = itemView.findViewById(R.id.tvNickName);
            city = itemView.findViewById(R.id.IvCity);
        }

        public void bindItem(pilots pilots){
            name.setText(pilots.getName());
            nickName.setText(pilots.getNickName());
            city.setImageResource(pilots.getIdImagenPais());
        }
    }
}
