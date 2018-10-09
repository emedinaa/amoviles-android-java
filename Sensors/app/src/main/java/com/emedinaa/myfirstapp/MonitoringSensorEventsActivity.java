package com.emedinaa.myfirstapp;

import android.content.Context;
import android.graphics.Color;
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
    private ImageView imageViewLight;


    //Monitoring Sensor Events
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring_sensor_events);
        imageViewLight= findViewById(R.id.imageViewLight);
        //sensor
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float lux = event.values[0];
        Log.v("CONSOLE", "lux "+lux);

        int colorValue = (int) (255f * lux / mLight.getMaximumRange());
        imageViewLight.setBackgroundColor(Color.rgb(colorValue, colorValue, colorValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

}
