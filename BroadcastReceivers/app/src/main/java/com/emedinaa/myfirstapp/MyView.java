package com.emedinaa.myfirstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {

    private final int BOX_WIDTH=800;//width
    private final int BOX_HEIGHT=800;
    private int xo=0,yo= 0;
    private int stroke=1;
    private int delay=0;

    Paint paint = new Paint();
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(stroke);

        canvas.drawRect(xo, yo, BOX_WIDTH, BOX_HEIGHT, paint);
        paint.setStrokeWidth(0);
        paint.setColor(Color.CYAN);
        canvas.drawRect(xo+stroke, yo+stroke, BOX_WIDTH-stroke, BOX_HEIGHT-stroke, paint );
        paint.setColor(Color.YELLOW);
        canvas.drawRect(xo+stroke, yo+stroke+delay, BOX_WIDTH-stroke, BOX_HEIGHT-stroke, paint );
    }

    public void updateView(int level){
       double percent= level/100.0;
       delay= (BOX_HEIGHT)-(int)Math.round(BOX_HEIGHT*percent);
        Log.v("CONSOLE","level "+level+" percent "+percent+" delay "+delay);
       invalidate();
    }
}
