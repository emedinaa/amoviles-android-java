package com.emedinaa.myfirstapp.storage.network.entity;

/**
 * Created by emedinaa on 20/10/17.
 */

public class OtherResponse {
    private boolean code;
    private String message;

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
