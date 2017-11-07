package com.example.eatwhat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CityListActivity extends AppCompatActivity {
    private int GPS_REQUEST_CODE = 10;
    RecyclerView recyclerView;
    CityPickController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        if (!isOpenLocation(getApplicationContext())) {
            openGPSSettings();
        }
        mController = new CityPickController(this, findViewById(android.R.id.content), CityListActivity.this);
    }

    /**
     * description: whether GPS or Wi-Fi location open or not
     *
     * @param context
     * @author meng on 2017/11/6 11:31
     */
    public static boolean isOpenLocation(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network)
            return true;
        return false;
    }

    private void openGPSSettings() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.notifyTitle)
                .setMessage(R.string.gpsNotifyMsg)
                .setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                .setPositiveButton(R.string.setting,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //跳转GPS设置界面
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivityForResult(intent, GPS_REQUEST_CODE);
                            }
                        })
                .setCancelable(false)
                .show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GPS_REQUEST_CODE) {
            mController = new CityPickController(this, findViewById(android.R.id.content), CityListActivity.this);
        }
    }
}
