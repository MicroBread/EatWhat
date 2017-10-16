package com.example.eatwhat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Data;
import com.google.gson.Gson;

public class CityListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Gson gson = new Gson();
        CitiesBean citiesBean = gson.fromJson(Data.citiesJson, CitiesBean.class);
        adapter = new CitiesAdapter(this,citiesBean.getDatas());
        recyclerView.setAdapter(adapter);
    }
}
