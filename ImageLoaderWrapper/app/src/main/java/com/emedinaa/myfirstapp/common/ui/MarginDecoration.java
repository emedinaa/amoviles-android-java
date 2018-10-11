package com.emedinaa.myfirstapp.common.ui;

/**
 * Created by emedinaa on 14/10/15.
 */

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MarginDecoration extends RecyclerView.ItemDecoration {
    private int margin;

    public MarginDecoration(int margin) {
        this.margin = margin;
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(margin, margin, margin, margin);
    }
}
