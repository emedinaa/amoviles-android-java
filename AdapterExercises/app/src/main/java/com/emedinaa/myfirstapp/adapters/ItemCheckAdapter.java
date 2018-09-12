package com.emedinaa.myfirstapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.model.ItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 30/09/17.
 */

public class ItemCheckAdapter extends RecyclerView.Adapter<ItemCheckAdapter.ViewHolder>{

    private final List<ItemEntity> itemEntityList;
    private List<ItemEntity> itemSelectedList;
    private final Context context;

    public ItemCheckAdapter(final Context context, List<ItemEntity> itemEntityList) {
        this.context= context;
        this.itemEntityList = itemEntityList;
        itemSelectedList= new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_check, parent, false);
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

        holder.textViewItem.setText(name);
        /*holder.imageViewCheck.setVisibility(View.GONE);

        if(itemEntity.isSelected()){
            holder.imageViewCheck.setVisibility(View.VISIBLE);
        }*/
        int visibility= View.INVISIBLE;
        if(itemSelectedList.contains(itemEntity)){
            visibility= View.VISIBLE;
        }
        holder.imageViewCheck.setVisibility(visibility);

        /*holder.imageViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemEntity.setSelected(!itemEntity.isSelected());
                //notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });*/
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!itemSelectedList.contains(itemEntity)){
                    itemSelectedList.add(itemEntity);
                }else{
                    itemSelectedList.remove(itemEntity);
                }

                //itemEntity.setSelected(!itemEntity.isSelected());
                notifyItemChanged(position);
                //notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemEntityList.size();
    }

    public List<ItemEntity> getItemSelectedList() {
        return itemSelectedList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewItem;
        public ImageView imageViewCheck;
        public View view;
        public ViewHolder(View  v) {
            super(v);
            this.view = v;
            textViewItem=  v.findViewById(R.id.textViewItem);
            imageViewCheck=  v.findViewById(R.id.imageViewCheck);
        }
    }
}
