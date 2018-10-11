package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.emedinaa.myfirstapp.common.media.ImageLoaderHelper;

public class MainActivity extends AppCompatActivity {

    private ImageLoaderHelper imageLoaderHelper;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= findViewById(R.id.imageView);
        imageLoaderHelper=new ImageLoaderHelper(ImageLoaderHelper.GLIDE);
        //imageLoaderHelper.getLoader().loadCircle(url,iviMember);

        //picasso
        String url ="https://i1.wp.com/noticieros.televisa.com/wp-content/uploads/2017/03/einstein-lengua-getty.jpg?resize=719%2C602&quality=95&ssl=1";
        String url2 ="https://hipertextual.com/files/2017/03/Sir-Godfrey-Kneller-Sir-Isaac-Newton-1689-670x410.jpg";

        /*Picasso.with(imageView.getContext())
                .load(url)
                .transform(new CircleTransform())
                .into(imageView);*/

        //glide
        /*Glide.with(imageView.getContext())
                .load(url2)
                .bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                .into(imageView);*/

        //ImageLoader
        //imageLoaderHelper.getLoader().load(url,imageView);
        imageLoaderHelper.getLoader().loadCircle(url,imageView);
    }

}
