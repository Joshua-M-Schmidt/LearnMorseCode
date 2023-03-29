package com.nova.learningframework;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class CourseInfo {

    String title;
    int color;
    int imageResource;
    boolean locked;

    public final String key;
    private SharedPreferences prefs;

    public CourseInfo(int imageResource, int color, String title,String key, Context ctx,boolean locked){
        this.key = key;
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        this.title = title;
        this.color = color;
        this.imageResource = imageResource;
        this.locked = locked;
    }

    public Class getNextActivity(){
        return null;
    }

    public int[] getLevels(){
        return null;
    }

    public int getLevelCount(){
        return getLevels().length;
    }

    public int getLevel(){
        int games = getRight();
        String TAG = "level_calc";
        Log.i(TAG,"games: "+games);
        for(int i = getLevels().length-1; i >= 0; i--){
            Log.i(TAG,"i: "+i+" level number: "+getLevels()[i]+" bool: "+(games >= getLevels()[i]));
            if(games >= getLevels()[i]){
                return i+1;
            }
        }
        return 1;
    }

    public int getLevelProgress(){
        int right = getRight();

        float level = getLevel();
        float last = getLevels()[(int)level-1];
        float next = getLevels()[(int)level];

        float dif = next-last;

        float rightdif = right-last;

        float progress = rightdif/dif*100f;
        return (int)progress;
    }

    public Question getQuestion(){
        Log.e(this.getClass().getName(),"override getQuestion()");
        return null;
    }

    public boolean showNewInfo(){
        boolean newlevel = false;

        int right = getRight();
        Log.i("check_level",right+"");
        if(right == 0){
            return true;
        }

        for(int i = 0; i < getLevels().length; i++){
            Log.i("check_level",getLevels()[i] +" / "+ (right)+"  "+((getLevels()[i] / ((float)right)) == 1f));
            if((getLevels()[i] / ((float)right)) == 1f){
                newlevel = true;
            }
        }

        return newlevel;
    }
    public int getRight(){
        return prefs.getInt(key,0);
    }

    public void questionAnswerdRight(){
        prefs.edit().putInt(key,prefs.getInt(key,0)+1).commit();
    }
}
