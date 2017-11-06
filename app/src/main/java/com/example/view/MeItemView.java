package com.example.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.eatwhat.R;


/**
 * Create item view in "我的"
 * Created by meng on 2017/11/3.
 */

public class MeItemView extends RelativeLayout {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.example.eatwhat";
    private static final String TAG = "MeItemView";
    String destitle;
    String imageid;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MeItemView(Context context) {
        this(context,null);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MeItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MeItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        View.inflate(context, R.layout.me_item_view,this);

        TextView tv_title = (TextView) findViewById(R.id.title_me) ;
        ImageView imageView = (ImageView) findViewById(R.id.image_me);
        //get attribute
        initAttrs(attrs);

        tv_title.setText(destitle);
        setImageViewResouce(imageView,imageid);
    }

    /**
    *description: to set imageview resources
    *@author meng on 2017/11/6 9:49
    *@param iv,imageid
    *
    */
    private void setImageViewResouce(ImageView iv, String imageid) {
        int resid = getResources().getIdentifier(imageid,"drawable","com.example.eatwhat");
        Log.d(TAG, "setImageViewResouce: "+resid);
        iv.setImageResource(resid);
    }

    /**
    *description: retrun attrs from AttributeSet
    *@author meng on 2017/11/3 17:24
    *@param attrs
    *   AttributeSet
    */
    private void initAttrs(AttributeSet attrs) {
        destitle = attrs.getAttributeValue(NAMESPACE,"destitle");
        imageid = attrs.getAttributeValue(NAMESPACE, "imageid");
    }

}
