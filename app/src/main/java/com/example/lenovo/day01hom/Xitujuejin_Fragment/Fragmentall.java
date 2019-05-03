package com.example.lenovo.day01hom.Xitujuejin_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter1_Xitu;
import com.example.lenovo.day01hom.MyCall_Ganhuo;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_XiTujiuejin;

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
public class Fragmentall extends Fragment {


    private View view;
    private RecyclerView rv4;
    private ArrayList<b_XiTujiuejin.ResultsBean> resultsBeans;
    private MyAdapter1_Xitu xitu;

    public Fragmentall() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentall, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyCall_Ganhuo.URL2)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<b_XiTujiuejin> datax = retrofit.create(MyCall_Ganhuo.class).getDatax();
        datax.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_XiTujiuejin>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_XiTujiuejin b_xiTujiuejin) {
                        List<b_XiTujiuejin.ResultsBean> results = b_xiTujiuejin.getResults();
                        resultsBeans.addAll(results);
                        xitu.setResults(resultsBeans);
                        xitu.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("------==-==-", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rv4 = (RecyclerView) view.findViewById(R.id.rv4);
        resultsBeans = new ArrayList<>();
        rv4.setLayoutManager(new LinearLayoutManager(getActivity()));
        xitu = new MyAdapter1_Xitu(resultsBeans, getActivity());
        rv4.setAdapter(xitu);

    }
}
