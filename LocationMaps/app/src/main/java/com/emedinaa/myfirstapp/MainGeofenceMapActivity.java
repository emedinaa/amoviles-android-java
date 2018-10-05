package com.emedinaa.myfirstapp;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.emedinaa.myfirstapp.base.BaseLocationActivity;
import com.emedinaa.myfirstapp.geofencing.Constants;
import com.emedinaa.myfirstapp.geofencing.GeofenceBroadcastReceiver;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

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
        implements OnMapReadyCallback,OnCompleteListener<Void> {

    private enum PendingGeofenceTask {
        ADD, REMOVE, NONE
    }

    private final String TAG="CONSOLE";

    private GoogleMap mMap;
    private LatLng origin= new LatLng(-12.1117,-77.0303);
    private LatLng destiny=new LatLng(-12.1159,-77.0324);

    private Marker currentLocationMarker;
    private PendingGeofenceTask mPendingGeofenceTask = PendingGeofenceTask.NONE;
    private GeofencingClient mGeofencingClient;
    private ArrayList<Geofence> mGeofenceList;
    private PendingIntent mGeofencePendingIntent;

    private View btnAddGeo;
    private View btnRemoveGeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_geofence_map);
        btnAddGeo= findViewById(R.id.btnAddGeo);
        btnRemoveGeo= findViewById(R.id.btnRemoveGeo);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        setupGeofencing();
        //events
        btnAddGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGeofences();
            }
        });

        btnRemoveGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeGeofences();
            }
        });
    }

    private void setupGeofencing(){
        mGeofenceList = new ArrayList<>();
        mGeofencePendingIntent = null;
        populateGeofenceList();
        mGeofencingClient = LocationServices.getGeofencingClient(this);
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

        currentLocationMarker=mMap.addMarker(new MarkerOptions().position(new LatLng(origin.latitude,
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
        if(currentLocationMarker!=null){
            currentLocationMarker.setPosition(new LatLng(mCurrentLocation.getLatitude(),
                    mCurrentLocation.getLongitude()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeGeofences();
    }

    //Geofence
    private void populateGeofenceList() {

        mGeofenceList.add(new Geofence.Builder()
                // Set the request ID of the geofence. This is a string to identify this
                // geofence.
                .setRequestId("DESTINATION")

                // Set the circular region of this geofence.
                //latitude longitude
                .setCircularRegion(
                        destiny.latitude,
                        destiny.longitude,
                        Constants.GEOFENCE_RADIUS_IN_METERS
                )

                // Set the expiration duration of the geofence. This geofence gets automatically
                // removed after this period of time.
                .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISECONDS)

                // Set the transition types of interest. Alerts are only generated for these
                // transition. We track entry and exit transitions in this sample.
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
                        Geofence.GEOFENCE_TRANSITION_EXIT)

                // Create the geofence.
                .build());

    }
    private PendingIntent getGeofencePendingIntent() {
        // Reuse the PendingIntent if we already have it.
        if (mGeofencePendingIntent != null) {
            return mGeofencePendingIntent;
        }
        Intent intent = new Intent(this, GeofenceBroadcastReceiver.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when calling
        // addGeofences() and removeGeofences().
        mGeofencePendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return mGeofencePendingIntent;
    }


    @Override
    public void onComplete(@NonNull Task<Void> task) {
        mPendingGeofenceTask = PendingGeofenceTask.NONE;
        if (task.isSuccessful()) {

            Toast.makeText(this, "onComplete", Toast.LENGTH_SHORT).show();
        } else {
            // Get the status code for the error and log it using a user-friendly message.
            String errorMessage =getErrorString(this,task.getException());
            Log.v(TAG, "onComplete error "+errorMessage);
        }
    }

    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();

        // The INITIAL_TRIGGER_ENTER flag indicates that geofencing service should trigger a
        // GEOFENCE_TRANSITION_ENTER notification when the geofence is added and if the device
        // is already inside that geofence.
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);

        // Add the geofences to be monitored by geofencing service.
        builder.addGeofences(mGeofenceList);

        // Return a GeofencingRequest.
        return builder.build();
    }

    @SuppressWarnings("MissingPermission")
    private void removeGeofences() {
        mPendingGeofenceTask = PendingGeofenceTask.REMOVE;
        mGeofencingClient.removeGeofences(getGeofencePendingIntent()).addOnCompleteListener(this);
    }

    /**
     * Adds geofences. This method should be called after the user has granted the location
     * permission.
     */
    @SuppressWarnings("MissingPermission")
    private void addGeofences() {
        mPendingGeofenceTask = PendingGeofenceTask.ADD;
        mGeofencingClient.addGeofences(getGeofencingRequest(), getGeofencePendingIntent())
                .addOnCompleteListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        performPendingGeofenceTask();
    }

    private void performPendingGeofenceTask() {
        if (mPendingGeofenceTask == PendingGeofenceTask.ADD) {
            addGeofences();
        } else if (mPendingGeofenceTask == PendingGeofenceTask.REMOVE) {
            removeGeofences();
        }
    }

    //-----------------------
    public static String getErrorString(Context context, Exception e) {
        if (e instanceof ApiException) {
            return getErrorString(context, ((ApiException) e).getStatusCode());
        } else {
            return context.getResources().getString(R.string.unknown_geofence_error);
        }
    }

    /**
     * Returns the error string for a geofencing error code.
     */
    public static String getErrorString(Context context, int errorCode) {
        Resources mResources = context.getResources();
        switch (errorCode) {
            case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE:
                return mResources.getString(R.string.geofence_not_available);
            case GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES:
                return mResources.getString(R.string.geofence_too_many_geofences);
            case GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS:
                return mResources.getString(R.string.geofence_too_many_pending_intents);
            default:
                return mResources.getString(R.string.unknown_geofence_error);
        }
    }

}
