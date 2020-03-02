package com.atcb.mypega.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataApi {
    public static Retrofit mRetrofit;
    public static Service getService(){
        return getmRetrofit().create(Service.class);
    }
    public static Retrofit getmRetrofit(){
        if(mRetrofit==null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://nspapi.aiservice.vn")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

}
