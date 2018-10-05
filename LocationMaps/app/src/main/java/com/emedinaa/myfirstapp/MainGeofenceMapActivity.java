package com.emedinaa.myfirstapp;

import android.graphics.Color;
import android.os.Bundle;

import com.emedinaa.myfirstapp.base.BaseLocationActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 *
 100% — FF
 95% — F2
 90% — E6
 85% — D9
 80% — CC
 75% — BF
 70% — B3
 65% — A6
 60% — 99
 55% — 8C
 50% — 80
 45% — 73
 40% — 66
 35% — 59
 30% — 4D
 25% — 40
 20% — 33
 15% — 26
 10% — 1A
 5% — 0D
 0% — 00

 */
public class MainGeofenceMapActivity extends BaseLocationActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng origin= new LatLng(-12.1117,-77.0303);
    private LatLng destiny=new LatLng(-12.1159,-77.0324);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_geofence_map);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        // We will provide our own zoom controls.
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                drawPoints();
            }
        });

        startLocationUpdates();
    }

    private void drawPoints(){
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(origin)
                .include(destiny)
                .build();

        mMap.addMarker(new MarkerOptions().position(new LatLng(origin.latitude,
                origin.longitude)).title("Origen").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        ));

        mMap.addMarker(new MarkerOptions().position(new LatLng(destiny.latitude,
                destiny.longitude)).title("Destino").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        int padding=240;//pixel
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        //mMap.moveCamera(cameraUpdate);
        mMap.animateCamera(cameraUpdate);
        CircleOptions circleOptions= new CircleOptions();
        circleOptions.center(destiny);
        circleOptions.radius(100);//meters
        circleOptions.fillColor(Color.parseColor("#80FF0000"));//red

        mMap.addCircle(circleOptions);
    }
    @Override
    protected void updateUI() {

    }


}
