package com.nova.learnmorsecode.questionFrame_letter;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.nova.learningframework.Question;
import com.nova.learningframework.QuestionFrame;
import com.nova.learnmorsecode.StartActivity;
import com.nova.learnmorsecode.AlphabetCourseInfo;
import com.nova.learnmorsecode.view.FeedbackView;
import com.nova.learnmorsecode.auxiliary.MorseInfo;
import com.nova.learnmorsecode.question.MorseLetterView;
import com.nova.learnmorsecode.view.NewInfoView;

public class QuestionLetterFrame extends QuestionFrame {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AlphabetCourseInfo courseInfo = new AlphabetCourseInfo(getApplicationContext());

        parent = StartActivity.class;
        startAfter = courseInfo.getNextActivity();

        MorseLetterView questionView = new MorseLetterView(getApplicationContext());

        NewInfoView infoView = new NewInfoView(getApplicationContext());
        FeedbackView feedbackView = new FeedbackView(getApplicationContext());

        Question question = courseInfo.getQuestion();

        feedbackView.init(question.normal);

        infoView.init(courseInfo.levelLetter(), MorseInfo.letterToMorse(courseInfo.levelLetter()));

        init(question,courseInfo,infoView,questionView,feedbackView);

        if(!courseInfo.showNewInfo()){
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }



    }
}
