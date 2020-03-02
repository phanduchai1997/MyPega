package com.atcb.mypega.api;

import com.atcb.mypega.model.Data;
import com.atcb.mypega.model.DataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("/api/v2/news/recommend")
    Call<DataResponse> getData(@Query("domain") String domain, @Query("box_id") int boxId, @Query("uid") int Uid, @Query("deviceid") int device);
}
