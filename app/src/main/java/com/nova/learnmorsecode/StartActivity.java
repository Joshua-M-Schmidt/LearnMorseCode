package com.nova.learnmorsecode;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.nova.learningframework.Courselist;


public class StartActivity extends Courselist{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        background.setImageResource(R.drawable.background_1);

        addCourse(new AlphabetCourseInfo(getApplicationContext()),StartActivity.this);
        addCourse(new NumberCourseInfo(getApplicationContext()),StartActivity.this);
    }

}
