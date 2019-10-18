package com.ubwings.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Proximity_Activity extends AppCompatActivity implements SensorEventListener {


    TextView proximity_tv;
    ImageView p;

    private SensorManager sensorManager;
    private Sensor prox;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_);

        proximity_tv = findViewById(R.id.proxi);
        p = findViewById(R.id.pic);



        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        prox=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,prox,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            proximity_tv.setText("Proximity="+event.values[0]);
            if (event.values[0] == 0) {
                p.setImageResource(R.drawable.pic2);
            } else {
                p.setImageResource(R.drawable.pic3);
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
