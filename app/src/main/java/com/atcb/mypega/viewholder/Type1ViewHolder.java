package com.atcb.mypega.viewholder;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.WebActivity;
import com.atcb.mypega.adapter.ItemNewsFeedDataAdapter;
import com.atcb.mypega.databinding.ItemType1LayoutBinding;
import com.atcb.mypega.model.Datum;
import com.atcb.mypega.onclick.OnItemAdapterClick;

import java.util.ArrayList;
import java.util.List;

public class Type1ViewHolder extends RecyclerView.ViewHolder implements OnItemAdapterClick {
        public ItemType1LayoutBinding binding ;
        private List<Datum> mDataList;
        public ItemNewsFeedDataAdapter adapter;

        public Type1ViewHolder(@NonNull ItemType1LayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            init();
        }

    private void init() {
            mDataList = new ArrayList<>();
            adapter = new ItemNewsFeedDataAdapter(mDataList, this);
            binding.rvItemType1.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
            binding.rvItemType1.setAdapter(adapter);
    }

    @Override
    public void onClickItem(int posision) {
        Intent intent = new Intent(binding.getRoot().getContext(), WebActivity.class);
        intent.putExtra("url", mDataList.get(posision).getUrl());
        binding.getRoot().getContext().startActivity(intent);
    }

}