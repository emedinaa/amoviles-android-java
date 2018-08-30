package com.emedinaa.myfirstapp.model;

import java.io.Serializable;

/**
 * Created by eduardomedina on 20/02/18.
 */

public class Entity implements Serializable{

    private int id;
    private String title;
    private String subTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
