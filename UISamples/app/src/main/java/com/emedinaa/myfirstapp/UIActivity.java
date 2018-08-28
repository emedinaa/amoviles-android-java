package com.emedinaa.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ui);

        //LinearLayout
        setContentView(R.layout.activity_linear_vertical);
        //setContentView(R.layout.activity_linear_horizontal);

        //RelativeLayout
        //setContentView(R.layout.activity_relative);
        //setContentView(R.layout.layout_relative_transparent);
        //setContentView(R.layout.layout_relative_example);

        //ConstraintLayout
        //setContentView(R.layout.activity_constraint_layout);

        //Weight
        //setContentView(R.layout.layout_weight_vertical);
        //setContentView(R.layout.layout_weight);

        //Samples
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.layout_login_pinterest);
        //setContentView(R.layout.layout_example1);
        //setContentView(R.layout.layout_example2);
        //setContentView(R.layout.layout_example3);
        //setContentView(R.layout.layout_example4);

    }
}
