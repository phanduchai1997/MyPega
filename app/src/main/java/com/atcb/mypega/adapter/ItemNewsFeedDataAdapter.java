package com.atcb.mypega.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.R;
import com.atcb.mypega.databinding.ItemLayoutBinding;
import com.atcb.mypega.model.Datum;
import com.atcb.mypega.onclick.OnItemAdapterClick;

import java.util.Calendar;
import java.util.List;

public class ItemNewsFeedDataAdapter extends RecyclerView.Adapter<ItemNewsFeedDataAdapter.ViewHolder> {

    private List<Datum> mDataList;
    private OnItemAdapterClick mOnClick;

    public ItemNewsFeedDataAdapter(List<Datum> mDataList, OnItemAdapterClick mOnClick) {
        this.mDataList = mDataList;
        this.mOnClick = mOnClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding layoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout, parent, false);
        return new ViewHolder(layoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum data = mDataList.get(position);
        long hour;
        long minute;
        long second;
        long day;
        Calendar calendar = Calendar.getInstance();
        day = ((calendar.getTimeInMillis()/1000)-data.getPublishDate())/(3600*24);
        hour = ((calendar.getTimeInMillis()/1000)-data.getPublishDate())/3600;
        minute = ((calendar.getTimeInMillis()/1000)-data.getPublishDate())/60;
        second = ((calendar.getTimeInMillis()/1000)-data.getPublishDate());
        if(day!=0){
            data.setTime(""+day+" ngày trước");
        }
        else if(hour!=0){
            data.setTime(""+hour+" giờ trước");
        }
        else if(minute!=0){
            data.setTime(""+minute+" phút trước");
        }
        else data.setTime(""+second+" giây trước");
        holder.binding.setData(data);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
    void setAdapter(List<Datum> list){

        mDataList.clear();
        mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemLayoutBinding binding;

        public ViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.itemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClick.onClickItem(getAdapterPosition());
                }
            });
        }
    }
}
