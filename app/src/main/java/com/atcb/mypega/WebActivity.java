package com.atcb.mypega;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.atcb.mypega.databinding.WebLayoutBinding;

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebLayoutBinding binding = DataBindingUtil.setContentView(this,R.layout.web_layout);
        String url = getIntent().getExtras().getString("url");
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.getSettings().setLoadsImagesAutomatically(true);
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        binding.webView.loadUrl(url);
    }
}
