package com.emedinaa.java.interfaces;

import java.io.File;

public interface Picasso {

    void loadImage(String url, Object imageView);
    void loadImage(File file, Object imageView);
}
