package com.emedinaa.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

public class DelayedLViewActivity extends AppCompatActivity {

    private View buttonLoadView;
    private ViewStub viewStub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_lview);

        buttonLoadView= findViewById(R.id.buttonLoadView);
        viewStub= findViewById(R.id.viewStub);

        buttonLoadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub.inflate();
            }
        });
    }
}
