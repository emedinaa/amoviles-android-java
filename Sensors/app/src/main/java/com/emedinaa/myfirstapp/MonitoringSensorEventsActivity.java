package com.emedinaa.myfirstapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MonitoringSensorEventsActivity extends AppCompatActivity implements
        SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mLight;
    private Sensor mProximity;
    private ImageView imageViewLight;


    //Monitoring Sensor Events
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring_sensor_events);
        imageViewLight= findViewById(R.id.imageViewLight);
        //sensor
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mProximity= mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float proximity = event.values[0];
        Log.v("CONSOLE", "proximity "+proximity);
        Log.v("CONSOLE", "max Value "+mProximity.getMaximumRange());
        /*float lux = event.values[0];
        Log.v("CONSOLE", "lux "+lux);

        int colorValue = (int) (255f * lux / mLight.getMaximumRange());
        imageViewLight.setBackgroundColor(Color.rgb(colorValue, colorValue, colorValue));*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        //mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        //mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

}
