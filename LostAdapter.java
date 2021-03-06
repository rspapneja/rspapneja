package com.example.fanaticaltechnology.offline;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LostAdapter
extends RecyclerView.Adapter<LostAdapter.DataObjectHolder>{

    private ArrayList<Lost> mDataset;
    private Context context;

    public LostAdapter(ArrayList<Lost> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lost_item_row, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        context = parent.getContext();
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.title.setText(mDataset.get(position).getTitle());
        holder.body.setText(String.valueOf(mDataset.get(position).getId()));
        Glide.with(context)
                .load(mDataset.get(position).getImage())

                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {

        TextView title, body;
        ImageView image;

        public DataObjectHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            body = (TextView) itemView.findViewById(R.id.id);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}




































