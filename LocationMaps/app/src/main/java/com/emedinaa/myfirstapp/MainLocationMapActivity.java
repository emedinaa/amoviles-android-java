package com.emedinaa.myfirstapp;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.emedinaa.myfirstapp.base.BaseLocationActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainLocationMapActivity extends BaseLocationActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean firstPosition= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_location_map);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void updateUI() {

        if(mCurrentLocation!=null && previousLocation!=null){
            double distance= mCurrentLocation.distanceTo(previousLocation);
            Log.v("CONSOLE", "distance "+distance);
        }
        if(mCurrentLocation!=null){
            double lat= mCurrentLocation.getLatitude();
            double lng= mCurrentLocation.getLongitude();

            if(firstPosition){
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 16));
                mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker"));
                firstPosition=false;
            }else{
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lng)));
                CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                        new LatLng(lat,lng), 16);
                mMap.animateCamera(location);
                mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker"));
            }
            previousLocation=mCurrentLocation;
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        // We will provide our own zoom controls.
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        firstPosition=true;
        startLocationUpdates();
    }


    private void clear(){
        mMap.clear();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopLocationUpdates();
    }

    /*
           LatLngBounds bounds = new LatLngBounds.Builder()
                .include(PERTH)
                .include(SYDNEY)
                .include(ADELAIDE)
                .include(BRISBANE)
                .include(MELBOURNE)
                .include(DARWIN)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
     */
}
