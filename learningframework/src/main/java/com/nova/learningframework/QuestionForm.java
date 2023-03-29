package com.nova.learningframework;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class QuestionForm extends FrameLayout {
    public QuestionForm(Context context) {
        super(context);
    }

    public QuestionForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuestionForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public QuestionForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setQuestion(Question question){}

    public String getAnswer(){
        return "";
    }

    public boolean isRight(){
        return false;
    }
}
