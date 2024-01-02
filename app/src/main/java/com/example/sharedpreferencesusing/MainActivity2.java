package com.example.sharedpreferencesusing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = findViewById(R.id.text);

        Intent intent = getIntent();
        if (intent != null)
        {
            String isim = intent.getStringExtra("name");

            if (isim != null)
            {
                text.setText(isim);
            }
        }





    }
}