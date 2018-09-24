package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.storage.network.ApiClient;
import com.emedinaa.myfirstapp.storage.network.GsonHelper;
import com.emedinaa.myfirstapp.storage.network.StorageConstant;
import com.emedinaa.myfirstapp.storage.network.entity.LogInBLRaw;
import com.emedinaa.myfirstapp.storage.network.entity.LogInBLResponse;
import com.emedinaa.myfirstapp.storage.preferences.PreferencesHelper;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LogInActivity extends AppCompatActivity {

    private Button btnLogin,btnRegister;
    private EditText eteUsername;
    private EditText etePassword;
    private String username;
    private String password;

    private View flayLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        //ui
        eteUsername=findViewById(R.id.eteUsername);
        etePassword=findViewById(R.id.etePassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);
        flayLoading=findViewById(R.id.flayLoading);

        //events
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    logIn();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUserRegister();
            }
        });

        etePassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    if(validateForm()){
                        logIn();
                    }
                }
                return false;
            }
        });
    }

    private void gotoUserRegister() {
        //Intent intent= new Intent(this,RegisterActivity.class);
        //startActivity(intent);
    }

    private void gotoMain() {

        Intent intent= new Intent(this,NoteListActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Podemos probar con:
     * username : admin@admin.com
     * password: 123456
     */

    /*
        {"code":3003,"message":"Invalid login or password","errorData":{}}
     */
    private void logIn() {
        showLoading();

        final LogInBLRaw logInRaw= new LogInBLRaw();
        logInRaw.setLogin(username);
        logInRaw.setPassword(password);

        Call<LogInBLResponse> call= ApiClient.getMyApiClient().logInBL(
                StorageConstant.APPLICATIONID,
                StorageConstant.RESTAPIKEY,logInRaw);

        call.enqueue(new Callback<LogInBLResponse>() {
            @Override
            public void onResponse(Call<LogInBLResponse> call, Response<LogInBLResponse> response) {
                hideLoading();
                if(response!=null){
                    LogInBLResponse logInResponse=null;

                    if(response.isSuccessful()){
                        logInResponse=response.body();
                        if(logInResponse!=null){
                            saveSession(logInResponse);
                            gotoMain();
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
                        showMessage(logInResponse.getMessage());

                    }
                }else{
                   showMessage("Ocurrió un error");
                }
            }

            @Override
            public void onFailure(Call<LogInBLResponse> call, Throwable t) {
                hideLoading();
                showMessage(t.getMessage());
            }
        });

    }

    private void showLoading(){
        flayLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading(){
        flayLoading.setVisibility(View.GONE);
    }

    private void showMessage(String message){
        Toast.makeText(LogInActivity.this,
                "LogIn "+message,Toast.LENGTH_LONG).show();
    }

    private void saveSession(LogInBLResponse logInResponse) {
        PreferencesHelper.saveBLSession(this,logInResponse.getEmail(),logInResponse.getToken());
    }

    private boolean validateForm() {
        username= eteUsername.getText().toString();
        password= etePassword.getText().toString();

        if(username.isEmpty())
        {
            eteUsername.setError("Error campo username");
            return false;
        }
        if(password.isEmpty())
        {
            etePassword.setError("Error campo password");
            return false;
        }
        return true;
    }

    /*
        POST https://api.backendless.com/7FBB8DC0-4C21-0178-FF76-367F7D30DC00/E5214A86-653A-529C-FF73-95B4DD4F8C00/users/login
        {"login":"admin@admin.com","password":"123456"}
        {"lastLogin":1520368706419,"userStatus":"ENABLED","created":1510343190008,"name":"Admin","ownerId":"B0254EE8-CC3E-EDD8-FF5A-423577F08F00","socialAccount":"BACKENDLESS","updated":1510343508518,"email":"admin@admin.com","objectId":"B0254EE8-CC3E-EDD8-FF5A-423577F08F00","___class":"Users","user-token":"2807A065-BF75-7024-FFBD-2D00CA840300"}
     */

}
