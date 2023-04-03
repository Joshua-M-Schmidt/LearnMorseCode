package com.nova.learnmorsecode.question;

import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nova.learningframework.Question;
import com.nova.learningframework.QuestionForm;
import com.nova.learnmorsecode.R;

import static com.nova.learnmorsecode.auxiliary.MorseInfo.DASH;
import static com.nova.learnmorsecode.auxiliary.MorseInfo.DOT;

public class MorseTaskView extends QuestionForm {
    private TextView answer;
    private TextView question;
    private Question questionInfo;
    private Context ctx;
    private ImageView background;
    private ProgressBar progressBar;
    private TextView pauseText;
    private ImageButton back;

    public MorseTaskView(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public MorseTaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();
    }

    public MorseTaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ctx = context;
        init();
    }

    public MorseTaskView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.ctx = context;
        init();
    }

    @Override
    public boolean isRight(){
        String unprocessed = getAnswer();
        Log.i("is right before", unprocessed);
        while(unprocessed.endsWith(" ") || unprocessed.endsWith("/")){
            unprocessed = unprocessed.substring(0,unprocessed.length()-1);
        }
        Log.i("is right after", unprocessed);
        return unprocessed.equals(questionInfo.morse);
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
        inflate(getContext(), R.layout.question_morse_task,this);

        question = findViewById(R.id.question);

        progressBar = findViewById(R.id.pr_progress_in_circle);
        progressBar.setMax(100);
        progressBar.setProgress(100);

        vibrator = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);

        back = findViewById(R.id.edit_delete);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(answer.getText().length() > 0){
                    answer.setText(answer.getText().toString().substring(0,answer.getText().toString().length()-1));
                }
                pauseTimer.cancel();
                longpauseTimer.cancel();
            }
        });

        pauseText = findViewById(R.id.pause_test);

        initAnswerEdit();
        initBackground();
    }

    @Override
    public boolean performClick() {
        // Calls the super implementation, which generates an AccessibilityEvent
        // and calls the onClick() listener on the view, if any
        super.performClick();

        // Handle the action for the custom click here

        return true;
    }

    ToneGenerator toneGen1;
    long time;
    CountDownTimer pauseTimer;
    CountDownTimer longpauseTimer;
    float pause = 1000;
    float longpause = 2000;

    private void initBackground(){
        toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        background = findViewById(R.id.background);
        background.setImageResource(R.drawable.morse_task_back_2);
        pauseTimer = new CountDownTimer((long) pause,5) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (((pause-millisUntilFinished)/pause)*100f);
                Log.i("progress",progress+" ");
                progressBar.setProgress(100-progress);
                longpauseTimer.cancel();
                pauseText.setText("short pause");
            }

            @Override
            public void onFinish() {
                answer.setText(answer.getText().toString()+" ");
                longpauseTimer.start();
                progressBar.setProgress(100);
                pauseText.setText("");
            }
        };

        longpauseTimer = new CountDownTimer((long) longpause,5) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (((longpause-millisUntilFinished)/longpause)*100f);
                Log.i("progress",progress+" ");
                progressBar.setProgress(100-progress);
                pauseText.setText("long pause");
            }

            @Override
            public void onFinish() {
                answer.setText(answer.getText().toString()+"/ ");
                progressBar.setProgress(100);
                pauseText.setText("");
            }
        };


        background.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("touch events",event.getAction()+ " Action");
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        time = System.currentTimeMillis();
                        background.setImageResource(R.drawable.morse_task_back_1);
                        toneGen1.startTone(ToneGenerator.TONE_DTMF_S,10000);
                        vibrator.vibrate(10000);
                        progressBar.setProgress(100);

                        pauseTimer.cancel();
                        longpauseTimer.cancel();
                        break;
                    case MotionEvent.ACTION_UP:
                        long now = System.currentTimeMillis();
                        long diff = now - time;
                        if(diff > 150){
                            answer.setText(answer.getText().toString()+DASH);
                        }else{
                            answer.setText(answer.getText().toString()+DOT);
                        }
                        background.setImageResource(R.drawable.morse_task_back_2);
                        toneGen1.stopTone();
                        vibrator.cancel();
                        pauseTimer.start();
                        break;
                    default:
                        background.setImageResource(R.drawable.morse_task_back_2);
                }
                return true;
            }
        });
    }

    private void initAnswerEdit(){
        answer = findViewById(R.id.answer);
        answer.setClickable(false);
    }


}
