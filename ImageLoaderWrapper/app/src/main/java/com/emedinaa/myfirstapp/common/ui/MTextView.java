package com.emedinaa.myfirstapp.common.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by eduardo on 05/11/16.
 */
public class MTextView extends AppCompatTextView {
    public MTextView(Context context) {
        super(context);
        app(context,null);
    }

    public MTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        app(context,attrs);
    }

    public MTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        app(context,attrs);
    }
    private void app(Context context, Object object) {
        if(!isInEditMode()) loadFont(context);
    }

    protected void loadFont(Context context){
        String pathFont= "fonts/helveticaneuelight.ttf";
        if(getTag()==null){
            pathFont= "fonts/helveticaneuelight.ttf";
        }else if(getTag().equals("1")){
            pathFont= "fonts/helveticaneuelight.ttf";
        }else if(getTag().equals("2")){
            pathFont= "fonts/gotham-rounded-bold.otf";
        }
        Typeface type = Typeface.createFromAsset(context.getAssets(),pathFont);
        setTypeface(type);
    }
}
