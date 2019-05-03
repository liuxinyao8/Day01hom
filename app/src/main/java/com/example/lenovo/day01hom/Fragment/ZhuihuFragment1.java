package com.example.lenovo.day01hom.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.Zhihu_Fragment.FragmentEebao;
import com.example.lenovo.day01hom.Zhihu_Fragment.FragmentRemeng;
import com.example.lenovo.day01hom.Zhihu_Fragment.FragmentZhuanlan;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuihuFragment1 extends Fragment {


    private View view;
    private TabLayout taa;
    private ViewPager vp;
    private ArrayList<Fragment> arrayList;
    private MyFragment_Zhihu zhihu;

    public ZhuihuFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhuihu_fragment1, container, false);
        initView(view);
        arrayList = new ArrayList<>();
        arrayList.add(new FragmentEebao());
        arrayList.add(new FragmentZhuanlan());
        arrayList.add(new FragmentRemeng());
        zhihu = new MyFragment_Zhihu(getActivity().getSupportFragmentManager(), arrayList);
        vp.setAdapter(zhihu);
        taa.addTab(taa.newTab().setText("日报"));
        taa.addTab(taa.newTab().setText("专栏"));
        taa.addTab(taa.newTab().setText("热门"));
        return view;
    }


    private void initView(View view) {
        taa = (TabLayout) view.findViewById(R.id.taa);
        vp = (ViewPager) view.findViewById(R.id.vp);
        taa.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(taa));
    }
}
