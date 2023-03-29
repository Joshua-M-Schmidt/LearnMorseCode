package com.nova.learnmorsecode.auxiliary;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.nova.learnmorsecode.R;

public class Background extends FrameLayout {

    ImageView background;

    public Background(Context context) {
        super(context);
        init();
    }

    public Background(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Background(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Background(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.background_ship,this);
        background = findViewById(R.id.background1);

        Animatable animatable = (Animatable) background.getDrawable();
        animatable.start();
    }
}
