package com.example.lenovo.day01hom.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_Ganhuo2;

import java.util.List;

/**
 * Created by lenovo on 2019/5/2.
 */

public class MyAdapter2_IOS extends RecyclerView.Adapter<MyAdapter2_IOS.ViewHolder>{
    private List<b_Ganhuo2.ResultsBean> results;
private Context context;

    public void setResults(List<b_Ganhuo2.ResultsBean> results) {
        this.results = results;
    }

    public MyAdapter2_IOS(List<b_Ganhuo2.ResultsBean> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter2_IOS.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ganhuo_android, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2_IOS.ViewHolder holder, int position) {
holder.tv1.setText(results.get(position).getDesc());
holder.tv2.setText(results.get(position).getWho());
holder.tv3.setText(results.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1_GanAnd);
            tv2=itemView.findViewById(R.id.tv2_ganAnd);
            tv3=itemView.findViewById(R.id.tv3_ganAnd);
        }
    }
}
