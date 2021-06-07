package com.example;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.activity.R;

/**
 * Author: ruiduan
 * Date:  2021/6/7 16:00
 * Desc:
 */
public class AnimationActivity extends AppCompatActivity {

    private final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    private static final int ROTATION_ANIMATION_DURATION = 300;
    private static final int ROTATION_ANIMATION_REPEAT = 0;
    private static final int ROTATION_ANIMATION_DEGREE = 45;

    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);
        findViewById(R.id.btn_start_animation).setOnClickListener(v -> onClick(text));
        text = findViewById(R.id.tv_animation);
    }

    void onClick(View v) {
        v.setBackgroundColor(Color.RED);
        translateX(v);
    }


    void handleRotate(View v) {
        Animation mRotateAnimation = new RotateAnimation(0, ROTATION_ANIMATION_DEGREE, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f);
        mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        mRotateAnimation.setDuration(ROTATION_ANIMATION_DURATION);
        mRotateAnimation.setRepeatCount(ROTATION_ANIMATION_REPEAT);
        v.setAnimation(mRotateAnimation);
        mRotateAnimation.setFillAfter(true);
        v.startAnimation(mRotateAnimation);
    }

    public static void getObjectAnimatorLeftBarItemEnlargeScaleX(final View targetView) {
        final ObjectAnimator animator = ObjectAnimator.ofFloat(targetView, "scaleX", 0, 1);
        // 中心点设置在 （width, height / 2）
        targetView.post(new Runnable() {
            @Override
            public void run() {
                targetView.setPivotX(targetView.getWidth());
                targetView.setPivotY(targetView.getHeight() / 2.0f);
            }
        });
        animator.setDuration(1000);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(animator);
        mAnimatorSet.start();
    }

    public static void translateX(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0, 300);
        animator.setDuration(1000);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(animator);
        mAnimatorSet.start();
    }



}
