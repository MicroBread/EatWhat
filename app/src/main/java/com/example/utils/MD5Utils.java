package com.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by MicroBread on 2017/11/6.
 */

public class MD5Utils {
    //md5 encription
    public static String encoder(String psd){
        try {
            String psdWithSalt = psd + "MicroBread";
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bs = messageDigest.digest(psdWithSalt.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for(byte b : bs){
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if(hexString.length()<2){
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            String ans = stringBuffer.toString();
            return ans;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String err = "error";
        return err;
    }
}
