package com.jamiahus.learningandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SecondActivity extends Activity {
    String numOfTotalActivities;
    float numOfTatalActivitiesFloat;
    float activityOrderNum = 2;

    ProgressBar myProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        numOfTotalActivities = getString(R.string.Total_Number_of_Activities);
        numOfTatalActivitiesFloat = Float.valueOf(numOfTotalActivities);
        int progressValue = Math.round(activityOrderNum / numOfTatalActivitiesFloat * 100);
        myProgressBar = findViewById(R.id.myProgressBar);
        myProgressBar.setProgress(progressValue);
        //Log.d("PROGRESS",String.valueOf(progressValue));

        AdView myAd = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAd.loadAd(adRequest);

        Button nextActivity = (Button) findViewById(R.id.button_NextActivity);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToStartActivity = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intentToStartActivity);
            }
        });



    }
}