package com.atcb.mypega.model;


import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("news")
    @Expose
    private List<News> news = null;
    @SerializedName("boxId")
    @Expose
    private Integer boxId;
    @SerializedName("dspId")
    @Expose
    private String dspId;
    @SerializedName("algId")
    @Expose
    private String algId;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public String getDspId() {
        return dspId;
    }

    public void setDspId(String dspId) {
        this.dspId = dspId;
    }

    public String getAlgId() {
        return algId;
    }

    public void setAlgId(String algId) {
        this.algId = algId;
    }


}



