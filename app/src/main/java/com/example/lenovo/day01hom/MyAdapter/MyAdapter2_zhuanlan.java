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
import com.example.lenovo.day01hom.bean.b_Zhihu2;

import java.util.List;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyAdapter2_zhuanlan extends RecyclerView.Adapter<MyAdapter2_zhuanlan.ViewHolder>{
    private List<b_Zhihu2.DataBean> data;
    private Context context;

    public void setData(List<b_Zhihu2.DataBean> data) {
        this.data = data;
    }

    public MyAdapter2_zhuanlan(List<b_Zhihu2.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhuihuo_zhuanlan, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.tv1.setText(data.get(position).getDescription());
         holder.tv2.setText(data.get(position).getName());
        Glide.with(context).load(data.get(position).getThumbnail()).placeholder(R.mipmap.ic_launcher).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;
        public ViewHolder(View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im2_zhuanlan);
            tv1=itemView.findViewById(R.id.tv1_zhuanlan);
            tv2=itemView.findViewById(R.id.tv2_zhuanlan);
        }
    }
}
