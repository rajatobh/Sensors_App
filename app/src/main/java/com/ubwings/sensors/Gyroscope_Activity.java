package com.ubwings.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Gyroscope_Activity extends AppCompatActivity implements SensorEventListener {
    TextView gyro_x, gyro_y, gyro_z;
    private SensorManager sensorManager;
    private Sensor Gyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope_);

        gyro_x = findViewById(R.id.xgyro);
        gyro_y = findViewById(R.id.ygyro);
        gyro_z = findViewById(R.id.zgyro);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, Gyro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()== Sensor.TYPE_GYROSCOPE)
        {
            gyro_x.setText("x:" + event.values[0]);
            gyro_y.setText("y:" + event.values[1]);
            gyro_z.setText("z:" + event.values[2]);}


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
