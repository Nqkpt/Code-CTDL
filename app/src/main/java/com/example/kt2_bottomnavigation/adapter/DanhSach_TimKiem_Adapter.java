package com.example.kt2_bottomnavigation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kt2_bottomnavigation.R;
import com.example.kt2_bottomnavigation.model.ItemDanhSach;

import java.util.ArrayList;
import java.util.List;

public class DanhSach_TimKiem_Adapter extends RecyclerView.Adapter<DanhSach_TimKiem_Adapter.HomeViewHolder> {
    private List<ItemDanhSach> list;
    private ItemListener itemListener;

    public DanhSach_TimKiem_Adapter() {
        list = new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<ItemDanhSach> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public ItemDanhSach getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhsach, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        ItemDanhSach itemDanhSach = list.get(position);
        holder.lichTrinh.setText(itemDanhSach.getLichTrinh());
        holder.thoiGian.setText(itemDanhSach.getThoiGian());
        holder.ngayKhoiHanh.setText(itemDanhSach.getNgayKhoiHanh());
        holder.tongTien.setText(String.valueOf(itemDanhSach.getTongTien()));
        // Set other fields here as needed
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView lichTrinh, thoiGian, ngayKhoiHanh, tongTien;

        public HomeViewHolder(@NonNull View view) {
            super(view);
            lichTrinh = view.findViewById(R.id.tvLichTrinh);
            thoiGian = view.findViewById(R.id.tvThoiGian);
            ngayKhoiHanh = view.findViewById(R.id.tvNgayKhoiHanh);
            tongTien = view.findViewById(R.id.tvTongTien);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemListener != null) {
                itemListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface ItemListener {
        void onItemClick(View view, int position);
    }
}
