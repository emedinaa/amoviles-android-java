package com.emedinaa.myfirstapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.model.NoteEntity;

import java.util.List;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/24/18
 */
public class NoteRVAdapter extends RecyclerView.Adapter<NoteRVAdapter.ViewHolder> {

    private final List<NoteEntity> lsNoteEntities;
    private final Context context;


    public NoteRVAdapter(Context context, List<NoteEntity> lsNoteEntities) {
        this.lsNoteEntities = lsNoteEntities;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_note, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - replace the contents of the view with that element
        NoteEntity noteEntity = lsNoteEntities.get(position);

        final String noteTitle = noteEntity.getName();
        holder.tviName.setText(noteTitle);
    }

    @Override
    public int getItemCount() {
        return lsNoteEntities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView2;
        public TextView tviName;
        public View view;
        public ViewHolder(View  v) {
            super(v);
            this.view = v;
            imageView2=v.findViewById(R.id.imageView2);
            tviName=  v.findViewById(R.id.tviName);
        }
    }
}
