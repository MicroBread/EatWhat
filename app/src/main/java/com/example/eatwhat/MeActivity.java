package com.example.eatwhat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
*description: Activity for page "我的"
*@author meng on 2017/11/3 16:54
*/
public class MeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        findViewById(R.id.mi_collect).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mi_collect:
                //Intent intent = new Intent(MeActivity.this,xxx.class);
                //startActivity(intent);
                break;
            case R.id.mi_setting:
                break;
        }
    }
}
