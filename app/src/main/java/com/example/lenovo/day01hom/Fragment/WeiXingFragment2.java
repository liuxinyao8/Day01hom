package com.example.lenovo.day01hom.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter1_WeiXing;
import com.example.lenovo.day01hom.MyCall;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Weixing;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeiXingFragment2 extends Fragment {


    private View view;
    private RecyclerView rv2;
    private ArrayList<b_Weixing.NewslistBean> newslistBeans;
    private MyAdapter1_WeiXing weiXing;


    public WeiXingFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wei_xing_fragment2, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyCall.URL2)
                .build();
        Observable<b_Weixing> data4 = retrofit.create(MyCall.class)
                .getData4();
        data4.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_Weixing>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_Weixing b_weixing) {
                        List<b_Weixing.NewslistBean> newslist = b_weixing.getNewslist();
                        newslistBeans.addAll(newslist);
                        weiXing.setNewslist(newslistBeans);
                        weiXing.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("----",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rv2 = (RecyclerView) view.findViewById(R.id.rv2);
        newslistBeans = new ArrayList<>();
        rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        weiXing = new MyAdapter1_WeiXing(newslistBeans, getActivity());
        rv2.setAdapter(weiXing);
    }

}
