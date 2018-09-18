package com.emedinaa.myfirstapp.three;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.emedinaa.myfirstapp.R;

public class ColorIIIActivity extends AppCompatActivity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_iii);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
