package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.example.eatwhat.HomeActivity;
import com.example.eatwhat.R;
import com.example.utils.SharedPreferencesUtil;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private Button log;
    private EditText name,pwd;
    public static final OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .build();

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==1){
                //add login user to SP.currentUser
                SharedPreferencesUtil.putString(getApplicationContext(),"currentUser",name.getText().toString().trim());
                //back to Home page
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name= (EditText) findViewById(R.id.userName_loginActivity);
        pwd= (EditText) findViewById(R.id.password_loginActivity);
        log= (Button) findViewById(R.id.loginButton_loginActivity);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postRequest(name.getText().toString().trim(),pwd.getText().toString().trim());
            }
        });
    }
    /**
    *description: post request to server
    *@author MicroBread on 2017/11/16 17:15
    *@param name,pwd
    *   name:username, pwd:user password
    */
    private void postRequest(String name,String pwd)  {
        //create form, post param
        FormBody formBody = new FormBody.Builder()
                .add("name",name)
                .add("pwd",pwd)
                .add("method","okhttpreg")
                .build();
        //post request
        final Request request = new Request.Builder()
                .url("http://www.huxiangmeng.com:8080/loginServlet")
                .post(formBody)
                .build();
        //new task to get response from server
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //send response.body().string() to hanlder，refresh UI
                        mHandler.obtainMessage(1, response.body().string()).sendToTarget();
                    } else {
                        throw new IOException("Unexpected code:" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}
