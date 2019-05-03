package com.example.lenovo.day01hom.Zhihu_Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter2_zhuanlan;
import com.example.lenovo.day01hom.MyCall;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Zhihu2;

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

public class FragmentZhuanlan extends Fragment {

    private View view;
    private RecyclerView rvv;
    private ArrayList<b_Zhihu2.DataBean> dataBeans;
    private MyAdapter2_zhuanlan zhuanlan;

    public FragmentZhuanlan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_zhuanlan, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyCall.URL)
                .build();
        Observable<b_Zhihu2> data2 = retrofit.create(MyCall.class).getData2();
        data2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_Zhihu2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_Zhihu2 b_zhihu2) {
                        List<b_Zhihu2.DataBean> data = b_zhihu2.getData();
                        dataBeans.addAll(data);
                        zhuanlan.setData(dataBeans);
                        zhuanlan.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("000",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rvv = (RecyclerView) view.findViewById(R.id.rvv);
        rvv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        dataBeans = new ArrayList<>();
        zhuanlan = new MyAdapter2_zhuanlan(dataBeans, getActivity());
        rvv.setAdapter(zhuanlan);
    }
}
