package com.nova.learningframework;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

public class QuestionFeedbackView extends FrameLayout {
    public QuestionFeedbackView(Context context) {
        super(context);
    }

    public QuestionFeedbackView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuestionFeedbackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public QuestionFeedbackView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setPositiveNegative(boolean positive){

    }
}
