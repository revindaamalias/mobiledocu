package com.example.mobiledocu.view.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.databinding.ActivityCheckStockBinding;
import com.example.mobiledocu.databinding.ActivityFaqBinding;

public class FaqActivity extends AppCompatActivity {

    private ActivityFaqBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityFaqBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.toolbarTitle.setText("FAQ");
        viewBinding.wvDocu.setWebViewClient(new WebViewClient());

        String urlFaq = "https://guidelinemyr.netlify.app/docs/mixmt/FAQ/Rating-Toko-Tidak-Naik";
        viewBinding.wvDocu.loadUrl(urlFaq);

        WebSettings webSettings = viewBinding.wvDocu.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}