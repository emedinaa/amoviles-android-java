package com.emedinaa.myfirstapp.storage.network.entity;

/**
 * Created by eduardomedina on 5/03/18.
 */

public class BaseResponse {

    private final int STATUS_CODE=200;
    private String msg;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess(){
        return (status==STATUS_CODE)?(true):(false);
    }
}
