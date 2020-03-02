package com.atcb.mypega.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atcb.mypega.databinding.LayoutLoadMoreBinding;

public class LoadMoreViewHolder extends RecyclerView.ViewHolder {
    public LayoutLoadMoreBinding binding;
    public LoadMoreViewHolder(@NonNull LayoutLoadMoreBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}
