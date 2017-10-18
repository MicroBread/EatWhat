package com.example.eatwhat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Data;
import com.google.gson.Gson;

public class CityListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CityPickController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        mController = new CityPickController(this, findViewById(android.R.id.content));
    }
}
