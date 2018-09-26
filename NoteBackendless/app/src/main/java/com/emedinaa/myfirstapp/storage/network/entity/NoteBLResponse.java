package com.emedinaa.myfirstapp.storage.network.entity;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 3/6/18
 */
/*
    {"created":1520381606285,
    "___class":"Note",
    "description":"Nota de prueba",
    "ownerId":"B0254EE8-CC3E-EDD8-FF5A-423577F08F00",
    "title":"Note 1",
    "updated":null,
    "objectId":"E4B4B15D-9EDE-675A-FFB7-CA51A0094600"}
 */
public class NoteBLResponse {
    private String message;
    private String code;
    private String description;
    private String objectId;
    private String title;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
}
