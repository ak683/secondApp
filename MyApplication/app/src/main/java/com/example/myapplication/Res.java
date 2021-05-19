package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Res extends AppCompatActivity {
    private TextView resTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        resTextView = findViewById(R.id.resTextView);
        resTextView.setText(getIntent().getStringExtra("answerList"));
    }
}