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
import com.example.lenovo.day01hom.bean.b_Weixing;

import java.util.List;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyAdapter1_WeiXing extends RecyclerView.Adapter<MyAdapter1_WeiXing.ViewHolder> {
    private List<b_Weixing.NewslistBean> newslist;
    private Context context;

    public void setNewslist(List<b_Weixing.NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public MyAdapter1_WeiXing(List<b_Weixing.NewslistBean> newslist, Context context) {
        this.newslist = newslist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weixin, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv1.setText(newslist.get(position).getTitle());
        holder.tv2.setText(newslist.get(position).getCtime());
        Glide.with(context).load(newslist.get(position).getPicUrl()).placeholder(R.mipmap.ic_launcher_round).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return newslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im_Weixing);
            tv1 = itemView.findViewById(R.id.tv1_Weixing);
            tv2 = itemView.findViewById(R.id.tv2_Weixing);
        }
    }
}
