package com.nova.learnmorsecode;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nova.learningframework.CourseInfo;
import com.nova.learningframework.Question;
import com.nova.learnmorsecode.questionFrame_number.QuestionNumberLetterFrame;
import com.nova.learnmorsecode.questionFrame_number.QuestionNumberLightFrame;
import com.nova.learnmorsecode.questionFrame_number.QuestionNumberMorseTaskFrame;
import com.nova.learnmorsecode.questionFrame_number.QuestionNumberSoundFrame;

import java.util.ArrayList;
import java.util.Random;

import static com.nova.learnmorsecode.auxiliary.MorseInfo.letterToMorse;

public class NumberCourseInfo extends CourseInfo {

    public SharedPreferences prefs;

    public NumberCourseInfo(Context ctx){
        super(R.drawable.morse_number,0xff303030,"Learn Morse\nNumbers","number_course_key",ctx,true);
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    @Override
    public Class getNextActivity(){
        ArrayList<Class> question_list = new ArrayList<>();
        question_list.add(QuestionNumberLetterFrame.class);
        question_list.add(QuestionNumberLightFrame.class);
        question_list.add(QuestionNumberMorseTaskFrame.class);
        question_list.add(QuestionNumberSoundFrame.class);


        Class cl = question_list.get(new Random().nextInt(question_list.size()));

        prefs.edit().putString(cl.getName(),"").commit();
        return cl;
    }

    @Override
    public int[] getLevels(){
        return new int[]{
                0,3,6,15,35,55,75,95,115,135,200
        };
    }

    public  String levelLetter(){
        switch (getLevel()){
            case 1:
                return "0";
            case 2:
                return "1";
            case 3:
                return "2";
            case 4:
                return "3";
            case 5:
                return "4";
            case 6:
                return "5";
            case 7:
                return "6";
            case 8:
                return "7";
            case 9:
                return "8";
            case 10:
                return "9";
            default:
                return "0";
        }
    }

    @Override
    public Question getQuestion(){
        String[] letters;

        switch (getLevel()){
            case 1:
                letters = new String[]{"0"};
                break;
            case 2:
                letters = new String[]{"0","1"};
                break;
            case 3:
                letters = new String[]{"0","1","2"};
                break;
            case 4:
                letters = new String[]{"0","1","2","3"};
                break;
            case 5:
                letters = new String[]{"0","1","2","3","4"};
                break;
            case 6:
                letters = new String[]{"0","1","2","3","4","5"};
                break;
            case 7:
                letters = new String[]{"0","1","2","3","4","5","6"};
                break;
            case 8:
                letters = new String[]{"0","1","2","3","4","5","6","7"};
                break;
            case 9:
                letters = new String[]{"0","1","2","3","4","5","6","7","8"};
                break;
            case 10:
                letters = new String[]{"0","1","2","3","4","5","6","7","8","9"};
                break;
            default:
                letters = new String[]{"0","1","2","3","4","5","6","7","8","9"};
                break;
        }

        String normal = "";
        Random r = new Random();

        int len = r.nextInt(3)+1;
        for(int i = 0; i < len; i++){
            normal += letters[r.nextInt(letters.length)];
        }

        return new Question(letterToMorse(normal.toUpperCase()),normal.toUpperCase(),key);
    }

}
