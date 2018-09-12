package com.emedinaa.myfirstapp.model;

import java.io.Serializable;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/6/18
 */
public class ItemEntity implements Serializable {
    private int id;
    private String name;
    private boolean selected;

    public ItemEntity(String name, boolean selected) {
        this.name = name;
        this.selected = selected;
    }

    public ItemEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
