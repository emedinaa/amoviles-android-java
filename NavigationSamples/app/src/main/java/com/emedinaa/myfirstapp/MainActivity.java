package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Para asignar esta actividad como la primera en ejecutarse
   debes realizarlo en el archivo AndroidManifest.xml adicionando la etiqueta
   <intent-filter/>

   Por ejemplo
   <activity android:name=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
   </activity>

   Solo puedes tener una actividad como 'LAUNCHER'
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View cardvSwipeTabs;
    private View cardvNavDrawer;
    private View cardvVpager;
    private View cardBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardvSwipeTabs= findViewById(R.id.cardvSwipeTabs);
        cardvNavDrawer= findViewById(R.id.cardvNavDrawer);
        cardvVpager= findViewById(R.id.cardvVpager);
        cardBottomNav= findViewById(R.id.cardBottomNav);

        cardvSwipeTabs.setOnClickListener(this);
        cardvNavDrawer.setOnClickListener(this);
        cardvVpager.setOnClickListener(this);
        cardBottomNav.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cardvSwipeTabs:
                gotoSwipeTabs();
                break;
            case R.id.cardvNavDrawer:
                gotoNavDrawer();
                break;
            case R.id.cardvVpager:
                gotoVPagerScreenSlides();
                break;
            case R.id.cardBottomNav:
                goToCardBottomNav();
                break;
        }
    }

    private void gotoSwipeTabs() {
        startActivity(new Intent(this,SwipeTabsActivity.class));
    }

    private void gotoNavDrawer() {
        startActivity(new Intent(this,NavigationDrawerActivity.class));
    }

    private void gotoVPagerScreenSlides() {
        startActivity(new Intent(this,VPagerScreenSlidesActivity.class));
    }

    private void goToCardBottomNav() {
        startActivity(new Intent(this,BottomNavigationActivity.class));
    }
}
