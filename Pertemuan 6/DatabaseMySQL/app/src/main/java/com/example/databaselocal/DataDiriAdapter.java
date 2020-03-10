package com.example.databaselocal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.databaselocal.database.DataDiri;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataDiriAdapter extends RecyclerView.Adapter<DataDiriAdapter.ViewHolder> {
    private DataDiri[] list;
    private Context context;
    private DataDiriListener listener;


    public DataDiriAdapter(DataDiri[] list, DataDiriListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    // Menentukan mau memakai template item yang mana
    public DataDiriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_diri, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    // Proses untuk memasukkan ke list view/tampilan
    public void onBindViewHolder(@NonNull DataDiriAdapter.ViewHolder holder, final int position) {
        final DataDiri item = list[position];

        holder.tvName.setText(item.getNama());
        holder.tvAlamat.setText(item.getAlamat());
        holder.tvGender.setText("" + item.getGender());

        holder.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonDelete(item);
            }
        });
    }

    @Override
//     Untuk Menghitung Data
    public int getItemCount() {
        return list.length;
    }

    // Untuk mengambil id pada tampilan
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvAlamat, tvGender;
        private Button btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAlamat = itemView.findViewById(R.id.item_tv_alamat);
            tvName = itemView.findViewById(R.id.item_tv_name);
            tvGender = itemView.findViewById(R.id.item_tv_gender);
            btnHapus = itemView.findViewById(R.id.btnHapus);

        }
    }
}
