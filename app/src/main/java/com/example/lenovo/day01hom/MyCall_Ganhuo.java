package com.example.lenovo.day01hom;

import com.example.lenovo.day01hom.bean.b_Ganhuo;
import com.example.lenovo.day01hom.bean.b_Ganhuo2;
import com.example.lenovo.day01hom.bean.b_Ganhuo4;
import com.example.lenovo.day01hom.bean.b_XiTujiuejin;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2019/5/2.
 */

public interface MyCall_Ganhuo {
    String URL1="http://gank.io/api/data/";
    @GET("Android/10/1")
    Observable<b_Ganhuo> getDatag1();
    @GET("iOS/10/1")
    Observable<b_Ganhuo2>getDaatag2();
    @GET("福利/10/1")
    Observable<b_Ganhuo4> getDatag4();


    String URL2="http://gank.io/api/search/query/%7B搜索字段%7D/category/";
     @GET("Android/count/10/page/1")
    Observable<b_XiTujiuejin> getDatax();
}
