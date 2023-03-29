package com.nova.learnmorsecode.questionFrame_number;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.nova.learningframework.Question;
import com.nova.learningframework.QuestionFrame;
import com.nova.learnmorsecode.StartActivity;
import com.nova.learnmorsecode.view.FeedbackView;
import com.nova.learnmorsecode.auxiliary.MorseInfo;
import com.nova.learnmorsecode.view.NewInfoView;
import com.nova.learnmorsecode.NumberCourseInfo;
import com.nova.learnmorsecode.question.MorseLightView;

public class QuestionNumberLightFrame extends QuestionFrame {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final NumberCourseInfo courseInfo = new NumberCourseInfo(getApplicationContext());


        parent = StartActivity.class;
        startAfter = courseInfo.getNextActivity();

        MorseLightView questionView = new MorseLightView(getApplicationContext());

        NewInfoView infoView = new NewInfoView(getApplicationContext());
        FeedbackView feedbackView = new FeedbackView(getApplicationContext());

        Question question = courseInfo.getQuestion();

        question.normal = String.valueOf(question.normal.charAt(0));
        question.morse = MorseInfo.letterToMorse(question.normal);

        feedbackView.init(question.normal);

        infoView.init(courseInfo.levelLetter(), MorseInfo.letterToMorse(courseInfo.levelLetter()));

        init(question,courseInfo,infoView,questionView,feedbackView);

        if(!courseInfo.showNewInfo()){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }
}

