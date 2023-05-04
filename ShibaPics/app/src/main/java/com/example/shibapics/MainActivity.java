package com.example.shibapics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnF = (Button)findViewById(R.id.btnFood);
        Button btnT = (Button)findViewById(R.id.btnTouch);
        ImageView img = (ImageView)findViewById(R.id.shiba_space);

        btnF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                img.setImageResource(R.drawable.calm_shiba);
                Toast.makeText(getApplicationContext(), "LvB's Symphony No. 9, Final Movement", Toast.LENGTH_LONG).show();
            }
        });

        btnT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                img.setImageResource(R.drawable.angry_shiba);
                Toast.makeText(getApplicationContext(), "LvB's Piano Sonata No. 17 in D minor", Toast.LENGTH_LONG).show();
            }
        });
    }
}