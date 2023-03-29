package com.nova.learnmorsecode;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.google.android.gms.ads.MobileAds;
import com.nova.learningframework.Courselist;


public class StartActivity extends Courselist{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        background.setImageResource(R.drawable.background_1);

        addCourse(new AlphabetCourseInfo(getApplicationContext()),StartActivity.this);
        addCourse(new NumberCourseInfo(getApplicationContext()),StartActivity.this);
    }

}
