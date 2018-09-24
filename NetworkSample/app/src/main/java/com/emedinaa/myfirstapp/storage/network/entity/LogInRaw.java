package com.emedinaa.myfirstapp.storage.network.entity;

/**
 * Created by em on 8/06/16.
 */

/*
{
	"username":"admin@admin.com",
	"password": "123456"
}
 */
public class LogInRaw {

    private String username;
    private String password;

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
}
