package com.nova.learnmorsecode.question;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nova.learningframework.Question;
import com.nova.learningframework.QuestionForm;
import com.nova.learnmorsecode.R;

public class MorseLetterView extends QuestionForm {

    private TextView receiveMorse;
    private EditText answer;
    private Question questionInfo;
    private Context ctx;

    public MorseLetterView(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public MorseLetterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();
    }

    public MorseLetterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ctx = context;
        init();
    }

    public MorseLetterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.ctx = context;
        init();
    }

    @Override
    public boolean isRight() {
        return getAnswer().equals(questionInfo.normal);
    }

    @Override
    public void setQuestion(Question question) {
        this.questionInfo = question;
        this.receiveMorse.setText(question.morse);
    }

    @Override
    public String getAnswer() {
        return answer.getText().toString();
    }

    private void init() {
        inflate(getContext(), R.layout.question_letter, this);

        receiveMorse = findViewById(R.id.receive_morse);
        answer = findViewById(R.id.answer);
        answer.requestFocus();
    }
}
