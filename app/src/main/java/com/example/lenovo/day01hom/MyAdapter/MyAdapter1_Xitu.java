package com.example.lenovo.day01hom.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.day01hom.R;
import com.example.lenovo.day01hom.bean.b_XiTujiuejin;

import java.util.List;

/**
 * Created by lenovo on 2019/5/3.
 */

public class MyAdapter1_Xitu extends RecyclerView.Adapter<MyAdapter1_Xitu.ViewHolder>{
    private List<b_XiTujiuejin.ResultsBean> results;
    private Context context;

    public void setResults(List<b_XiTujiuejin.ResultsBean> results) {
        this.results = results;
    }

    public MyAdapter1_Xitu(List<b_XiTujiuejin.ResultsBean> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.xiutu_all, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.tv1.setText(results.get(position).getDesc());
holder.tv2.setText(results.get(position).getWho());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1_xitu);
            tv2=itemView.findViewById(R.id.tv2_xitu);
        }
    }
}
