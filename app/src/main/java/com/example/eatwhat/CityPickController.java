package com.example.eatwhat;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.CityBean;
import com.example.DBManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meng on 2017/10/18.
 */

public class CityPickController implements LetterSideBar.OnTouchLetterListener {

    private View mRootView;
    private TextView mTvMask;
    private LetterSideBar mLsSidebar;
    private ListView mLvCityList;
    private Context mContext;

    private CityAdapter mAdapter;

    private List<CityBean> mCities = new ArrayList<>();


    public CityPickController(Context context, View root) {
        mRootView = root;
        mContext = context;
        initView();
        mCities = DBManager.getInstance(mContext).getAllCities();//
        mAdapter = new CityAdapter(mContext, mCities);
        mLvCityList.setAdapter(mAdapter);
    }

    private void initView() {
        mTvMask = (TextView) mRootView.findViewById(R.id.id_tv_mask);
        mLsSidebar = (LetterSideBar) mRootView.findViewById(R.id.id_ls_sidebar);
        mLvCityList = (ListView) mRootView.findViewById(R.id.id_lv_citys);
        mLsSidebar.setOverLayTextView(mTvMask);
        mLsSidebar.setOnTouchLetterListener(this);
    }


    /**
     * 处理选择字母时的回调
     *
     * @param letter
     */
    @Override
    public void onLetterSelected(String letter) {
        int position = mAdapter.getPosition(letter);
        if (position != -1)
            mLvCityList.setSelection(position);
    }
}