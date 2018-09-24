package com.emedinaa.myfirstapp.storage.network.entity;

/**
 * Created by em on 8/06/16.
 */

/*
{
  "login":"admin@gmail.com",
  "password":"123456"
}
 */
public class LogInBLRaw {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
