package com.emedinaa.myfirstapp.presenter;

import android.util.Log;

import com.emedinaa.myfirstapp.storage.network.ApiClient;
import com.emedinaa.myfirstapp.storage.network.GsonHelper;
import com.emedinaa.myfirstapp.storage.network.StorageConstant;
import com.emedinaa.myfirstapp.storage.network.entity.LogInBLRaw;
import com.emedinaa.myfirstapp.storage.network.entity.LogInBLResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emedinaa on 27/10/17.
 */

public class LogInPresenter {

    private LogInView view;

    public void logIn(){
        if(view.validateForm()){
            authentication();
        }
    }
    public void goToUserRegister(){
        this.view.gotoUserRegister();
    }

    private void authentication() {
        view.showLoading();

        final LogInBLRaw logInRaw= new LogInBLRaw();
        logInRaw.setLogin(view.getUsername());
        logInRaw.setPassword(view.getPassword());

        Call<LogInBLResponse> call= ApiClient.getMyApiClient().logInBL(
                StorageConstant.APPLICATIONID,
                StorageConstant.RESTAPIKEY,logInRaw);

        call.enqueue(new Callback<LogInBLResponse>() {
            @Override
            public void onResponse(Call<LogInBLResponse> call, Response<LogInBLResponse> response) {
                view.hideLoading();
                if(response!=null){
                    LogInBLResponse logInResponse=null;

                    if(response.isSuccessful()){
                        logInResponse=response.body();
                        if(logInResponse!=null){
                            view.saveSession(logInResponse);
                            view.gotoMain();
                        }
                    }else{
                        //Log.v("CONSOLE", "error "+logInResponse);
                        Log.v("CONSOLE", "error "+response.errorBody());

                        JSONObject jsonObject = null;
                        try {
                            jsonObject=new JSONObject(response.errorBody().string());
                        }catch (Exception e){
                            jsonObject= new JSONObject();
                        }
                        logInResponse= GsonHelper.jsonToLogInBLResponse(jsonObject.toString());
                        view.showMessage(logInResponse.getMessage());

                    }
                }else{
                    view.showMessage("Ocurrió un error");
                }
            }

            @Override
            public void onFailure(Call<LogInBLResponse> call, Throwable t) {
                view.hideLoading();
                view.showMessage(t.getMessage());
            }
        });
    }

    public void attachView(LogInView view){
        this.view=view;
    }
    public void detachView(){
        this.view=null;
    }
}
