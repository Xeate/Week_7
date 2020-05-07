package com.test.android.firstapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    Context context = null;

    TextView text;

    EditText e1;

    EditText e2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        text = (TextView) findViewById(R.id.textView2);
        e1 = (EditText) findViewById(R.id.editText2);
        e2 = (EditText) findViewById(R.id.editText3);
        context = NextActivity.this;

        System.out.println(context.getFilesDir());

    }

    public void readFile(View v){
        try {
            text.setText(" ");
            //Lukee tiedoston syötteen perusteella
            InputStream ins = context.openFileInput(e1.getText().toString());

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s ="";

            while ((s=br.readLine()) != null) {
                System.out.println(s);
                text.append(s);
                text.append("\n");

            }
            ins.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        }
    }

    public void writeFile(View v) {
        try {
            //Luo tiedoston syötteen perusteella
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(e1.getText().toString(), Context.MODE_PRIVATE));

            String s = "";

            //Kirjoittaa käyttäjän antaman syötteen tiedostoon
            s = e2.getText().toString();
            ows.write(s);
            ows.close();

        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        }
    }

}