package com.example.lenovo.day01hom.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Zhuihu1;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyAdapter1_Zhihu extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<b_Zhuihu1.StoriesBean> stories;
    private List<b_Zhuihu1.TopStoriesBean> top_stories;
    private Context context;

    public void setTop_stories(List<b_Zhuihu1.TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public void setStories(List<b_Zhuihu1.StoriesBean> stories) {
        this.stories = stories;
    }

    public MyAdapter1_Zhihu(List<b_Zhuihu1.StoriesBean> stories, List<b_Zhuihu1.TopStoriesBean> top_stories, Context context) {
        this.stories = stories;
        this.top_stories = top_stories;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item1, null);
            ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        }else if (viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.zhihu_item1, null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.zhihui_item2, null);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        }

}

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==0){
            ViewHolder1 holder1=(ViewHolder1)holder;
            holder1.banner.setImages(top_stories).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    b_Zhuihu1.TopStoriesBean bean=(b_Zhuihu1.TopStoriesBean)path;
                    Glide.with(context).load(bean.getImage().toString()).placeholder(R.mipmap.ic_launcher_round).into(imageView);
                }
            }).start();
        }else if (itemViewType==1){
            if (top_stories!=null) {
                ViewHolder2 holder2 = (ViewHolder2) holder;
                holder2.tv.setText("20190430");
            }
        }else {
            ViewHolder3 holder3 = (ViewHolder3) holder;
            int a;
            if (top_stories.size()>0){
                a=position-2;
            }else {
                a=position-1;
            }
            holder3.tv2.setText(stories.get(a).getTitle());
            Glide.with(context).load(stories.get(a).getImages().toString())
                    .placeholder(R.mipmap.ic_launcher).into(holder3.im);
        }
    }

    @Override
    public int getItemCount() {
        if(top_stories.size()>0){
            return stories.size()+2;
        }else {
            return stories.size()+1;
        }
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
        private Banner banner;
        public ViewHolder1(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.Myban);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        private TextView tv;
        public ViewHolder2(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv1_Zhihu);
        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder{
        private ImageView im;
        private TextView tv2;
        public ViewHolder3(View itemView) {
            super(itemView);
           im=itemView.findViewById(R.id.im1_zhihu);
           tv2=itemView.findViewById(R.id.tv2_zhihu);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (top_stories!=null&&position==0){
            return 0;
        }else if (top_stories!=null&&position==1){
         return 1;
        }else {
            if (position==0){
                return 1;
            }else {
                return 2;
            }
        }

    }
}
