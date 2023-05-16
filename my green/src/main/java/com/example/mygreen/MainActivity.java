package com.example.mygreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);

        String[] dataSet = {"Godard", "Miyazaki", "Tarkovsky", "Aster", "Lynch", "Herzog", "Kar-Wai", "Eggers"};

        RecyclerView.Adapter rva = new myAdapter(dataSet);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rva);

    }
}