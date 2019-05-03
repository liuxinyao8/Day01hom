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
import com.example.lenovo.day01hom.bean.b_Zhihu3;

import java.util.List;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyAdapter3_remeng extends RecyclerView.Adapter<MyAdapter3_remeng.ViewHolder> {
    private List<b_Zhihu3.RecentBean> recent;
    private Context context;

    public void setRecent(List<b_Zhihu3.RecentBean> recent) {
        this.recent = recent;
    }

    public MyAdapter3_remeng(List<b_Zhihu3.RecentBean> recent, Context context) {
        this.recent = recent;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhihu_remeng, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(recent.get(position).getTitle());
        Glide.with(context).load(recent.get(position).getThumbnail()).placeholder(R.mipmap.ic_launcher_round).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return recent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im1_remeng);
            tv = itemView.findViewById(R.id.tv2_remeng);
        }
    }
}
