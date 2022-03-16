package com.monk3y.calorify;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class about extends AppCompatActivity {

    public int clickable =0;


    @SuppressLint("SetTextI18n")
    public void fart(View view) {


        TextView more = findViewById(R.id.fart);
        MediaPlayer fartsound = MediaPlayer.create(this, R.raw.fart_sound);
        if (clickable == 0) {
            more.setText("TOLD YOU");
            clickable++;
            fartsound.start();
        }
        else if (clickable == 1) {
            more.setText("LIKE FART?");
            clickable++;
            fartsound.start();
        }
        else if (clickable == 2) {
            more.setText("IT IS A JOKE");
            clickable++;
            fartsound.start();
        }
        else if (clickable == 3) {
            more.setText("ONLY FUNNY ONCE");
            clickable++;
            fartsound.start();
        }
        else if (clickable == 4) {
            more.setText("THIS ENDS NOW");
            clickable++;
            fartsound.start();
        }
        else if ((clickable >= 5) && (clickable <= 6)) {
            more.setText("ENOUGH!");
            clickable++;
        }
        else if((clickable == 7) || (clickable == 8))
        {
            more.setText("BYE BYE NOW!");
            clickable++;
        }
        else
        {
            more.setText(getResources().getString(R.string.about_more));
        }
        // more.setText(String.valueOf(clickable));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // TextView more = findViewById(R.id.fart);
        // more.setText(String.valueOf(clickable));
    }
}