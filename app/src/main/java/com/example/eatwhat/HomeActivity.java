package com.example.eatwhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;

import com.example.utils.SharedPreferencesUtil;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    //private SharedPreferencesUtil spu;
    private static final String TAG = "HomeActivity";
    private LocationClient locationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_home);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        initLocation();
        locationClient.registerLocationListener(new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                String cc;
                cc = bdLocation.getAddrStr();
                SharedPreferencesUtil.putString(getApplicationContext(),"currentCity",cc);
                if(cc != null)
                    setTopbarLocation(cc);
            }
        });


        findViewById(R.id.noddle_home_imgbutton).setOnClickListener(this);
        findViewById(R.id.me_home_imgbutton).setOnClickListener(this);
        findViewById(R.id.search_home_imgbutton).setOnClickListener(this);
        findViewById(R.id.topbar_position_button).setOnClickListener(this);


    }
    @Override
    public void onRestart(){
        super.onRestart();
        setTopbarLocation(null);
        //Log.d(TAG, "onResume: currentCity: " + SharedPreferencesUtil.getString());
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.noddle_home_imgbutton:
                //To do with home page
                break;
            case R.id.search_home_imgbutton:
                //To do with search page
                break;
            case R.id.me_home_imgbutton:
                Intent intent4 = new Intent(HomeActivity.this,MeActivity.class);
                startActivity(intent4);
                break;
            case R.id.topbar_position_button:
                Intent intent5 = new Intent(HomeActivity.this , CityListActivity.class);
                startActivity(intent5);
                setTopbarLocation(null);
                break;
            case R.id.topbar_search_button:
                break;
        }
    }
    /**
    *description: get the current location using BaiduMap API
    *@author meng on 2017/10/13 16:20
    */
    private void initLocation(){
        locationClient = new LocationClient(getApplicationContext());
        LocationClientOption locationClientOption = new LocationClientOption();
        locationClientOption.setOpenGps(true);
        locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        locationClientOption.setCoorType("bd0911");
        locationClientOption.setScanSpan(5000);
        locationClientOption.setIsNeedAddress(true);
        locationClientOption.disableCache(true);
        locationClient.setLocOption(locationClientOption);
        locationClient.start();
    }

    /**
    *description: set home page location button text with cs
    *@author meng on 2017/10/19 13:31
    *@param cs
    *       cs: setting currentCity
    */
    public void setTopbarLocation(String cs){
        if(cs != null) {
            Button btn = (Button) findViewById(R.id.topbar_position_button);
            btn.setText(cs);
        }else{
            CharSequence cc = SharedPreferencesUtil.getString(getApplicationContext(),"currentCity","正在定位中...");
            if(cc != null) {
                Button btn = (Button) findViewById(R.id.topbar_position_button);
                btn.setText(cc);
            }
        }
    }
}
