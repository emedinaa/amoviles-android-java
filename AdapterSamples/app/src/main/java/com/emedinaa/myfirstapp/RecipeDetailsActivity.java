package com.emedinaa.myfirstapp;

import android.os.Bundle;

public class RecipeDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        enabledBack();
    }
}
