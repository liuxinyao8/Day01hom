package com.example.lenovo.day01hom.Ganhuo_Fragmnet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter2_IOS;
import com.example.lenovo.day01hom.MyCall_Ganhuo;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Ganhuo2;

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
public class Fragmentios extends Fragment {


    private View view;
    private RecyclerView rvv3;
    private ArrayList<b_Ganhuo2.ResultsBean> beans;
    private MyAdapter2_IOS ios;

    public Fragmentios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentios, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyCall_Ganhuo.URL1).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<b_Ganhuo2> daatag2 = retrofit.create(MyCall_Ganhuo.class)
                .getDaatag2();
        daatag2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_Ganhuo2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_Ganhuo2 b_ganhuo2) {
                        List<b_Ganhuo2.ResultsBean> results = b_ganhuo2.getResults();
                        beans.addAll(results);
                        ios.setResults(beans);
                        ios.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("=-=-=-",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rvv3 = (RecyclerView) view.findViewById(R.id.rvv3);
        rvv3.setLayoutManager(new LinearLayoutManager(getActivity()));
        beans = new ArrayList<>();
        ios = new MyAdapter2_IOS(beans, getActivity());
        rvv3.setAdapter(ios);
    }
}
