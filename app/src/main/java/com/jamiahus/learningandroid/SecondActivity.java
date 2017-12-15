package com.jamiahus.learningandroid;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        AdView myAd = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAd.loadAd(adRequest);
    }
}