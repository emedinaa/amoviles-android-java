package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.emedinaa.myfirstapp.asynctask.AsyncListener;
import com.emedinaa.myfirstapp.asynctask.SimpleAsyncTask;

public class ProcessAsynctaskActivity extends AppCompatActivity implements AsyncListener {

    private TextView textView;
    private SimpleAsyncTask simpleAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_asynctask);
        textView= findViewById(R.id.textView);

        startTask();
    }

    private void startTask(){
        simpleAsyncTask= new SimpleAsyncTask(this);
        simpleAsyncTask.execute();

    }

    @Override
    public void updateView(String message) {
        textView.setText(message);
    }

}
