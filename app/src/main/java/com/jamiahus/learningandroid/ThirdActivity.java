package com.jamiahus.learningandroid;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ThirdActivity extends Activity {

    Button changeFragments;
    boolean isFirstFragment = true;
    String firstFragmentTag = "DOG_FRAGMENT";
    String secondFragmentTag = "CAT_FRAGMENT";
    float activityOrderNum = 3;

    ProgressBar myProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        AdView myAd = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAd.loadAd(adRequest);

        String numOfTotalActivities = getString(R.string.Total_Number_of_Activities);
        Float numOfTatalActivitiesFloat = Float.valueOf(numOfTotalActivities);
        int progressValue = Math.round(activityOrderNum / numOfTatalActivitiesFloat * 100);
        myProgressBar = findViewById(R.id.myProgressBar);
        myProgressBar.setProgress(progressValue);

        changeFragments = (Button) findViewById(R.id.buttonChangeFragment);
        changeFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager myFragmentManager = getFragmentManager();
                FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();
                myFragmentTransaction.commit();

                if (isFirstFragment){
                    Fragment f2 = myFragmentManager.findFragmentByTag(secondFragmentTag);
                    if (f2 != null)
                    {
                        myFragmentTransaction.remove(f2);
                    }

                    //New to construct the fragment class
                    FirstFragment f1 = new FirstFragment();
                    myFragmentTransaction.add(R.id.fragmentContainer, f1, firstFragmentTag);
                    changeFragments.setText("Change to Second Fragment");
                    isFirstFragment = false;
                } else {
                    Fragment f1 = myFragmentManager.findFragmentByTag(firstFragmentTag);
                    myFragmentTransaction.remove(f1);
                    if (f1 != null)
                    {
                        myFragmentTransaction.remove(f1);
                    }

                    SecondFragment f2 = new SecondFragment();
                    myFragmentTransaction.add(R.id.fragmentContainer, f2, secondFragmentTag);
                    //myFragmentTransaction.commit();
                    changeFragments.setText("Change to First Fragment");
                    isFirstFragment = true;
                }

            }
        });
    }

}
