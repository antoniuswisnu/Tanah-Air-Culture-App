package com.example.tanahair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private ArrayList<Cultures> listCultures;
    private Context context;

    public ListAdapter(ArrayList<Cultures> list) {
        this.listCultures = list;
    }


    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cultures, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        final Cultures culture = listCultures.get(position);
        Glide.with(holder.itemView.getContext())
                .load(culture.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.photo);
        holder.nama.setText(culture.getNama());
        holder.deskripsi.setText(culture.getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailCulture.class);
                Bundle bundle = new Bundle();

                bundle.putString("name", culture.getNama());
                bundle.putString("description", culture.getDeskripsi());
                bundle.putInt("picture", culture.getPhoto());
                intent.putExtras(bundle);
                context.startActivity(intent);

                Toast.makeText(holder.itemView.getContext(), "" + listCultures.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCultures.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView nama, deskripsi;
        ImageView photo;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            nama = itemView.findViewById(R.id.nama);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            photo = itemView.findViewById(R.id.photo);

        }
    }
}
