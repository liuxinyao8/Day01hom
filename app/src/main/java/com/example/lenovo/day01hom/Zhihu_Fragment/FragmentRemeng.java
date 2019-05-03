package com.example.lenovo.day01hom.Zhihu_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter3_remeng;
import com.example.lenovo.day01hom.MyCall;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Zhihu3;

import java.lang.reflect.Array;
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
public class FragmentRemeng extends Fragment {


    private View view;
    private RecyclerView rvvv;
    private ArrayList<b_Zhihu3.RecentBean> recentBeans;
    private MyAdapter3_remeng remeng;

    public FragmentRemeng() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_remeng, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyCall.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<b_Zhihu3> data3 = retrofit.create(MyCall.class).getData3();
        data3.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_Zhihu3>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_Zhihu3 b_zhihu3) {
                        List<b_Zhihu3.RecentBean> recent = b_zhihu3.getRecent();
                        recentBeans.addAll(recent);
                        remeng.setRecent(recentBeans);
                        remeng.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("==",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rvvv = (RecyclerView) view.findViewById(R.id.rvvv);
        rvvv.setLayoutManager(new LinearLayoutManager(getActivity()));
        recentBeans = new ArrayList<>();
        remeng = new MyAdapter3_remeng(recentBeans, getActivity());
        rvvv.setAdapter(remeng);
    }
}
