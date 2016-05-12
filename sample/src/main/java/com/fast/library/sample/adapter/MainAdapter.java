package com.fast.library.sample.adapter;

import android.support.v7.widget.RecyclerView;

import com.fast.library.Adapter.recyclerview.BaseRecyclerAdapter;
import com.fast.library.Adapter.recyclerview.RecyclerViewHolder;
import com.fast.library.sample.R;

import java.util.List;

/**
 * 说明：MainAdapter
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 21:28
 * <p/>
 * 版本：verson 1.0
 */
public class MainAdapter extends BaseRecyclerAdapter<String>{

    public MainAdapter(RecyclerView recyclerView, List<String> data) {
        super(recyclerView, data);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_main;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void convert(RecyclerViewHolder holder, String item, int position) {
        holder.setText(R.id.tv_des,item);
    }
}
