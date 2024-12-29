package com.example.mobiledocu.view.activitycompetitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.R;
import com.example.mobiledocu.databinding.ActivityCheckStockBinding;
import com.example.mobiledocu.databinding.ActivityCompetitorBinding;

public class ActivityCompetitorActivity extends AppCompatActivity {

    private ActivityCompetitorBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityCompetitorBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.toolbarTitle.setText("Activity Competitor");
        viewBinding.wvDocu.setWebViewClient(new WebViewClient());

        String versionName = BuildConfig.VERSION_NAME;
        String version = versionName.replace(".", "");
        String urlActComp = "https://guidelinemyr.netlify.app/docs/mixmt/Competitor_Activity/Competitor-Activity#version-";
        viewBinding.wvDocu.loadUrl(urlActComp + version);

        WebSettings webSettings = viewBinding.wvDocu.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}