package com.example.lenovo.day01hom.Ganhuo_Fragmnet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter1_GanAnd;
import com.example.lenovo.day01hom.MyCall_Ganhuo;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Ganhuo;

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
public class Fragmentandroid1 extends Fragment {


    private View view;
    private RecyclerView rv3;
    private ArrayList<b_Ganhuo.ResultsBean> resultsBeans;
    private MyAdapter1_GanAnd ganAnd;

    public Fragmentandroid1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentandroid1, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyCall_Ganhuo.URL1)
                .build();
        Observable<b_Ganhuo> datag1 = retrofit.create(MyCall_Ganhuo.class).getDatag1();
        datag1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_Ganhuo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_Ganhuo b_ganhuo) {
                        List<b_Ganhuo.ResultsBean> results = b_ganhuo.getResults();
                        resultsBeans.addAll(results);
                        ganAnd.setResults(resultsBeans);
                        ganAnd.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(".-.-.-.",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rv3 = (RecyclerView) view.findViewById(R.id.rv3);
        rv3.setLayoutManager(new LinearLayoutManager(getActivity()));
        resultsBeans = new ArrayList<>();
        ganAnd = new MyAdapter1_GanAnd(resultsBeans, getActivity());
        rv3.setAdapter(ganAnd);
    }
}
