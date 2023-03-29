package com.nova.learnmorsecode.question;

import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nova.learningframework.Question;
import com.nova.learningframework.QuestionForm;
import com.nova.learnmorsecode.R;

import static com.nova.learnmorsecode.auxiliary.MorseInfo.DASH;
import static com.nova.learnmorsecode.auxiliary.MorseInfo.DOT;


public class MorseQuestionView extends QuestionForm {

    private Button morseDash;
    private Button morseDot;
    private ImageButton remove;
    private ImageButton space;
    private EditText answer;
    private TextView question;
    private Question questionInfo;
    private Context ctx;

    public MorseQuestionView(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public MorseQuestionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();
    }

    public MorseQuestionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ctx = context;
        init();
    }

    public MorseQuestionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.ctx = context;
        init();
    }

    @Override
    public boolean isRight(){
        return getAnswer().equals(questionInfo.morse);
    }

    @Override
    public void setQuestion(Question question){
        this.questionInfo = question;
        this.question.setText("Morse \""+question.normal+"\":");
    }

    @Override
    public String getAnswer(){
        return answer.getText().toString();
    }

    Vibrator vibrator;

    private void init(){
        inflate(getContext(), R.layout.question_morse,this);

        question = findViewById(R.id.question);

        vibrator = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);

        initAnswerEdit();
        initMorseDashButton();
        initMorseDotButton();
        initRemoveButton();
        initSpaceButton();
    }

    private void initAnswerEdit(){
        answer = findViewById(R.id.answer);
        answer.setClickable(false);
    }

    private void initRemoveButton(){
        remove = findViewById(R.id.edit_delete);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = answer.getText().toString();
                if(!text.isEmpty()){
                    answer.setText(text.substring(0,text.length()-1));
                }
            }
        });
    }

    private void initSpaceButton(){
        space = findViewById(R.id.space);
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText()+" ");
            }
        });
    }

    private void initMorseDashButton(){
        morseDash = findViewById(R.id.morse_dash);
        morseDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText()+DASH);
                ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,200);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    vibrator.vibrate(150);
                }
            }
        });
    }

    private void initMorseDotButton(){
        morseDot = findViewById(R.id.morse_dot);
        morseDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText(answer.getText()+DOT);
                ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,50);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    vibrator.vibrate(50);
                }
            }
        });
    }
}
