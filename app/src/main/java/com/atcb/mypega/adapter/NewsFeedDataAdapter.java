package com.atcb.mypega.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.R;
import com.atcb.mypega.databinding.ItemType1LayoutBinding;
import com.atcb.mypega.databinding.ItemType2LayoutBinding;
import com.atcb.mypega.databinding.ItemType3LayoutBinding;
import com.atcb.mypega.databinding.ItemType4LayoutBinding;
import com.atcb.mypega.databinding.ItemType5LayoutBinding;
import com.atcb.mypega.databinding.LayoutLoadMoreBinding;
import com.atcb.mypega.model.Datum;
import com.atcb.mypega.model.News;
import com.atcb.mypega.onclick.OnItemAdapterClick;
import com.atcb.mypega.viewholder.LoadMoreViewHolder;
import com.atcb.mypega.viewholder.Type1ViewHolder;
import com.atcb.mypega.viewholder.Type2ViewHolder;
import com.atcb.mypega.viewholder.Type3ViewHolder;
import com.atcb.mypega.viewholder.Type4ViewHolder;
import com.atcb.mypega.viewholder.Type5ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedDataAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<News> mNewsList;
    private OnItemAdapterClick mOnClick;

    public NewsFeedDataAdapter(Context mContext, List<News> mNews, OnItemAdapterClick mOnClick) {
        this.mContext = mContext;
        this.mNewsList = mNews;
        this.mOnClick = mOnClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                ItemType1LayoutBinding binding1 = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_type1_layout, parent, false);
                return new Type1ViewHolder(binding1);
            case 2:
                ItemType2LayoutBinding binding2 = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_type2_layout, parent, false);
                return new Type2ViewHolder(binding2);
            case 3:
                ItemType3LayoutBinding binding3 = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_type3_layout, parent, false);
                return new Type3ViewHolder(binding3);
            case 4:
                ItemType4LayoutBinding binding4 = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_type4_layout, parent, false);
                return new Type4ViewHolder(binding4);

        }
        ItemType5LayoutBinding binding5 = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_type5_layout, parent, false);
        return new Type5ViewHolder(binding5);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = 1;
        type = mNewsList.get(position).getType();
        List<Datum> datumList = new ArrayList<>();
        datumList.clear();
        List<Datum> list = mNewsList.get(position).getData();
        if(list!= null)
        datumList.addAll(list);
        switch (type) {
            case 1:
                ((Type1ViewHolder) holder).adapter.setAdapter(datumList);
                break;
            case 2:
                ((Type2ViewHolder) holder).adapter.setAdapter(datumList);
                break;
            case 3:
                ((Type3ViewHolder) holder).adapter.setAdapter(datumList);
                break;
            case 4:
                ((Type4ViewHolder) holder).adapter.setAdapter(datumList);
                break;
            case 5:
                ((Type5ViewHolder) holder).adapter.setAdapter(datumList);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type = 1;
        if(mNewsList != null) {
            if (mNewsList.get(position) != null) {
                type = mNewsList.get(position).getType();
            }
        }
        switch (type) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
        }
        return -1;
    }
}
