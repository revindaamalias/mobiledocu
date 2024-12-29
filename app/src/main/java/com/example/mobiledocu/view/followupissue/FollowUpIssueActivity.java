package com.example.mobiledocu.view.followupissue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.R;
import com.example.mobiledocu.databinding.ActivityCheckStockBinding;
import com.example.mobiledocu.databinding.ActivityFollowUpIssueBinding;

public class FollowUpIssueActivity extends AppCompatActivity {

    private ActivityFollowUpIssueBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityFollowUpIssueBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        viewBinding.toolbarTitle.setText("Follow Up Issue");
        viewBinding.wvDocu.setWebViewClient(new WebViewClient());

        String urlFollowUp = "https://guidelinemyr.netlify.app/docs/mixmt/Follow_Up_Issue/Tahap-Input-Issue";
        viewBinding.wvDocu.loadUrl(urlFollowUp);

        WebSettings webSettings = viewBinding.wvDocu.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}