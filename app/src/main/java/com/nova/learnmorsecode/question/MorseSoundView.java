package com.nova.learnmorsecode.question;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.nova.learningframework.Question;
import com.nova.learningframework.QuestionForm;
import com.nova.learnmorsecode.R;

import static com.nova.learnmorsecode.auxiliary.MorseInfo.DASH;
import static com.nova.learnmorsecode.auxiliary.MorseInfo.DOT;

public class MorseSoundView extends QuestionForm {

    private ImageView ship;
    private ImageView water;
    private ImageView foreground;
    private EditText answer;
    private Question questionInfo;
    private SharedPreferences prefs;
    private Context ctx;

    Runnable morsing = null;
    Handler handler = null;

    public MorseSoundView(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public MorseSoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();
    }

    public MorseSoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ctx = context;
        init();
    }

    public MorseSoundView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        morsing = getMorsingRunnable(question.morse);
        blink(question.morse);
    }

    @Override
    public String getAnswer() {
        try {
            prefs.edit().putBoolean(RUN_KEY,false).commit();
            Log.i("blink_test", "put_false");
        } finally {
            return answer.getText().toString();
        }
    }

    private void init() {
        inflate(getContext(), R.layout.question_sound, this);

        ship = findViewById(R.id.background);
        ship.setTag(R.drawable.back_of);

        foreground = findViewById(R.id.background2);

        water = findViewById(R.id.background1);
        answer = findViewById(R.id.answer);

        answer.requestFocus();

        InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(answer, InputMethodManager.SHOW_IMPLICIT);

        Animatable animatable = (Animatable) water.getDrawable();
        animatable.start();

        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        prefs.edit().putBoolean(RUN_KEY, true).commit();

        handler = new Handler();

    }

    public static final String RUN_KEY = "running";
    int counter;
    boolean destroy;
    String tag = "blink_test";

    @Override
    public void onDetachedFromWindow(){
        super.onDetachedFromWindow();
        if(morsing != null){
            handler.removeCallbacks(morsing);
        }
    }

    private void blink(final String sequence){

        Log.i(tag,sequence);

        prefs.edit().putBoolean(RUN_KEY, true).commit();

        Log.i("blink_test","run "+prefs.getBoolean(RUN_KEY,false));
        destroy = false;
        counter = 0;

        handler.postDelayed(morsing, 1000);
    }

    private Runnable getMorsingRunnable(final String sequence){
        return new Runnable() {
            @Override
            public void run() {
                Log.i("blink_test","run "+prefs.getBoolean(RUN_KEY,false));

                if((int) ship.getTag() == R.drawable.back_of){
                    //ship.setImageResource(R.drawable.back);
                    ship.setTag(R.drawable.back);
                    if(String.valueOf(sequence.charAt(counter)).equals(DOT)){
                        if(prefs.getBoolean(RUN_KEY,false)){
                            ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                            toneGen1.startTone(ToneGenerator.TONE_DTMF_S,50);
                        }
                    }else if(String.valueOf(sequence.charAt(counter)).equals(DASH)){
                        if(prefs.getBoolean(RUN_KEY,false)){
                            ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                            toneGen1.startTone(ToneGenerator.TONE_DTMF_S,300);
                        }
                    }
                }else{
                    //ship.setImageResource(R.drawable.back_of);
                    ship.setTag(R.drawable.back_of);
                }

                Log.i(tag,""+counter);

                if((int) ship.getTag() == R.drawable.back_of){
                    if(counter == sequence.length()){
                        counter = 0;
                        if(prefs.getBoolean(RUN_KEY,false))
                            handler.postDelayed(this, 1000);
                    }else{
                        if(prefs.getBoolean(RUN_KEY,false))
                            handler.postDelayed(this, 100);
                    }

                }else{

                    Log.i(tag,String.valueOf(sequence.charAt(counter)));

                    if(String.valueOf(sequence.charAt(counter)).equals(DOT)){
                        if(prefs.getBoolean(RUN_KEY,false))
                            handler.postDelayed(this, 150);
                    }else if(String.valueOf(sequence.charAt(counter)).equals(DASH)){
                        if(prefs.getBoolean(RUN_KEY,false))
                            handler.postDelayed(this, 600);
                    }

                    counter++;

                }
            }
        };
    }
}