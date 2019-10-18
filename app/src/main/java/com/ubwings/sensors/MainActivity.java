package com.ubwings.sensors;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {


    String array[]={"accel", "mag", "gyro", "l", "prox", "ref"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD")
                ,R.drawable.plus,R.drawable.x)
                .addSubMenu(Color.parseColor("#008080"),R.drawable.acc)
                .addSubMenu(Color.parseColor("#2E8B57"),R.drawable.gyro)
                .addSubMenu(Color.parseColor("#FFDAB9"),R.drawable.mag)
                .addSubMenu(Color.parseColor("#FF7F50"),R.drawable.light)
                .addSubMenu(Color.parseColor("#DC143C"),R.drawable.proxi)
                .addSubMenu(Color.parseColor("#DA70D6"),R.drawable.ref)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        switch(index)
                        {
                            case 0:


                            startActivity(new Intent(MainActivity.this,Accelerometer_Activity.class));
                                break;

                            case 1:
                                startActivity(new Intent(MainActivity.this,Gyroscope_Activity.class));
                                break;

                            case 2:
                                startActivity(new Intent(MainActivity.this,Magnetometer_Activity.class));
                                break;

                            case 3:
                                startActivity(new Intent(MainActivity.this,Light_Activity.class));
                                break;

                            case 4:
                                startActivity(new Intent(MainActivity.this,Proximity_Activity.class));
                                break;

                            case 5:
                                startActivity(new Intent(MainActivity.this,Reference_Activity.class));
                                break;
                        }

                    }
                });




    }


}
