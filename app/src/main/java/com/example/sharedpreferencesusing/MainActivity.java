package com.example.sharedpreferencesusing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button buttonGoSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGoSecondActivity = findViewById(R.id.buttonGoSecondActivity);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Veri Okuma
        String name = sharedPreferences.getString("userName", "");
        System.out.println(name);
        int age = sharedPreferences.getInt("age", 0);
        System.out.println(age);
        boolean evli = sharedPreferences.getBoolean("evli", false);
        System.out.println(evli);

        // Veri kaydetme // (Key - Value ilişkisi vardır.Eğer alanlar boş ise kayıt yapılır.)
        if (name.equals(""))
        {
            editor.putString("userName", "Esra Didem");
            editor.apply();
        }

        if (age == 0)
        {
            editor.putInt("age", 30);
            editor.apply();
        }

        if (!evli)
        {
            editor.putBoolean("evli", true);
            editor.apply();
        }

        // If kullanımında boolean değişkeni
        boolean havaYagmurluMu;
        havaYagmurluMu = false;

        if (havaYagmurluMu)
        {
            System.out.println("Hava yağmurlu!");
        }
        else
        {
            System.out.println("Hava yağmurlu değil!");
        }

        if (!havaYagmurluMu)
        {
            System.out.println("Hava yağmurlu değil!");
        }


        System.out.println("Editleme işlemi bitti!");

        // Veri Silme
        //editor.remove("userName");
        //editor.remove("age");
        //editor.remove("evli");
        editor.apply();

        // Tüm Verileri Temizleme
        //editor.clear();


        // Butona tıklama ve diğer activity'ye gitme
        buttonGoSecondActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
}