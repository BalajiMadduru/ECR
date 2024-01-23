package com.example.ecr_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class LaunchScreen extends AppCompatActivity {
   ImageButton master;
   ImageButton visa;
   ImageButton manual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        master = findViewById(R.id.master);
        visa = findViewById(R.id.visa);
        manual = findViewById(R.id.manual);

        }



    }
