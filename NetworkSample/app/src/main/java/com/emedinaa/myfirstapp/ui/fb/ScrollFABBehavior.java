package com.emedinaa.myfirstapp.ui.fb;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/24/18
 */
public class ScrollFABBehavior extends FloatingActionButton.Behavior  {

    public ScrollFABBehavior(Context context, AttributeSet attrs) {
        super();
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        boolean ret;
        if(nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL)
        {
            ret = true;
        }else
        {
            ret = super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
        }

        return ret;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        /* If RecyclerView scroll action consumed vertical pixels bigger than 0, means scroll down. */
        if (dyConsumed > 0) {
            if(child.getVisibility() == View.VISIBLE) {
                child.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                    @Override
                    public void onHidden(FloatingActionButton floatingActionButton) {
                        super.onHidden(floatingActionButton);
                        floatingActionButton.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }
        // Means recyclerview scroll up.
        else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            child.show();
        }
    }
}
