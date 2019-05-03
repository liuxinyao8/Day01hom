package com.example.lenovo.day01hom.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.Ganhuo_Fragmnet.Fragmentandroid1;
import com.example.lenovo.day01hom.Ganhuo_Fragmnet.Fragmentfuli4;
import com.example.lenovo.day01hom.Ganhuo_Fragmnet.Fragmentios;
import com.example.lenovo.day01hom.Ganhuo_Fragmnet.Fragmentqianduan;
import com.example.lenovo.day01hom.Ganhuo_Fragmnet.MyFragment_Ganhuo;
import com.example.lenovo.day01hom.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentgan3 extends Fragment {


    private View view;
    private TabLayout taab;
    private ViewPager vpp;
    private ArrayList<Fragment> fragmentArrayList;
    private MyFragment_Ganhuo ganhuo;

    public Fragmentgan3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentgan3, container, false);
        initView(view);
        taab.addTab(taab.newTab().setText("Android"));
        taab.addTab(taab.newTab().setText("iOS"));
        taab.addTab(taab.newTab().setText("前端"));
        taab.addTab(taab.newTab().setText("福利"));
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new Fragmentandroid1());
        fragmentArrayList.add(new Fragmentios());
        fragmentArrayList.add(new Fragmentqianduan());
        fragmentArrayList.add(new Fragmentfuli4());
        ganhuo = new MyFragment_Ganhuo(getChildFragmentManager(), fragmentArrayList);
        vpp.setAdapter(ganhuo);
        return view;
    }

    private void initView(View view) {
        taab = (TabLayout) view.findViewById(R.id.taab);
        vpp = (ViewPager) view.findViewById(R.id.vpp);
        taab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vpp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(taab));
    }
}
