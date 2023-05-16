package com.example.databindingbtn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databindingbtn.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setCount(0);
        activityMainBinding.myBtnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), String.format("Reset: %d -> %d", activityMainBinding.getCount(), 0), Toast.LENGTH_LONG).show();
                activityMainBinding.setCount(0);
            }
        });
        activityMainBinding.myBtnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = activityMainBinding.getCount();
                int newCount = currentCount - 1;
                Toast.makeText(getApplicationContext(), String.format("Decrement: %d -> %d", currentCount, newCount), Toast.LENGTH_LONG).show();
                activityMainBinding.setCount(newCount);
            }
        });
        activityMainBinding.myBtnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = activityMainBinding.getCount();
                int newCount = currentCount + 1;
                Toast.makeText(getApplicationContext(), String.format("Increment: %d -> %d", currentCount, newCount), Toast.LENGTH_LONG).show();
                activityMainBinding.setCount(newCount);
            }
        });
    }
}