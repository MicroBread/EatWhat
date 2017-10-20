package com.example.eatwhat;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CityListActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    CityPickController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        mController = new CityPickController(this, findViewById(android.R.id.content));

    }
}
