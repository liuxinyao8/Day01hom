package com.example.lenovo.day01hom;

import com.example.lenovo.day01hom.bean.b_Weixing;
import com.example.lenovo.day01hom.bean.b_Zhihu2;
import com.example.lenovo.day01hom.bean.b_Zhihu3;
import com.example.lenovo.day01hom.bean.b_Zhuihu1;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2019/5/2.
 */

public interface MyCall {
    String URL="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<b_Zhuihu1> getData1();
    @GET("sections ")
    Observable<b_Zhihu2> getData2();
    @GET("news/hot")
    Observable<b_Zhihu3>getData3();

    String URL2="http://api.tianapi.com/wxnew/";
    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<b_Weixing> getData4();

}
