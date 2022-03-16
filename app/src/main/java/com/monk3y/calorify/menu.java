package com.monk3y.calorify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    public void bmi_onclick(View view)
    {
        startActivity(new Intent(menu.this, bmi.class));
    }

    @SuppressLint("SetTextI18n")
    public void intake_onclick(View view)
    {
        startActivity(new Intent(menu.this, intake.class));
    }

    @SuppressLint("SetTextI18n")
    public void output_onclick(View view)
    {
        startActivity(new Intent(menu.this, output.class));
    }

    @SuppressLint("SetTextI18n")
    public void about_onclick(View view)
    {
        startActivity(new Intent(menu.this, about.class));
    }

    @Override
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}