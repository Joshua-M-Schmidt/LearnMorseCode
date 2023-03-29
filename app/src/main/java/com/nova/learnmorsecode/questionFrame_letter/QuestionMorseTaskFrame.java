package com.nova.learnmorsecode.questionFrame_letter;

import android.os.Bundle;

import com.nova.learningframework.Question;
import com.nova.learningframework.QuestionFrame;
import com.nova.learnmorsecode.AlphabetCourseInfo;
import com.nova.learnmorsecode.StartActivity;
import com.nova.learnmorsecode.auxiliary.MorseInfo;
import com.nova.learnmorsecode.question.MorseTaskView;
import com.nova.learnmorsecode.view.FeedbackView;
import com.nova.learnmorsecode.view.NewInfoView;

public class QuestionMorseTaskFrame extends QuestionFrame {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AlphabetCourseInfo courseInfo = new AlphabetCourseInfo(getApplicationContext());


        parent = StartActivity.class;
        startAfter = courseInfo.getNextActivity();

        MorseTaskView questionView = new MorseTaskView(getApplicationContext());

        NewInfoView infoView = new NewInfoView(getApplicationContext());
        FeedbackView feedbackView = new FeedbackView(getApplicationContext());

        Question question = courseInfo.getQuestion();

        feedbackView.init(question.morse);

        infoView.init(courseInfo.levelLetter(), MorseInfo.letterToMorse(courseInfo.levelLetter()));

        init(question,courseInfo,infoView,questionView,feedbackView);

    }
}
