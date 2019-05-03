package com.example.lenovo.day01hom.Ganhuo_Fragmnet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lenovo.day01hom.MyAdapter.MyAdapter4_FuiLi;
import com.example.lenovo.day01hom.MyCall_Ganhuo;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Ganhuo4;

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
public class Fragmentfuli4 extends Fragment {


    private View view;
    private RecyclerView rvvv3;
    private ArrayList<b_Ganhuo4.ResultsBean> beanArrayList;
    private MyAdapter4_FuiLi fuiLi;

    public Fragmentfuli4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentfuli4, container, false);
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
        Observable<b_Ganhuo4> datag4 = retrofit.create(MyCall_Ganhuo.class)
                .getDatag4();
        datag4.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<b_Ganhuo4>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(b_Ganhuo4 b_ganhuo4) {
                        List<b_Ganhuo4.ResultsBean> results = b_ganhuo4.getResults();
                        beanArrayList.addAll(results);
                        fuiLi.setResults(beanArrayList);
                        fuiLi.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("..,.,.,.,.",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rvvv3 = (RecyclerView) view.findViewById(R.id.rvvv3);
        rvvv3.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        beanArrayList = new ArrayList<>();
        fuiLi = new MyAdapter4_FuiLi(beanArrayList, getActivity());
         rvvv3.setAdapter(fuiLi);
    }
}
