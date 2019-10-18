package com.ubwings.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class Accelerometer_Activity extends AppCompatActivity implements SensorEventListener {
    TextView accel_x, accel_y, accel_z;
    ImageView m;
    private SensorManager sensorManager;
    private Sensor Accel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_);

        accel_x = findViewById(R.id.x);
        accel_y = findViewById(R.id.y);
        accel_z = findViewById(R.id.z);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }


    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, Accel, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()== Sensor.TYPE_ACCELEROMETER)
        {


            accel_x.setText("x:" + event.values[0]);
            accel_y.setText("y:" + event.values[1]);
            accel_z.setText("z:" + event.values[2]);

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
