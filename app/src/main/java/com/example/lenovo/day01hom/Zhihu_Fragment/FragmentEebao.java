package com.example.lenovo.day01hom.Zhihu_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter1_Zhihu;
import com.example.lenovo.day01hom.MyCall;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Zhuihu1;

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
public class FragmentEebao extends Fragment {


    private View view;
    private RecyclerView rv1;
    private ArrayList<b_Zhuihu1.TopStoriesBean> topStoriesBeans;
    private ArrayList<b_Zhuihu1.StoriesBean> storiesBeans;
    private MyAdapter1_Zhihu adapter1_zhihu;

    public FragmentEebao() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragment_eebao, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyCall.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<b_Zhuihu1> data1 = retrofit.create(MyCall.class).getData1();
        data1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_Zhuihu1>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_Zhuihu1 b_zhuihu1) {
                       if (b_zhuihu1!=null){
                           List<b_Zhuihu1.TopStoriesBean> top_stories = b_zhuihu1.getTop_stories();
                           topStoriesBeans.addAll(top_stories);
                            adapter1_zhihu.setTop_stories(topStoriesBeans);
                            adapter1_zhihu.notifyDataSetChanged();

                           List<b_Zhuihu1.StoriesBean> stories = b_zhuihu1.getStories();
                           storiesBeans.addAll(stories);
                           adapter1_zhihu.setStories(storiesBeans);
                           adapter1_zhihu.notifyDataSetChanged();
                       }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("===",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        rv1 = (RecyclerView) inflate.findViewById(R.id.rv1);
        topStoriesBeans = new ArrayList<>();
        storiesBeans = new ArrayList<>();
        rv1.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter1_zhihu = new MyAdapter1_Zhihu(storiesBeans, topStoriesBeans, getActivity());
        rv1.setAdapter(adapter1_zhihu);
    }
}
