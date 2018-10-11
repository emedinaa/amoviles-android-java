package com.emedinaa.myfirstapp.common.media;

/**
 * Created by emedinaa on 16/04/16.
 */
public class ImageLoaderHelper {

    public static final int GLIDE=1;
    public static final int PICASSO=2;
    public static final int FRESCO=3;

    private int type=GLIDE;
    private ImageLoader imageLoader;

    public ImageLoaderHelper(int type) {
        this.type = type;
        imageLoader= factory();
    }

    public ImageLoader getLoader() {
        return imageLoader;
    }

    private ImageLoader factory()
    {
        switch (type)
        {
            case PICASSO:
               return new PicassoLoader();
            case GLIDE:
                return new GlideLoader();
            case FRESCO:
                return new FrescoLoader();
            default:
                return new GlideLoader();
        }
    }
}
