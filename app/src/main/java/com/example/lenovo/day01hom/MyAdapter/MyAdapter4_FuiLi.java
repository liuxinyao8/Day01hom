package com.example.lenovo.day01hom.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Ganhuo4;

import java.util.List;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyAdapter4_FuiLi extends RecyclerView.Adapter<MyAdapter4_FuiLi.ViewHolder>{
    private List<b_Ganhuo4.ResultsBean> results;
    private Context context;

    public void setResults(List<b_Ganhuo4.ResultsBean> results) {
        this.results = results;
    }

    public MyAdapter4_FuiLi(List<b_Ganhuo4.ResultsBean> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ganhuo_fuli, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(results.get(position).getUrl()).placeholder(R.mipmap.ic_launcher_round)
                .into(holder.im);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        public ViewHolder(View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im_Fuli);
        }
    }
}
