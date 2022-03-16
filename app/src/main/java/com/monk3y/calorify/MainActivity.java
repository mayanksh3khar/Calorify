package com.monk3y.calorify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String username_login="monkey";
    String password_login="1234";


    @SuppressLint("SetTextI18n")
    public void submit(View view)
    {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        TextView hint = findViewById(R.id.login_hint);

        if((username.getText().toString().equals(username_login)) && (password.getText().toString().equals(password_login)))
        {
            hint.setText("Valid Credentials");
            hint.setTextColor(this.getResources().getColor(R.color.monk3y_purple1));
            startActivity(new Intent(MainActivity.this, menu.class));

        }
        else
        {
            hint.setText("Invalid Credentials");
            hint.setTextColor(this.getResources().getColor(R.color.red));
        }
    }

    @SuppressLint("SetTextI18n")
    public void register(View view)
    {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        TextView hint = findViewById(R.id.login_hint);

        if((username.getText().toString().equals("")) || password.getText().toString().equals(""))
        {
            hint.setText("Blank Credentials");
            hint.setTextColor(this.getResources().getColor(R.color.red));
        }
        else
        {
            username_login = username.getText().toString();
            password_login = password.getText().toString();
            hint.setText("Credentials Saved");
            hint.setTextColor(this.getResources().getColor(R.color.monk3y_purple1));
        }
    }

    @SuppressLint("SetTextI18n")
    public void forgot(View view){
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        TextView hint = findViewById(R.id.login_hint);
        username.setText(username_login);
        password.setText(password_login);
        hint.setText("Now sign in");
        hint.setTextColor(this.getResources().getColor(R.color.monk3y_purple1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}