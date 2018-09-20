package com.emedinaa.myfirstapp;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private MyDatabaseHelper mySeinfeldDBHelper;
    //this boolean is mainly to test fresh database creation without the foods.db asset
    private boolean useFallback;

    @Override
    public void onCreate(Bundle mySavedState) {
        super.onCreate(mySavedState);
        setContentView(R.layout.activity_main);
        this.output = (TextView) this.findViewById(R.id.out_text);

        this.mySeinfeldDBHelper = new MyDatabaseHelper(this);
        this.useFallback = false;

        try {
            this.mySeinfeldDBHelper.openDatabase();
        }
        catch(SQLException e) {
            this.useFallback = true;
        }

        // if something goes wrong using foods.db asset, revert to creating a simplified version for demo
        if (this.useFallback) {
            //this.mySeinfeldDBHelper.deleteFoods();
            //this.mySeinfeldDBHelper.insert(1,"Bagels");
            //this.mySeinfeldDBHelper.insert(1,"Bagels, raisin");
            //this.mySeinfeldDBHelper.insert(1,"Bavarian Cream Pie");
        }

        List<String> names = this.mySeinfeldDBHelper.selectFoods();
        StringBuilder myString = new StringBuilder();
        for (String name : names) {
            myString.append(name + "\n");
        }
        this.output.setText(myString.toString());
    }
}
