package com.example.lenovo.day01hom.bean;

import java.util.List;

/**
 * Created by lenovo on 2019/5/2.
 */

public class b_Zhuihu1 {
    /**
     * date : 20190430
     * stories : [{"images":["https://pic3.zhimg.com/v2-416b2c293c42953bc63d96c50b6b9c7e.jpg"],"type":0,"id":9710744,"ga_prefix":"043009","title":"什么样的行为被称为「职业化」，如何做到「职业化」？"},{"title":"迄今为止你见过最惊艳的建筑是哪个？","ga_prefix":"043008","images":["https://pic3.zhimg.com/v2-7a516b937e2d033a2700c62c632b0c12.jpg"],"multipic":true,"type":0,"id":9710786},{"images":["https://pic2.zhimg.com/v2-8ab91ab24e160bed54a31195f6e8271d.jpg"],"type":0,"id":9710734,"ga_prefix":"043007","title":"无叶电风扇是怎么吹出来风的？"},{"images":["https://pic2.zhimg.com/v2-242b95ff6d31fc5e5958993d2eea3c15.jpg"],"type":0,"id":9710760,"ga_prefix":"043006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-66e3354dec06315d47299d0bf6a8ff7f.jpg","type":0,"id":9710786,"ga_prefix":"043008","title":"迄今为止你见过最惊艳的建筑是哪个？"},{"image":"https://pic2.zhimg.com/v2-0a077825bb0e2b3584ffaf1dc9c68465.jpg","type":0,"id":9710774,"ga_prefix":"042908","title":"呃\u2026\u2026漫威和 DC 的这些角色也太像了吧"},{"image":"https://pic2.zhimg.com/v2-5446dd9cea49630ddc0e193a524df669.jpg","type":0,"id":9710732,"ga_prefix":"042907","title":"漫威是否会毁了电影艺术？"},{"image":"https://pic3.zhimg.com/v2-45d4abb765fbbff50aa88f8c92825376.jpg","type":0,"id":9710722,"ga_prefix":"042909","title":"那些没能回来的小燕子，可能已经变成了烧烤"},{"image":"https://pic3.zhimg.com/v2-b2e840e59970184a8bbe02a92954678e.jpg","type":0,"id":9710628,"ga_prefix":"042707","title":"如果突然穿越到恐龙时代，最适合在哪里寿终正寝？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic3.zhimg.com/v2-416b2c293c42953bc63d96c50b6b9c7e.jpg"]
         * type : 0
         * id : 9710744
         * ga_prefix : 043009
         * title : 什么样的行为被称为「职业化」，如何做到「职业化」？
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-66e3354dec06315d47299d0bf6a8ff7f.jpg
         * type : 0
         * id : 9710786
         * ga_prefix : 043008
         * title : 迄今为止你见过最惊艳的建筑是哪个？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
