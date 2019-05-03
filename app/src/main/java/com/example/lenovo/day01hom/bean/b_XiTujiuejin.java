package com.example.lenovo.day01hom.bean;

import java.util.List;

/**
 * Created by lenovo on 2019/5/3.
 */

public class b_XiTujiuejin {

    /**
     * count : 10
     * error : false
     * results : [{"desc":"搜索泡泡","ganhuo_id":"56cc6d22421aa95caa7078e5","publishedAt":"2015-09-28T04:00:17.830000","readability":"","type":"Android","url":"https://github.com/tunjos/SearchBubble","who":"mthli"},{"desc":"Material Design 风格的搜索效果","ganhuo_id":"5775c190421aa901fb9825ec","publishedAt":"2016-07-01T11:06:20.244000","readability":"","type":"Android","url":"https://github.com/Mauker1/MaterialSearchView","who":"代码家"},{"desc":"一个用 realm 做关键字搜索数据源的输入框。","ganhuo_id":"56cc6d26421aa95caa707e8b","publishedAt":"2015-11-19T03:57:22.175000","readability":"","type":"Android","url":"https://github.com/thorbenprimke/realm-searchview","who":"Ailurus"},{"desc":"一个搜索search的view","ganhuo_id":"56cc6d29421aa95caa708314","publishedAt":"2016-02-22T04:20:23.538000","readability":"","type":"Android","url":"https://github.com/lapism/SearchView","who":"有时放纵"},{"desc":"Material风格的搜索输入框","ganhuo_id":"56cc6d26421aa95caa707dac","publishedAt":"2015-10-09T04:54:34","readability":"","type":"Android","url":"https://github.com/TakeoffAndroid/MaterialDialogSearchView","who":"鲍永章"},{"desc":"Android 搜索过度效果","ganhuo_id":"57e08336421aa95bd05015e7","publishedAt":"2016-09-21T11:37:24.210000","readability":"","type":"Android","url":"https://github.com/alexstyl/Material-SearchTransition","who":"代码家"},{"desc":"支持搜索的spinner","ganhuo_id":"58f8b3b7421aa9544ed889a6","publishedAt":"2017-04-21T11:30:29.323000","readability":"","type":"Android","url":"https://github.com/miteshpithadiya/SearchableSpinner","who":"galois"},{"desc":"floatingsearchview 一个带搜索下拉列表提示的搜索控件","ganhuo_id":"56cc6d26421aa95caa707f1a","publishedAt":"2015-12-04T04:00:24.504000","readability":"","type":"Android","url":"https://github.com/arimorty/floatingsearchview","who":"wuzheng"},{"desc":"命令行快速搜索 maven 库。","ganhuo_id":"56cc6d1d421aa95caa70770e","publishedAt":"2015-07-17T03:43:22.623000","readability":"","type":"Android","url":"https://github.com/djyde/node-maven","who":"Randy"},{"desc":"Android超高仿QQ附近的人搜索展示","ganhuo_id":"572aae1067765974f885c009","publishedAt":"2016-05-05T12:14:21.156000","readability":"","type":"Android","url":"https://github.com/ImmortalZ/RadarScan","who":"Mr_immortalZ"}]
     */

    private int count;
    private boolean error;
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * desc : 搜索泡泡
         * ganhuo_id : 56cc6d22421aa95caa7078e5
         * publishedAt : 2015-09-28T04:00:17.830000
         * readability :
         * type : Android
         * url : https://github.com/tunjos/SearchBubble
         * who : mthli
         */

        private String desc;
        private String ganhuo_id;
        private String publishedAt;
        private String readability;
        private String type;
        private String url;
        private String who;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getGanhuo_id() {
            return ganhuo_id;
        }

        public void setGanhuo_id(String ganhuo_id) {
            this.ganhuo_id = ganhuo_id;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getReadability() {
            return readability;
        }

        public void setReadability(String readability) {
            this.readability = readability;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
