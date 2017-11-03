package com.example.utils;

import android.text.TextUtils;

public class Util {

    public static String getFirstLetter(String pinyin) {
        if (TextUtils.isEmpty(pinyin)) return null;
        return pinyin.substring(0, 1);
    }
}
