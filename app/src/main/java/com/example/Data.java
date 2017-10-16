package com.example;
import android.app.Application;
/**
 * store global variables
 */

public class Data extends Application{

    public boolean loginState; //state for login in or not
    public String currentCity;

    public Data(){
        loginState = false;
        currentCity = "未定位";
    }
    /**
     *description: set/get login state
     *@author MicroBread on 2017/8/31 17:19
     *@param   state1
     *          login state
     */
    public void setLoginState(boolean state1){

        this.loginState = state1;
    }

    public boolean getLoginState(){

        return this.loginState;
    }
    /**
     *description: get/set current city
     *@author MicroBread on 2017/10/16 14:00
     *@param   cc
     *          current city
     */
    public void setCurrentCity(String cc){

        this.currentCity = cc;
    }

    public String getCurrentCity(){

        return currentCity;
    }
}
