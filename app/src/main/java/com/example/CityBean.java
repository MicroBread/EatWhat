package com.example;

import java.util.List;

/**
 * Created by meng on 2017/10/18.
 */

public class CityBean {
        private int cityId;//城市id
        private String cityName;//城市名
        private int superiorId;//上级城市id
        private List<CityBean> subordinateList;//下级城市集合
        //忽略get/set方法
}
