package com.example.mobiledocu.view.salesperformance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.databinding.ActivityCheckStockBinding;
import com.example.mobiledocu.databinding.ActivityFollowUpIssueBinding;
import com.example.mobiledocu.databinding.ActivitySalesPerformanceBinding;

public class SalesPerformanceActivity extends AppCompatActivity {

    private ActivitySalesPerformanceBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivitySalesPerformanceBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.toolbarTitle.setText("Sales Performance");
        viewBinding.wvDocu.setWebViewClient(new WebViewClient());

        String versionName = BuildConfig.VERSION_NAME;
        String version = versionName.replace(".", "");
        String urlSalesPerformance = "https://guidelinemyr.netlify.app/docs/mixmt/Sales_Performance/Sales-Performance#version-";
        viewBinding.wvDocu.loadUrl(urlSalesPerformance + version);

        WebSettings webSettings = viewBinding.wvDocu.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}