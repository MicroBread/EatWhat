package com.example.eatwhat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
*description: Activity for page "我的"
*@author meng on 2017/11/3 16:54
*/
public class MeActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        //change buttom bar icon
        ImageButton imageButton = (ImageButton) findViewById(R.id.me_home_imgbutton);
        int resid = getResources().getIdentifier("me_home_change","drawable","com.example.eatwhat");
        imageButton.setImageResource(resid);

        //set listener for control
        findViewById(R.id.mi_collect).setOnClickListener(this);
        findViewById(R.id.mi_setting).setOnClickListener(this);
        findViewById(R.id.search_home_imgbutton).setOnClickListener(this);
        findViewById(R.id.noddle_home_imgbutton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mi_collect:
                //startActivity(new Intent(MeActivity.this,xxx.class));
                //设置切换动画
                //overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.mi_setting:
                break;
            case R.id.noddle_home_imgbutton:
                startActivity(new Intent(MeActivity.this, HomeActivity.class));
                overridePendingTransition(0,0);
            break;
            case R.id.search_home_imgbutton:
                //To do with search page
                break;
        }
    }
}
