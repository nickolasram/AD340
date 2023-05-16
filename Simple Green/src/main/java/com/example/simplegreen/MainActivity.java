package com.example.simplegreen;

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

        int[] dataSet = {1,2,3,4};

        RecyclerView.Adapter rva = new myAdapter(dataSet);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rva);

    }
}