package com.nova.learningframework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.github.jinatonic.confetti.CommonConfetti;

public class QuestionFrame extends AppCompatActivity {

    public static final int STATE_NEW_INFORMATION = 0;
    public static final int STATE_ASK_QUESTION = 1;
    public static final int STATE_SHOW_FEEDBACK = 2;

    public Button checkNext;
    ProgressBar levelProgress;
    RelativeLayout container;
    View obscureView;

    public FrameLayout feedback;
    public FrameLayout newInformation;
    public FrameLayout background;
    public FrameLayout question;

    public Class parent;

    private QuestionForm q;

    private int currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);

        View decorView = getWindow().getDecorView();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        overridePendingTransition(0,0);

        checkNext = findViewById(R.id.check_next);
        container = findViewById(R.id.container);
        levelProgress = findViewById(R.id.progress_bar);
        obscureView = findViewById(R.id.obscure_view);
        feedback = findViewById(R.id.feedback_bubble);
        newInformation = findViewById(R.id.new_information);
        background = findViewById(R.id.background);
        question = findViewById(R.id.question);
    }

    QuestionFeedbackView questionFeedbackView;
    CourseInfo courseInfo;

    public Class startAfter;
    private MediaPlayer mp;
    private MediaPlayer mp_wrong;

    public void init(Question questionInfo,CourseInfo courseInfo, View infoView, QuestionForm questionView, QuestionFeedbackView feedbackView){
        q = questionView;
        q.setQuestion(questionInfo);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.correct_sound);
        mp_wrong = MediaPlayer.create(getApplicationContext(), R.raw.incorrect);

        this.courseInfo = courseInfo;

        levelProgress.setProgress(courseInfo.getLevelProgress());

        questionFeedbackView = feedbackView;
        feedback.addView(feedbackView);

        newInformation.addView(infoView);

        if(courseInfo.showNewInfo()){
            setState(STATE_NEW_INFORMATION);
        }else{
            setState(STATE_ASK_QUESTION);
        }

        question.addView(q);
    }


    public void setState(int state){
        switch (state){
            case STATE_NEW_INFORMATION:
                currentState = STATE_NEW_INFORMATION;
                newInformation.setVisibility(View.VISIBLE);
                feedback.setVisibility(View.GONE);
                highlightElement(newInformation,false);
                checkNext.setText("NEXT");
                checkNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismissElement();
                        setState(STATE_ASK_QUESTION);
                    }
                });
                break;
            case STATE_ASK_QUESTION:
                currentState = STATE_ASK_QUESTION;
                newInformation.setVisibility(View.GONE);
                feedback.setVisibility(View.GONE);
                checkNext.setText("CHECK");
                checkNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismissElement();
                        setState(STATE_SHOW_FEEDBACK);
                    }
                });
                break;
            case STATE_SHOW_FEEDBACK:
                currentState = STATE_SHOW_FEEDBACK;
                newInformation.setVisibility(View.GONE);

                if(q.isRight()){
                    questionFeedbackView.setPositiveNegative(true);
                    courseInfo.questionAnswerdRight();
                    if(courseInfo.showNewInfo()){
                        rainConfetti(true);
                    }else{
                        rainConfetti(false);
                    }
                }else{
                    mp_wrong.start();
                    questionFeedbackView.setPositiveNegative(false);
                }

                highlightElement(feedback,false);
                feedback.setVisibility(View.VISIBLE);
                checkNext.setText("NEXT");

                checkNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismissElement();
                        startActivity(new Intent(QuestionFrame.this,startAfter));
                    }
                });
                break;
            default:
                break;
        }
    }

    public void highlightElement(View element, boolean hideCheck){
        obscureView.setVisibility(View.VISIBLE);
        obscureView.bringToFront();
        if(hideCheck){
            checkNext.setAlpha(0.3f);
            checkNext.setClickable(false);
        }
        findViewById(R.id.appbar).bringToFront();
        findViewById(R.id.appbar).bringToFront();
        element.bringToFront();
    }

    public void dismissElement(){
        obscureView.setVisibility(View.GONE);
        checkNext.setAlpha(1f);
        checkNext.setClickable(true);
    }

    public void rainConfetti(boolean newLevel){
        mp.start();
        if(newLevel){
            CommonConfetti.rainingConfetti(container, new int[] { getResources().getColor(R.color.red) }).stream(2000).setAccelerationY(500);
        }else{
            CommonConfetti.rainingConfetti(container, new int[] { getResources().getColor(R.color.green) }).stream(1000).setAccelerationY(500);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs.edit().putBoolean("running", false).commit();
        startActivity(new Intent(this,parent));
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
