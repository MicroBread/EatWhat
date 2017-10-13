package com.example.eatwhat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "HomeActivity";
    private MapView mapView;
    private BaiduMap baiduMap;
    private LocationClient locationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initLocation();
        locationClient.registerLocationListener(new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                Toast.makeText(HomeActivity.this,bdLocation.getAddrStr(),Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onReceiveLocation: " + bdLocation.getAddrStr());
            }
        });
        findViewById(R.id.noddle_home_imgbutton).setOnClickListener(this);
        findViewById(R.id.me_home_imgbutton).setOnClickListener(this);
        findViewById(R.id.search_home_imgbutton).setOnClickListener(this);

        //MapView mapView = null;
        //mapView = (MapView) findViewById(R.id.bmapView);

        //TextView textView = (TextView) findViewById(R.id.marquee);
        //setTextMarquee(textView,"1");
    }
    /*
    public static void setTextMarquee(TextView textView,String text) {
        if (textView != null) {
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setSingleLine(true);
            textView.setSelected(true);
            textView.setFocusable(true);
            textView.setFocusableInTouchMode(true);
            textView.setText("just for test just for test just for test just for test just for test just for test just for test just for test just for test just for test");
        }
    } */

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
                //To do with my page
                break;
        }
    }

    private void initLocation(){
        //baiduMap = mapView.getMap();
        locationClient = new LocationClient(this);
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
}
