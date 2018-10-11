package com.emedinaa.myfirstapp.model;

/**
 * Created by eduardomedina on 1/03/18.
 */

public class UserEntity {
        /*
    {
        "_id": "59e0540d429d3f501d6493de",
        "id": "59e0540d429d3f501d6493de",
        "username": "admin@admin.com",
        "password": "123456",
        "firstname": "Admin",
        "lastname": "Admin",
        "__v": 0
    }
     */

    //@SerializedName("_id")
    //private String id2;

    private String id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
