package com.emedinaa.myfirstapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.model.ItemEntity;

import java.util.List;

/**
 * Created by emedinaa on 30/09/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private final List<ItemEntity> itemEntityList;
    private final Context context;

    public ItemAdapter(final Context context,  List<ItemEntity> itemEntityList) {
        this.context= context;
        this.itemEntityList = itemEntityList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_favorite, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - replace the contents of the view with that element
        final ItemEntity itemEntity= itemEntityList.get(position);

        final int itemPosition= position;
        final String name=itemEntity.getName();

        holder.textViewName.setText(name);
        holder.imageViewFavorite.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);

        if(itemEntity.isSelected()){
            holder.imageViewFavorite.setColorFilter(Color.parseColor("#ff4640"), PorterDuff.Mode.SRC_ATOP);
        }

        holder.imageViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemEntity.setSelected(!itemEntity.isSelected());
                //notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });
        /*holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null){
                    Log.v("ADAPTER", "iviPhoto "+holder.iviPhoto);
                    ViewCompat.setTransitionName(holder.iviPhoto, "iviPhoto");
                    onItemClickListener.onClikListener(position,view,holder.iviPhoto);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return itemEntityList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewName;
        public ImageView imageViewFavorite;
        public View view;
        public ViewHolder(View  v) {
            super(v);
            this.view = v;
            textViewName=  v.findViewById(R.id.textViewName);
            imageViewFavorite=  v.findViewById(R.id.imageViewFavorite);
        }
    }
}
