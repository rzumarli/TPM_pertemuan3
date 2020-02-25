package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class AdapterPahlawan extends RecyclerView.Adapter<AdapterPahlawan.PahlawanViewHolder> {

    private Context context;
    private ArrayList<ModelPahlawan> listPahlawan;
    private OnItemClickCallback onItemClickCallback;

    public AdapterPahlawan(Context context) {
        this.context = context;
    }

    public ArrayList<ModelPahlawan> getListPahlawan() {
        return listPahlawan;
    }

    public void setListPahlawan(ArrayList<ModelPahlawan> listPahlawan) {
        this.listPahlawan = listPahlawan;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public PahlawanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new PahlawanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PahlawanViewHolder holder, int position) {
        Glide.with(context).load(getListPahlawan().get(position).getHeroesImages()).into(holder.ivPhoto);
        holder.tvNama.setText(getListPahlawan().get(position).getHeroName());
        holder.tvDeskripsi.setText(getListPahlawan().get(position).getHeroDetails());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listPahlawan.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListPahlawan().size();
    }

    public class PahlawanViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private TextView tvNama, tvDeskripsi;
        public PahlawanViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_photo);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_descption);

        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(ModelPahlawan pahlawan);
    }
}
