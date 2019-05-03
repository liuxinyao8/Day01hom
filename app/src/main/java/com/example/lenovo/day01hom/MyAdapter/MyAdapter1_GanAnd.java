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
import com.example.lenovo.day01hom.bean.b_Ganhuo;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyAdapter1_GanAnd extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<b_Ganhuo.ResultsBean> results;
    private Context context;

    public void setResults(List<b_Ganhuo.ResultsBean> results) {
        this.results = results;
    }

    public MyAdapter1_GanAnd(List<b_Ganhuo.ResultsBean> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.ganabd_ban, null);
            ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.ganhuo_android, null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==0){
            ViewHolder1 holder1=(ViewHolder1)holder;
            holder1.banner.setImages(results).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(results.get(position).getImages().toString()).placeholder(R.mipmap.ic_launcher_round).into(imageView);
                }
            }).start();
        }else {
            ViewHolder2 holder2=(ViewHolder2)holder;
            holder2.tv1.setText(results.get(position).getDesc());
            holder2.tv2.setText(results.get(position).getWho());
            holder2.tv3.setText(results.get(position).getPublishedAt());
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
        private Banner banner;
        public ViewHolder1(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.gan_myban);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public ViewHolder2(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1_GanAnd);
            tv2=itemView.findViewById(R.id.tv2_ganAnd);
            tv3=itemView.findViewById(R.id.tv3_ganAnd);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (results.size()>0&&position==0){
            return 0;
        }else{
            return 1;
        }
    }
}
