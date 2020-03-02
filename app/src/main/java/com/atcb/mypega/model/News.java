package com.atcb.mypega.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("boxId")
    @Expose
    private Integer boxId;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("algId")
    @Expose
    private String algId;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public int getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAlgId() {
        return algId;
    }

    public void setAlgId(String algId) {
        this.algId = algId;
    }


}
