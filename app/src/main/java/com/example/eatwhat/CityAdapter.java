package com.example.eatwhat;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.CityBean;
import com.example.Util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static com.baidu.location.h.k.L;

/**
 * Created by meng on 2017/10/18.
 */

public class CityAdapter extends BaseAdapter{
    // ListView Type
    private static final int TYPE_CITY_ITEM = 1;
    private static final int TYPE_SEARCH_VIEW = 0;
    private static final int TYPE_VIEW_COUNT = 2; // 所有的View类型

    private Context mContext;
    private List<CityBean> mCities;
    private HashMap<CityBean, Integer> mLetterPos = new LinkedHashMap<>();

    public CityAdapter(Context context, List<CityBean> cities) {
        mContext = context;
        mCities = cities;
        mCities.add(0, new CityBean()); // 添加一个空的CityBean
        // record city's pinyin bound
        mLetterPos.put(cities.get(0), 1);
        for (int i = 1; i < mCities.size(); i++) {
            CityBean prev = mCities.get(i - 1);
            CityBean cur = mCities.get(i);
            if (!TextUtils.equals(Util.getFirstLetter(prev.getPinyin())
                    , Util.getFirstLetter(cur.getPinyin()))) {
                mLetterPos.put(cur, i);
            }
        }
        //L.d(mLetterPos.toString());
    }

    @Override
    public int getCount() {
        return mCities.size();
    }

    @Override
    public Object getItem(int i) {
        return mCities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        int viewType = getItemViewType(i);
        switch (viewType) {
            case TYPE_SEARCH_VIEW: // 搜索框
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search, viewGroup, false);
                break;
            case TYPE_CITY_ITEM: // 城市Item
                ViewHolder holder;
                if (convertView == null || convertView.getTag() == null) {
                    holder = new ViewHolder();
                    LayoutInflater inflater = LayoutInflater.from(mContext);
                    convertView = inflater.inflate(R.layout.item_city, viewGroup, false);
                    holder.mTvCity = (TextView) convertView.findViewById(R.id.id_tv_city_name);
                    holder.mTvLetter = (TextView) convertView.findViewById(R.id.id_tv_letter);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                CityBean curCity = mCities.get(i);
                if (mLetterPos.containsKey(curCity)) {
                    holder.mTvLetter.setVisibility(View.VISIBLE);
                    String letter = Util.getFirstLetter(curCity.getPinyin());
                    if (!TextUtils.isEmpty(letter)) {
                        holder.mTvLetter.setText(letter.toUpperCase());
                    }
                } else {
                    holder.mTvLetter.setVisibility(View.GONE);
                }
                holder.mTvCity.setText(curCity.getName());
                break;
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
//        L.d("getItemViewType : " + position);
        return position >= TYPE_VIEW_COUNT - 1 ? TYPE_CITY_ITEM : TYPE_SEARCH_VIEW;
    }


    private class ViewHolder {
        private TextView mTvLetter;
        private TextView mTvCity;
    }

    public int getPosition(String letter) {

        int position = -1;
        Set<CityBean> set = mLetterPos.keySet();
        Iterator<CityBean> it = set.iterator();
        CityBean city = null;
        while (it.hasNext()) {
            city = it.next();
            if (TextUtils.equals(city.getFirstLetter(), letter.toLowerCase())) {
                return mLetterPos.get(city);
            }
        }
        return -1;
    }
}
