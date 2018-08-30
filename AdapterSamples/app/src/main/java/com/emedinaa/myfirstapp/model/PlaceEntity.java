package com.emedinaa.myfirstapp.model;

/**
 * @author Eduardo Medina
 */
public class PlaceEntity  extends TypeEntity{

    private int id;
    private String title;

    public PlaceEntity(int id, String title) {
        this.id = id;
        this.title = title;
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

    @Override
    public boolean isPlace() {
        return true;
    }
}
