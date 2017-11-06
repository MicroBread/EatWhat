package com.example.eatwhat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.example.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final int PEMISSION_REQUESTCODE = 1;
    public int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        //get all permissions?
        if(permissionGot()){ //yes and start home page
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }else{  //no and alert ERROR
            new AlertDialog.Builder(this)
                    .setTitle("错误")
                    .setMessage("权限不足，请重启应用。")
                    .setNegativeButton(R.string.cancel,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                    .setCancelable(false)
                    .show();
        }
    }
    
    /**
    *description: whether you get all pemissions
    *@author MicroBread on 2017/11/6 14:32
    *@param
    */
    public boolean permissionGot() {
        // permission want to get
        String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_NETWORK_STATE,
                                Manifest.permission.ACCESS_WIFI_STATE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        //dynamic permissions access above Android 6.0(SDK >= 23)
        if (Build.VERSION.SDK_INT >= 23) {
            for(int i=0; i<4; i++) {
                int check = ContextCompat.checkSelfPermission(this, permissions[i]);
                // whether get the permission or not GRANTED or DINIED
                if (check == PackageManager.PERMISSION_GRANTED) { //yes
                    Log.d("", "permissionGot: "+permissions[i]);
                    count++;
                    continue;
                } else {
                    //request for permissions
                    requestPermissions(new String[]{permissions[i]}, PEMISSION_REQUESTCODE);
                }
            }
        } else {
            count = 0;
            return true;
        }
        //if not get all permissions
        if(count != 4) {
            count = 0;
            return false;
        }
        //if get all permissions
        count = 0;
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PEMISSION_REQUESTCODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            count++;
        } else {
            Toast.makeText(this,"Need Permission: "+grantResults[0],Toast.LENGTH_SHORT).show();
        }
    }
}
