package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.presenter.LogInPresenter;
import com.emedinaa.myfirstapp.presenter.LogInView;
import com.emedinaa.myfirstapp.storage.network.entity.LogInBLResponse;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 3/13/18
 */


public class LogInMVP2Activity extends
        AppCompatActivity implements LogInView {

    private Button btnLogin,btnRegister;
    private EditText eteUsername;
    private EditText etePassword;
    private String username;
    private String password;

    private View flayLoading;

    private LogInPresenter logInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpPresenter();
        init();
    }

    private void setUpPresenter() {
        logInPresenter= new LogInPresenter();
        logInPresenter.attachView(this);
    }

    private void init() {
        //ui
        eteUsername=(EditText)findViewById(R.id.eteUsername);
        etePassword=(EditText)findViewById(R.id.etePassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegister=(Button)findViewById(R.id.btnRegister);
        flayLoading=findViewById(R.id.flayLoading);

        //events
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logInPresenter.logIn();
                logInPresenter.logIn();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gotoUserRegister();
                //logInPresenter.goToUserRegister();
            }
        });

        etePassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    /*if(validateForm()){
                        logInPresenter.logIn();
                    }*/
                    logInPresenter.logIn();
                }
                return false;
            }
        });
    }


    @Override
    public void showLoading() {
        flayLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        flayLoading.setVisibility(View.GONE);
    }

    @Override
    public void gotoMain() {
        Intent intent= new Intent(this,NoteListMVPActivity.class);
        startActivity(intent);
    }

    @Override
    public void gotoUserRegister() {
        //Intent intent= new Intent(this,RegisterActivity.class);
        //startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,
                "LogIn "+message,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean validateForm() {
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

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void saveSession(LogInBLResponse logInResponse) {

    }
}
