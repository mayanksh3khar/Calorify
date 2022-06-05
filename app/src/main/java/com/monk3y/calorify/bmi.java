package com.monk3y.calorify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class bmi extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "ResourceType"})
    public void reset(View view)
    {
        EditText height = findViewById(R.id.height);
        height.setText(null);
        EditText weight = findViewById(R.id.weight);
        weight.setText(null);
        TextView hint = findViewById(R.id.bmi_hint);
        hint.setText("Cleared");
        hint.setTextColor(this.getResources().getColor(R.color.monk3y_purple1));
        TextView title = findViewById(R.id.bmi_title);
        title.setText(this.getResources().getString(R.string.bmi_title));
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void calculate(View view)
    {
        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        TextView title = findViewById(R.id.bmi_title);
        TextView hint = findViewById(R.id.bmi_hint);


        if(height.getText().toString().equals("") || weight.getText().toString().equals(""))
        {
            hint.setText("Empty Variables");
            hint.setTextColor(this.getResources().getColor(R.color.red));
            return;
        }

        hint.setText("Calculating");
        hint.setTextColor(this.getResources().getColor(R.color.red));

        float h = Float.parseFloat(height.getText().toString());
        float w = Float.parseFloat(weight.getText().toString());
        h /= 100;
        float bmi = w / ( h * h ) ;

        title.setText("BMI = " + String.format("%.1f", new BigDecimal(bmi)));

        StringBuilder long_answer = new StringBuilder("Your BMI is ");
        long_answer.append(String.format("%.1f",new BigDecimal(bmi)));
        long_answer.append(". This is considered ");
        if (bmi < 18.5)
            long_answer.append("underweight.");
        else if (bmi >= 18.5 && bmi < 25)
            long_answer.append("healthy.");
        else if (bmi >=25 && bmi < 30)
            long_answer.append("overweight.");
        else
            long_answer.append("obese.");
        hint.setText(long_answer.toString());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }
}