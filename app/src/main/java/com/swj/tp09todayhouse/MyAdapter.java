package com.swj.tp09todayhouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {

    Context context;
    ArrayList<Item> itemArrayList;

    public MyAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Item item = itemArrayList.get(position);
        holder.ivRoomImage.setImageResource(item.roomImageId);
        holder.tvRoomTitle.setText(item.roomTitle);
        holder.tvRoomSeller.setText(item.roomSeller);

        if(position < 3)
            holder.cardviewNew.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView ivRoomImage;
        CardView cardviewNew;
        TextView tvRoomTitle;
        TextView tvRoomSeller;

        public VH(@NonNull View itemView) {
            super(itemView);
            ivRoomImage = itemView.findViewById(R.id.iv_room_image);
            cardviewNew = itemView.findViewById(R.id.cardview_new);
            tvRoomTitle = itemView.findViewById(R.id.tv_room_title);
            tvRoomSeller = itemView.findViewById(R.id.tv_room_seller);
        }
    } // VH class
} // MyAdapter class
