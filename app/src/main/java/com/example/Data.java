package com.example;
import android.app.Application;
/**
 * store global variables
 */

public class Data extends Application{

    public boolean loginState; //state for login in or not
    public String currentCity;
    public static final String citiesJson = "{\"datas\":[{\"alifName\":\"C\",\"addressList\":[{\"id\":37,\"name\":\"潮州\"}]},{\"alifName\":\"D\",\"addressList\":[{\"id\":20,\"name\":\"东莞\"}]},{\"alifName\":\"F\",\"addressList\":[{\"id\":21,\"name\":\"佛山\"}]},{\"alifName\":\"G\",\"addressList\":[{\"id\":5,\"name\":\"广州\"}]},{\"alifName\":\"H\",\"addressList\":[{\"id\":29,\"name\":\"惠州\"},{\"id\":32,\"name\":\"河源\"},{\"id\":33,\"name\":\"河源\"}]},{\"alifName\":\"J\",\"addressList\":[{\"id\":25,\"name\":\"江门\"},{\"id\":38,\"name\":\"揭阳\"}]},{\"alifName\":\"M\",\"addressList\":[{\"id\":27,\"name\":\"茂名\"},{\"id\":30,\"name\":\"梅州\"}]},{\"alifName\":\"Q\",\"addressList\":[{\"id\":7,\"name\":\"泉州\"},{\"id\":35,\"name\":\"清远\"}]},{\"alifName\":\"S\",\"addressList\":[{\"id\":6,\"name\":\"深圳\"},{\"id\":22,\"name\":\"韶关\"},{\"id\":24,\"name\":\"汕头\"},{\"id\":31,\"name\":\"汕尾\"}]},{\"alifName\":\"Y\",\"addressList\":[{\"id\":34,\"name\":\"阳江\"},{\"id\":39,\"name\":\"云浮\"}]},{\"alifName\":\"Z\",\"addressList\":[{\"id\":23,\"name\":\"珠海\"},{\"id\":26,\"name\":\"湛江\"},{\"id\":28,\"name\":\"肇庆\"},{\"id\":36,\"name\":\"中山\"}]}]}";

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
