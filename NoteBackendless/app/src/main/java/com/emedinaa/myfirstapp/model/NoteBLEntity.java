package com.emedinaa.myfirstapp.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 15/09/15.
 */
/*
{
        "created": 1510361481105,
        "updated": null,
        "ownerId": null,
        "objectId": "C71B2839-0019-27F8-FF2B-9B6ABC662E00",
        "description": "My nota de prueba",
        "title": "Nueva nota",
        "___class": "Note",
        "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"created\",\"updated\",\"ownerId\",\"objectId\",\"description\",\"title\",\"___class\"],\"relatedObjects\":{}}"
    }
 */
public class NoteBLEntity implements Serializable {

    private String objectId;
    private String title;
    private String description;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
