package com.atcb.mypega.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.R;
import com.atcb.mypega.databinding.ItemType5Binding;
import com.atcb.mypega.model.Datum;
import com.atcb.mypega.onclick.OnItemAdapterClick;

import java.util.Calendar;
import java.util.List;

public class ItemNewFeedType5Adapter extends RecyclerView.Adapter<ItemNewFeedType5Adapter.ViewHolder> {
    private List<Datum> mDatumList;
    private OnItemAdapterClick onClick;

    public ItemNewFeedType5Adapter(List<Datum> mDatumList, OnItemAdapterClick onClick) {
        this.mDatumList = mDatumList;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemType5Binding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_type5,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum data = mDatumList.get(position);
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
        return mDatumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemType5Binding binding;
        public ViewHolder(@NonNull ItemType5Binding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.cvItem5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onClickItem(getAdapterPosition());
                }
            });
        }
    }
    void setAdapter(List<Datum> list){

        mDatumList.clear();
        mDatumList.addAll(list);
        notifyDataSetChanged();
    }
}
