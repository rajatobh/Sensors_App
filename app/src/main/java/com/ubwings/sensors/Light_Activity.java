package com.ubwings.sensors;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Light_Activity extends AppCompatActivity implements SensorEventListener {

    TextView light_tv;

    private SensorManager sensorManager;
    private Sensor light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_);

        light_tv=findViewById(R.id.light);


        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        light=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            light_tv.setText("Light=" + event.values[0]);
            if (event.values[0]<350){
                getWindow().getDecorView().setBackgroundColor(Color.BLACK);
            }
            else if (event.values[0]>=350 && event.values[0]<600){
                getWindow().getDecorView().setBackgroundColor(Color.GRAY);
            }
            else {getWindow().getDecorView().setBackgroundColor(Color.WHITE);}
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
