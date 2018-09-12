package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.emedinaa.myfirstapp.model.StarWarsEvent;
import com.emedinaa.myfirstapp.ui.fragments.EventDetailsFragment;
import com.emedinaa.myfirstapp.ui.fragments.EventFragment;
import com.emedinaa.myfirstapp.ui.fragments.MyFragmentListener;

/**
 * Este ejemplo esta diseñado solo con Fragments y  que funcione para tablets.
 */
public class StarWarsEventsTabletActivity extends AppCompatActivity implements MyFragmentListener {

    private FragmentManager fragmentManager;
    private EventFragment eventFragment;
    private EventDetailsFragment eventDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars_events_fragment_tablet);
        app();
    }

    private void app() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentManager= getSupportFragmentManager();
        eventFragment= (EventFragment) fragmentManager.findFragmentById(R.id.fragmentEvents);
        eventDetailsFragment= (EventDetailsFragment) fragmentManager.findFragmentById(R.id.fragmentDetails);
    }

    @Override
    public void fragmentAction(Object object) {}

    @Override
    public void goToEventDetail(Object object) {
        StarWarsEvent starWarsEvent= (StarWarsEvent)(object);
        if(eventDetailsFragment!=null){
            sendDataToEventDetail(starWarsEvent);
        }else{
            goToActivityEventDetail(starWarsEvent);
        }
    }

    private void goToActivityEventDetail(StarWarsEvent starWarsEvent){
        Intent intent= new Intent(this,EventDetailFragmentActivity.class);
        intent.putExtra("EVENT",starWarsEvent);
        startActivity(intent);
    }

    private void sendDataToEventDetail(StarWarsEvent starWarsEvent){
        Log.v("CONSOLE", "2 StarWarsEventsTabletActivity starWarsEvent "+starWarsEvent);
        eventDetailsFragment.showEventInfo(starWarsEvent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
