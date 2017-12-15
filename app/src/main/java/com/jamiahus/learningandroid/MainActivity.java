package com.jamiahus.learningandroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity {
    Button dogButton;
    Button catButton;
    Button sendButton;
    ImageView animalImageView;
    String appIdAdMob = "ca-app-pub-4038286169752674~1920671748";
    //Drawable dogImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize ads
        MobileAds.initialize(this,appIdAdMob);

        animalImageView = findViewById(R.id.animalView);
        dogButton = findViewById(R.id.Dog);
        catButton = findViewById(R.id.Cat);
        sendButton = findViewById(R.id.SendButton);

        dogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePicture("D");
            }
        });

        catButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePicture("C");
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNextActivity = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(startNextActivity);
            }
        });
    }

    private void ChangePicture(String value){
        if (value.equals("D")){
            animalImageView.setImageDrawable(getResources().getDrawable(R.drawable.dog_280332_960_720));

        } else if (value.equals("C")){
            animalImageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
        }
    }
}
