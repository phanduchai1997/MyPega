package com.atcb.mypega.viewholder;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.WebActivity;
import com.atcb.mypega.adapter.ItemNewsFeedDataAdapter;
import com.atcb.mypega.databinding.ItemType2LayoutBinding;
import com.atcb.mypega.model.Datum;
import com.atcb.mypega.onclick.OnItemAdapterClick;

import java.util.ArrayList;
import java.util.List;

public class Type2ViewHolder extends RecyclerView.ViewHolder implements OnItemAdapterClick {
    private ItemType2LayoutBinding binding;
    public ItemNewsFeedDataAdapter adapter;
    private List<Datum> mDataList;
    private GridLayoutManager layoutManager;

    public Type2ViewHolder(@NonNull ItemType2LayoutBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
        mDataList = new ArrayList<>();
        adapter = new ItemNewsFeedDataAdapter(mDataList, this);
        layoutManager = new GridLayoutManager(binding.getRoot().getContext(),2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position==0){
                    return 2;
                }
                else return 1;

            }
        });

        binding.rvItemType2.setLayoutManager(layoutManager);
        binding.rvItemType2.setAdapter(adapter);
    }

    @Override
    public void onClickItem(int posision) {
        Intent intent = new Intent(binding.getRoot().getContext(), WebActivity.class);
        intent.putExtra("url",mDataList.get(posision).getUrl());
        binding.getRoot().getContext().startActivity(intent);
    }

}
