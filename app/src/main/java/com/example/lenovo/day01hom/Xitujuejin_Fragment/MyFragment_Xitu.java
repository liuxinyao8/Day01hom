package com.example.lenovo.day01hom.Xitujuejin_Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyFragment_Xitu extends FragmentStatePagerAdapter{
    private ArrayList<Fragment>list;

    public MyFragment_Xitu(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
