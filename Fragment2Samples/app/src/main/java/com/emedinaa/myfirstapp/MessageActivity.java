package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.emedinaa.myfirstapp.fragments.AddMessageFragment;
import com.emedinaa.myfirstapp.fragments.MessagesFragment;
import com.emedinaa.myfirstapp.listeners.OnMessageListener;


public class MessageActivity extends AppCompatActivity implements OnMessageListener {

    private AddMessageFragment addMessageFragment;
    private MessagesFragment messagesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ui();
    }

    private void ui() {
        addMessageFragment= (AddMessageFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentAddMessage);
        messagesFragment= (MessagesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMessages);
    }

    @Override
    public void recibiryEnviardesdeFragment(String message) {
        messagesFragment.mostrarMensaje(message);
    }
}
