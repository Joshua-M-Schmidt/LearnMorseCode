package com.nova.learningframework;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Courselist extends AppCompatActivity {

    boolean debug_intro_screen = false;
    public SharedPreferences prefs;
    public ImageView background;
    private LinearLayout main_layout;
    public static final String first_use_key = "firstrun";
    public static final String LAST_CLASS = "last_class";

    ArrayList<CourseView> courseViewArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        colorizeToolbarOverflowButton(toolbar, Color.WHITE);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        overridePendingTransition(0,0);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        prefs.edit().putString(LAST_CLASS,"").commit();

        if (prefs.getBoolean(first_use_key, true) || debug_intro_screen) {
            prefs.edit().putBoolean(first_use_key, false).commit();
            //StartActivity(new Intent(Courselist.this, IntroActivity.class));
        }

        background = findViewById(R.id.background);

        main_layout = findViewById(R.id.main_layout);


        View decorView = getWindow().getDecorView();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    public void showDialog(boolean showAd,final String course_title){
        final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.premium_dialog, null);

        Button view = dialogView.findViewById(R.id.view);
        TextView view_t = dialogView.findViewById(R.id.view_t);
        View divider = dialogView.findViewById(R.id.divider);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DO SOMETHINGS
                dialogBuilder.dismiss();
            }
        });

        if(!showAd){
            view.setVisibility(View.GONE);
            view_t.setVisibility(View.GONE);
            divider.setVisibility(View.GONE);
        }

        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }


    public void handleAdwatched(String course_title){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR,1);
        prefs.edit().putString(course_title, cal.getTime().toString()).commit();
        recreate();
    }

    ArrayList<CourseInfo> courses = new ArrayList<>();

    public void addCourse(final CourseInfo course, final Context ctx){
        CourseView courseView = new CourseView(getApplicationContext(),course);
        final boolean isPremium = true;
        if(!course.locked || isPremium){
            courseView.premium();
        }else if(isStartable(course.title,getApplicationContext())){
            courseView.unlock();
        }

        courseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx,course.getNextActivity()));
            }
        });
        courses.add(course);
        courseViewArrayList.add(courseView);
        main_layout.addView(courseView);
        courseView.setTag(course.title);
    }

    public static boolean isStartable(String courseTitle,Context ctx){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        String time = PreferenceManager.getDefaultSharedPreferences(ctx).getString(courseTitle,"");

        Calendar currentTime = Calendar.getInstance();

        if(time.isEmpty()){
            return false;
        }else{
            try {
                cal.setTime(sdf.parse(time));// all done
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Log.i("logtime current",cal.getTime().toString()+" after "+currentTime.getTime().toString());
            Log.i("logtime current","is current before stored +30s "+cal.after(currentTime.getTime()));
            Log.i("logtime current","is current before stored +30s "+(currentTime.getTimeInMillis() < cal.getTimeInMillis()));
            if(currentTime.getTimeInMillis() < cal.getTimeInMillis()){
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean colorizeToolbarOverflowButton(@NonNull Toolbar toolbar, @ColorInt Integer toolbarIconsColor) {
        final Drawable overflowIcon = toolbar.getOverflowIcon();
        if (overflowIcon == null)
            return false;
        final PorterDuffColorFilter colorFilter = toolbarIconsColor == null ? null : new PorterDuffColorFilter(toolbarIconsColor, PorterDuff.Mode.MULTIPLY);
        overflowIcon.setColorFilter(colorFilter);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            for (CourseInfo c : courses) {
                prefs.edit().putInt(c.key, 0).commit();
            }

            finish();
            startActivity(getIntent());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
