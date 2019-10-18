package com.ubwings.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Magnetometer_Activity extends AppCompatActivity implements SensorEventListener {

    TextView mag_x,mag_y,mag_z;
    private SensorManager sensorManager;
    private Sensor Magnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetometer_);

        mag_x=findViewById(R.id.xmag);
        mag_y=findViewById(R.id.ymag);
        mag_z=findViewById(R.id.zmag);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Magnet = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, Magnet, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()== Sensor.TYPE_MAGNETIC_FIELD)
        {


            mag_x.setText("x:" + event.values[0]);
            mag_y.setText("y:" + event.values[1]);
            mag_z.setText("z:" + event.values[2]);}

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
