package com.atcb.mypega.viewholder;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.WebActivity;
import com.atcb.mypega.adapter.ItemNewFeedType5Adapter;
import com.atcb.mypega.databinding.ItemType5LayoutBinding;
import com.atcb.mypega.model.Datum;
import com.atcb.mypega.onclick.OnItemAdapterClick;

import java.util.ArrayList;
import java.util.List;

public class Type5ViewHolder extends RecyclerView.ViewHolder implements OnItemAdapterClick {
    private List<Datum> mDataList;
    public ItemNewFeedType5Adapter adapter;

        public ItemType5LayoutBinding binding;
        public Type5ViewHolder(@NonNull ItemType5LayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            init();
        }

    private void init() {
            mDataList = new ArrayList<>();
            adapter = new ItemNewFeedType5Adapter(mDataList,this);
            binding.rvItemType5.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
            binding.rvItemType5.setAdapter(adapter);
    }
    @Override
    public void onClickItem(int posision) {
        Intent intent = new Intent(binding.getRoot().getContext(), WebActivity.class);
        intent.putExtra("url", mDataList.get(posision).getUrl());
        binding.getRoot().getContext().startActivity(intent);
    }

}