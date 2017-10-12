package com.example.splash;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;

import java.util.Timer;
import java.util.TimerTask;

import com.example.eatwhat.R;

import com.example.eatwhat.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private ConstraintLayout splash_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash_root = (ConstraintLayout) findViewById(R.id.splash_root);

        Timer timer = new Timer();
        timer.schedule(new MyTask(),3000);//定时器延时执行任务的方法
        initAnimation();
    }

    private void initAnimation() {
        AlphaAnimation alphaAnimation = new  AlphaAnimation(0,1);
        alphaAnimation.setDuration(3000);
        splash_root.startAnimation(alphaAnimation);
    }

    class MyTask extends TimerTask{
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
