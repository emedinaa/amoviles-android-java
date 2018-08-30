package com.emedinaa.myfirstapp.model;

import java.io.Serializable;

/**
 * Created by eduardomedina on 21/02/18.
 */

public class MovieEntity extends TypeEntity implements Serializable {

    private int id;
    private String title;
    private String desc;
    private double price;
    private boolean cartelera;

    public MovieEntity(int id, String title, String desc, double price, boolean cartelera) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.cartelera = cartelera;
    }

    public MovieEntity(String title, boolean cartelera) {
        this.title = title;
        this.cartelera = cartelera;
    }

    public MovieEntity(String title, String desc, boolean cartelera) {
        this.title = title;
        this.desc = desc;
        this.cartelera = cartelera;
    }

    public MovieEntity(int id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCartelera() {
        return cartelera;
    }

    public void setCartelera(boolean cartelera) {
        this.cartelera = cartelera;
    }

    @Override
    public boolean isMovie() {
        return true;
    }
}
