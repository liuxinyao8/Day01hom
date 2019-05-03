package com.example.lenovo.day01hom.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.Xitujuejin_Fragment.Fragmentall;
import com.example.lenovo.day01hom.Xitujuejin_Fragment.Fragmentqianduan;
import com.example.lenovo.day01hom.Xitujuejin_Fragment.Fragmentsxsp;
import com.example.lenovo.day01hom.Xitujuejin_Fragment.MyFragment_Xitu;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentxitu4 extends Fragment {


    private View view;
    private TabLayout tabb;
    private ViewPager vvp;
    private ArrayList<Fragment> fragments;
    private MyFragment_Xitu xitu;

    public Fragmentxitu4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentxitu4, container, false);
        initView(view);
        fragments = new ArrayList<>();
        fragments.add(new Fragmentall());
        fragments.add(new Fragmentsxsp());
        fragments.add(new Fragmentqianduan());
        xitu = new MyFragment_Xitu(getChildFragmentManager(), fragments);
        vvp.setAdapter(xitu);
        tabb.addTab(tabb.newTab().setText("All"));
        tabb.addTab(tabb.newTab().setText("休息视频"));
        tabb.addTab(tabb.newTab().setText("前端"));
        return view;
    }

    private void initView(View view) {
        tabb = (TabLayout) view.findViewById(R.id.tabb);
        vvp = (ViewPager) view.findViewById(R.id.vvp);
        tabb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vvp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vvp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabb));
    }
}
