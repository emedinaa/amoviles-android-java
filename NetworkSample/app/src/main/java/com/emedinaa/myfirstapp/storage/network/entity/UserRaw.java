package com.emedinaa.myfirstapp.storage.network.entity;

/**
 * Created by emedinaa on 14/10/17.
 */

/*
{
	"username":"edu@edu.com",
	"password":"123456",
	"firstname": "Eduardo",
	"lastname": "Medina"
}
 */
public class UserRaw {

    private String username;
    private String password;
    private String firstname;
    private String lastname;

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
