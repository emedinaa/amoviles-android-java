package com.emedinaa.myfirstapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainSensorsActivity extends AppCompatActivity {

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sensors);
        init();
    }

    private void init(){

        //Listar sensores disponibles
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor:deviceSensors) {
            //Log.v("CONSOLE", "sensor "+sensor.getName()+"  type : "+sensor.getStringType());
            Log.v("CONSOLE", "sensor "+sensor.getName()+"  type : "+sensor.getType());
        }

        //Verificar si un sensor esta disponible
        /*mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
            // Success! There's a magnetometer.
            toast("Success! There's a magnetometer");
        } else {
            // Failure! No magnetometer.
            toast("Failure! No magnetometer.");
        }*/

    }

    private void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /*
    sensor Goldfish 3-axis Accelerometer  type : android.sensor.accelerometer
    sensor Goldfish 3-axis Gyroscope  type : android.sensor.gyroscope
    sensor Goldfish 3-axis Magnetic field
    sensor  type : android.sensor.magnetic_field
    sensor Goldfish Orientation sensor  type : android.sensor.orientation
    sensor Goldfish Ambient Temperature sensor  type : android.sensor.ambient_temperature
    sensor Goldfish Proximity sensor  type : android.sensor.proximity
    sensor Goldfish Light sensor  type : android.sensor.light
    sensor Goldfish Pressure sensor  type : android.sensor.pressure
    sensor Goldfish Humidity sensor  type : android.sensor.relative_humidity
    sensor Goldfish 3-axis Magnetic field sensor (uncalibrated)  type : android.sensor.magnetic_field_uncalibrated
    sensor Game Rotation Vector Sensor  type : android.sensor.game_rotation_vector
    sensor GeoMag Rotation Vector Sensor  type : android.sensor.geomagnetic_rotation_vector
    sensor Gravity Sensor  type : android.sensor.gravity
    sensor Linear Acceleration Sensor  type : android.sensor.linear_acceleration
    sensor Rotation Vector Sensor  type : android.sensor.rotation_vector
    sensor Orientation Sensor  type : android.sensor.orientation
     */
}
