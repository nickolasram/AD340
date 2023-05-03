package com.example.btnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnI = (Button)findViewById(R.id.myBtnIncrease);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                Toast.makeText(getApplicationContext(), "Butter or Jam?", Toast.LENGTH_LONG).show();
//            }
//
//        });
        count = 0;
        TextView txt = (TextView)findViewById(R.id.myTxt);
        txt.setText(""+count);
        btnI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                txt.setText(""+count);
            }
        });
        Button btnD = (Button)findViewById(R.id.myBtnDecrease);
        btnD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count--;
                txt.setText(""+count);
            }
        });
    }
}