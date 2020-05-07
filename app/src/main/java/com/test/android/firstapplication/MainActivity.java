package com.test.android.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView text;

    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        text2 = (EditText) findViewById(R.id.editText);

    }

    //Tulostaa "Hello World!" konsoliin
    public void button (View v) {
        System.out.println("Hello World!");

        text.setText("Hello World!");

    }

    //Muuntaa tekstikentässä olevan tekstin käyttäjän syötteeksi
    public void button2 (View v) {

        text.setText(text2.getText());

    }

    //Käynnistää update metodin
    public void button3 (View v) {

        update();

    }

    //Käynnistää uuden Activityn, jossa tehtävä 7.5
    public void button4 (View v) {

        startActivity(new Intent(MainActivity.this, NextActivity.class));

    }

    //Päivittää käyttäjän syötteen reaaliaikaisesti tekstikenttään
    public void update() {

        final Handler h = new Handler();

        final int delay = 100;

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                String enteredData=text2.getText().toString();
                text.setText(enteredData);
                h.postDelayed(this, delay);
            }
        }, delay);

    }

}
