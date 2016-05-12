package org.vcmo.thisgoods;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import org.vcmo.thisgoods.view.base.BaseActivity;
import org.vcmo.thisgoods.view.activity.LoginActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jie on 2016-05-11.
 */
public class StartActivity extends BaseActivity {


    private TextView containText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_start);
        containText = (TextView) findViewById(R.id.main_contain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        init();

        startAnimator();
    }

    private void startAnimator() {
        ObjectAnimator animX = ObjectAnimator.ofFloat(containText, "scaleX", 1, 0);
        ObjectAnimator animY = ObjectAnimator.ofFloat(containText, "scaleY", 1, 0);
        AnimatorSet anims = new AnimatorSet();
        anims.playTogether(animX, animY);
        anims.setDuration(800);
        anims.setInterpolator(new AccelerateInterpolator(2));
        anims.setStartDelay(1000);
        anims.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        anims.start();
    }

    private void init() {

        String message = "遇见你，真美好";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();

        String weekDay = "星期";
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                weekDay += "天";
                break;
            case 2:
                weekDay += "一";
                break;
            case 3:
                weekDay += "二";
                break;
            case 4:
                weekDay += "三";
                break;
            case 5:
                weekDay += "四";
                break;
            case 6:
                weekDay += "五";
                break;
            case 7:
                weekDay += "六";
                break;
        }

        containText.setText(sdf.format(date) + " , " + weekDay + "\n" + message);
    }


}
