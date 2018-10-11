package com.emedinaa.myfirstapp.common.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by eduardo on 05/11/16.
 */
public class MEditText extends AppCompatEditText {
    public MEditText(Context context) {
        super(context);
        app(context,null);
    }

    public MEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        app(context,attrs);
    }

    public MEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        app(context,attrs);
    }

    private void app(Context context, Object object) {
        loadFont(context);
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
