package com.atcb.mypega.viewholder;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.WebActivity;
import com.atcb.mypega.adapter.ItemNewsFeedDataAdapter;
import com.atcb.mypega.databinding.ItemType3LayoutBinding;
import com.atcb.mypega.model.Datum;
import com.atcb.mypega.onclick.OnItemAdapterClick;

import java.util.ArrayList;
import java.util.List;

public class Type3ViewHolder extends RecyclerView.ViewHolder implements OnItemAdapterClick {
    private List<Datum> mDataList;
    private ItemType3LayoutBinding binding;
    public ItemNewsFeedDataAdapter adapter;

    public Type3ViewHolder(@NonNull ItemType3LayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
        init();
    }

    private void init() {
        mDataList = new ArrayList<>();
        adapter = new ItemNewsFeedDataAdapter(mDataList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(binding.getRoot().getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rvItemType3.setLayoutManager(layoutManager);
        binding.rvItemType3.setAdapter(adapter);
    }


    @Override
    public void onClickItem(int posision) {
        Intent intent = new Intent(binding.getRoot().getContext(), WebActivity.class);
        intent.putExtra("url", mDataList.get(posision).getUrl());
        binding.getRoot().getContext().startActivity(intent);
    }

}
  