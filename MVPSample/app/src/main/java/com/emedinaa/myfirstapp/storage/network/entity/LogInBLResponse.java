package com.emedinaa.myfirstapp.storage.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emedinaa on 10/11/17.
 */
/*
{
    "ownerId": "7AD2B842-910E-ECE7-FF1B-B9DFFF6E0800",
    "email": "admin@gmail.com",
    "objectId": "7AD2B842-910E-ECE7-FF1B-B9DFFF6E0800",
    "lastname": "Admin",
    "updated": 1510359887344,
    "name": "Admin",
    "created": 1510359816663,
    "userStatus": "ENABLED",
    "lastLogin": 1510360415974,
    "___class": "Users",
    "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"ownerId\",\"email\",\"objectId\",\"lastname\",\"updated\",\"name\",\"password\",\"created\",\"userStatus\",\"lastLogin\",\"__updated__meta\",\"___class\"],\"relatedObjects\":{}}",
    "user-token": "73034DA7-61AE-331B-FF73-2BA295394400"
}
 */
public class LogInBLResponse {
    private String objectId;
    private String email;
    private String name;
    private String message;
    private String code;

    @SerializedName("user-token")
    private String token;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
}
