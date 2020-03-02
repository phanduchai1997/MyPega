package com.atcb.mypega.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.atcb.mypega.R;
import com.atcb.mypega.adapter.NewsFeedDataAdapter;
import com.atcb.mypega.api.DataApi;
import com.atcb.mypega.databinding.DialogCustomLayoutBinding;
import com.atcb.mypega.databinding.FragmentNewsFeedBinding;
import com.atcb.mypega.model.Data;
import com.atcb.mypega.model.DataResponse;
import com.atcb.mypega.model.News;
import com.atcb.mypega.onclick.OnItemAdapterClick;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewFeedFragment extends Fragment implements OnItemAdapterClick {
    public static NewFeedFragment INSTACE;
    private NewsFeedDataAdapter adapter;
    private FragmentNewsFeedBinding newsFeedBinding;
    private List<News> mNewsList;
    private int boxId=1;
    private AlertDialog alertDialog;
    private LinearLayoutManager layoutManager;
    private DialogCustomLayoutBinding mDialogCustomLayoutBinding;
    public static NewFeedFragment getInstance(){
        if(INSTACE==null){
            INSTACE = new NewFeedFragment();
        }
        return INSTACE;
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager)getContext().getSystemService(getContext().CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = alertDialog.getWindow();
        if(window == null) return;
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = 600;
        params.height = 400;
        window.setAttributes(params);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        newsFeedBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_news_feed,container,false);
        init();
        return newsFeedBinding.getRoot();
    }

    private void init() {
        mDialogCustomLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),R.layout.dialog_custom_layout,null,false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(mDialogCustomLayoutBinding.getRoot());
        alertDialog = builder.create();
        mNewsList = new ArrayList<>();
        getNews(boxId);
        adapter = new NewsFeedDataAdapter(getContext(),mNewsList,this);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        newsFeedBinding.rvNewsFeed.setLayoutManager(layoutManager);
        newsFeedBinding.rvNewsFeed.setAdapter(adapter);
        onScroll();
        refresh();


    }

    public void refresh() {
        newsFeedBinding.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                        refreshNews();

            }
        });
    }

    private void onScroll() {

        newsFeedBinding.rvNewsFeed.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosision = layoutManager.findLastVisibleItemPosition();
                if(lastPosision == (mNewsList.size()-1)){
                    boxId++;
                    getNews(boxId);
                }
            }
        });
    }

    private void getNews(final int boxId) {
        newsFeedBinding.pros.setVisibility(View.VISIBLE);
        if(!isNetworkConnected()){

            mDialogCustomLayoutBinding.tvDialogOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        }
        DataApi.getService().getData("pega",boxId,-1,1).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    DataResponse dataResponse = response.body();
                    if (dataResponse != null) {
                        Data data = dataResponse.getData();
                         if (data != null) {
                            if (data.getNews() != null) {
                                mNewsList.addAll(data.getNews());
                                adapter.notifyDataSetChanged();

                            }
                        }
                    }
                }
                newsFeedBinding.pros.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }
    public void refreshNews() {
        boxId = 1;
        DataApi.getService().getData("pega",boxId,-1,1).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()){
                    DataResponse dataResponse = response.body();
                    Data data = dataResponse.getData();
                    if(data!=null){
                        if (mNewsList != null) {
                            mNewsList.clear();
                            mNewsList.addAll(data.getNews());
                            adapter.notifyDataSetChanged();
                            layoutManager.scrollToPosition(0);
                        }
                    }
                }
                newsFeedBinding.refresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClickItem(int posision) {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

    }
}
