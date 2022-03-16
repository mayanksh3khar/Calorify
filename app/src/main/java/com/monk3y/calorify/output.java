package com.monk3y.calorify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class output extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    public void calculate(View view)
    {

        Spinner activity = findViewById(R.id.output_activity);

        EditText time_hrs = findViewById(R.id.output_hours);
        EditText time_mins = findViewById(R.id.output_mins);

        TextView calculate = findViewById(R.id.intake_caluclate);
        TextView statement1 = findViewById(R.id.statement1);
        TextView statement2 = findViewById(R.id.statement2);
        TextView statement3 = findViewById(R.id.statement3);

        int activity_cal = 0;
        float time = 0;
        float total_cal = 0;
        int extra_hours = 0;
        boolean is_hour = true;

        //Preventing crash due to empty EditText
        //Return if both fields are empty
        if(time_hrs.getText().toString().equals("") && time_mins.getText().toString().equals(""))
        {
            statement1.setText("ENTER TIME");
            statement2.setText("");
            statement3.setText("");
            calculate.setText("CALCULATE");
            return;
        }
        //Set the empty field to 0 if only one is empty
        else if(time_hrs.getText().toString().equals(""))
        {
            time_hrs.setText("0");
        }
        else if(time_mins.getText().toString().equals(""))
        {
            time_mins.setText("0");
        }

        int hrs = Integer.parseInt(time_hrs.getText().toString());
        int mins = Integer.parseInt(time_mins.getText().toString());

        if(Integer.parseInt(time_mins.getText().toString()) > 60)
        {
            extra_hours = Integer.parseInt(time_mins.getText().toString()) / 60;
            hrs += extra_hours;
            mins -= extra_hours * 60;
            time_hrs.setText(Integer.toString(hrs));
            time_mins.setText(Integer.toString(mins));

        }


        switch (activity.getSelectedItem().toString())
        {
            case "WALKING":
                activity_cal = 285;
                break;
            case "JOGGING":
                activity_cal = 557;
                break;
            case "CYCLING":
                activity_cal = 327;
                break;
            case "DANCING":
                activity_cal = 421;
                break;
            case "SKIPPING":
                activity_cal = 592;
                break;
            case "SWIMMING":
                activity_cal = 528;
                break;
        }

        time = (float) hrs + ((float) mins / 60);
        total_cal = (float) activity_cal * time;
        calculate.setText(total_cal + " cal");
        statement1.setText(activity.getSelectedItem().toString() + " burns on average " + activity_cal +"calories per hour");
        StringBuilder statement2_builder = new StringBuilder("You were " + activity.getSelectedItem().toString() + " for ");
        if(hrs > 1)
        {
            statement2_builder.append(hrs + " hours");
        }
        else if (hrs == 1)
        {
            statement2_builder.append("an hour");
        }
        else
        {
            is_hour = false;
        }

        if(is_hour && mins !=0)
        {
            statement2_builder.append(" and " + mins + " minutes.");
        }
        else if(!is_hour && mins!=0)
        {
            statement2_builder.append(" "+ mins + " minutes.");
        }
        else
        {
            statement2_builder.append(".");
        }

        statement2.setText(statement2_builder.toString());
        statement3.setText(activity_cal + " × ( " + hrs + " + ( " + mins + " / 60 ) = " + total_cal);




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
    }
}