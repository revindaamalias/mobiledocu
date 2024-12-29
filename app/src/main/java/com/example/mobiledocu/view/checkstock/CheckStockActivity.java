package com.example.mobiledocu.view.checkstock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.R;
import com.example.mobiledocu.databinding.ActivityCheckStockBinding;
import com.example.mobiledocu.databinding.ActivityMainBinding;

public class CheckStockActivity extends AppCompatActivity {

    private ActivityCheckStockBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityCheckStockBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.toolbarTitle.setText("Check Stock");
        viewBinding.wvDocu.setWebViewClient(new WebViewClient());

        String versionName = BuildConfig.VERSION_NAME;
        String version = versionName.replace(".", "");
        String urlCheckStock = "https://guidelinemyr.netlify.app/docs/mixmt/CheckStock/#version-";
        viewBinding.wvDocu.loadUrl(urlCheckStock + version);

        WebSettings webSettings = viewBinding.wvDocu.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}