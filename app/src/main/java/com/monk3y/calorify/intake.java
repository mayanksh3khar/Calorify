package com.monk3y.calorify;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class intake extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    public void calculate (View view)
    {
        Spinner intake_main = findViewById(R.id.intake_main);
        EditText intake_main_count = findViewById(R.id.intake_main_count);

        Spinner intake_second = findViewById(R.id.intake_second);

        StringBuilder statement_1 = new StringBuilder();
        StringBuilder statement_2 = new StringBuilder();
        StringBuilder statement_3 = new StringBuilder();

        TextView calculate = findViewById(R.id.intake_caluclate);

        TextView statement_text_1 = findViewById(R.id.statement1);
        TextView statement_text_2 = findViewById(R.id.statement2);
        TextView statement_text_3 = findViewById(R.id.statement3);

        //Preventing crash if main food count was empty
        if(intake_main_count.getText().toString().equals(""))
        {
            statement_text_1.setText("ENTER MAIN FOOD COUNT");
            statement_text_2.setText("");
            statement_text_3.setText("");
            calculate.setText("CALCULATE");
            return;
        }


        int cal_main = 0,cal_main_final, cal_second = 0, cal_final;

        switch(intake_main.getSelectedItem().toString())
        {
            case "ROTI":
                cal_main = 71;
                break;
            case "PURI":
                cal_main = 101;
                break;
            case "RICE":
                cal_main = 130;
                break;
            case "DOSA":
                cal_main = 133;
                break;
            case "IDLI":
                cal_main = 39;
                break;

        }

        switch(intake_second.getSelectedItem().toString())
        {
            case "ALOO GOBI":
                cal_second = 160;
                break;
            case "ALOO MATAR":
                cal_second = 155;
                break;
            case "MIX VEG":
                cal_second = 264;
                break;
            case "PANEER":
                cal_second = 298;
                break;
            case "CHICKEN":
                cal_second = 423;
                break;
            case "EGG CURRY":
                cal_second = 156;
                break;
            case "SAMBAR":
                cal_second = 151;
                break;
            case "CHUTNEY":
                cal_second = 110;
                break;
        }

        cal_main_final = cal_main * Integer.parseInt(intake_main_count.getText().toString());
        cal_final = cal_main_final + cal_second;

        statement_1.append("Each piece/serving of ").append(intake_main.getSelectedItem().toString()).append(" contains ").append(cal_main).append(" calories. ");
        statement_2.append("And ").append(intake_second.getSelectedItem().toString()).append(" has ").append(cal_second).append(" calories.");
        statement_3.append(cal_main).append("  cal × ").append(Integer.parseInt(intake_main_count.getText().toString())).append(" + ").append(cal_second).append(" cal = ").append(cal_final).append(" calories");

        statement_text_1.setText(statement_1.toString());
        statement_text_2.setText(statement_2.toString());
        statement_text_3.setText(statement_3.toString());
        calculate.setText(cal_final +" cal");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intake);
    }
}