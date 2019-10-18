package com.ubwings.sensors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Reference_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_);
        TextView text1, text2, text3, text4, text5, text6, text7;

        text1= (TextView) findViewById(R.id.txt);
        text1.setMovementMethod(LinkMovementMethod.getInstance());

        text2= (TextView) findViewById(R.id.txt2);
        text2.setMovementMethod(LinkMovementMethod.getInstance());

        text3= (TextView) findViewById(R.id.txt3);
        text3.setMovementMethod(LinkMovementMethod.getInstance());

        text4= (TextView) findViewById(R.id.txt4);
        text4.setMovementMethod(LinkMovementMethod.getInstance());

        text5= (TextView) findViewById(R.id.txt5);
        text5.setMovementMethod(LinkMovementMethod.getInstance());

        text6= (TextView) findViewById(R.id.txt6);
        text6.setMovementMethod(LinkMovementMethod.getInstance());

        text7= (TextView) findViewById(R.id.txt7);
        text7.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
