package com.example.mobiledocu.view.ratingtoko;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.databinding.ActivityCheckStockBinding;
import com.example.mobiledocu.databinding.ActivityFollowUpIssueBinding;
import com.example.mobiledocu.databinding.ActivityRatingTokoBinding;

public class RatingTokoActivity extends AppCompatActivity {

    private ActivityRatingTokoBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityRatingTokoBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.toolbarTitle.setText("Rating Toko");
        viewBinding.wvDocu.setWebViewClient(new WebViewClient());

        String versionName = BuildConfig.VERSION_NAME;
        String version = versionName.replace(".", "");
        String urlRatingToko = "https://guidelinemyr.netlify.app/docs/mixmt/Rating_Toko/Rating-Toko#version-";
        viewBinding.wvDocu.loadUrl(urlRatingToko + version);

        WebSettings webSettings = viewBinding.wvDocu.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}