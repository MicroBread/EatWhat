package com.example;
import android.app.Application;
/**
 * store global variables
 */

public class Data extends Application{

    private boolean loginState; //state for login in or not
    /**
     *description: set login state
     *@author MicroBread on 2017/8/31 17:19
     *@param   state1
     *@return   NULL
     */
    protected void setLoginState(boolean state1){

        this.loginState = state1;
    }
    /**
     *description: get login state
     *@author MicroBread on 2017/8/31 17:19
     *@param   state1
     *@return   boolean
     */
    protected boolean getLoginState(boolean state1){

        return this.loginState;
    }
}
