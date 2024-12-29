package com.example.mobiledocu.view.manualguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.databinding.ActivityMainBinding;
import com.example.mobiledocu.view.activitycompetitor.ActivityCompetitorActivity;
import com.example.mobiledocu.view.checkstock.CheckStockActivity;
import com.example.mobiledocu.view.followupissue.FollowUpIssueActivity;
import com.example.mobiledocu.view.login.LoginActivity;
import com.example.mobiledocu.view.ratingtoko.RatingTokoActivity;
import com.example.mobiledocu.view.salesperformance.SalesPerformanceActivity;

public class ManualGuideActivity extends AppCompatActivity implements ManualGuideView {

    private ActivityMainBinding viewBinding;
    private ManualGuidePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        presenter = new ManualGuidePresenter(this, this);

        viewBinding.toolbarTitle.setText("Manual Guide");
        viewBinding.tvVersion1.setText(BuildConfig.VERSION_NAME);
        viewBinding.tvVersion2.setText(BuildConfig.VERSION_NAME);
        viewBinding.tvVersion3.setText(BuildConfig.VERSION_NAME);
        viewBinding.tvVersion4.setText(BuildConfig.VERSION_NAME);
        viewBinding.tvTahap.setText("3 Tahap");

        String userRole = presenter.getUserRole();

        viewBinding.cvCheckStock.setOnClickListener(view -> {
            if ("SS".equalsIgnoreCase(userRole)) {
                Intent intent = new Intent(this, CheckStockActivity.class);
                startActivity(intent);
            } else {
                showWarning("Anda tidak dapat mengakses halaman ini!");
            }
        });

        viewBinding.cvComp.setOnClickListener(view -> {
            if ("SS".equalsIgnoreCase(userRole)) {
                Intent intent = new Intent(this, ActivityCompetitorActivity.class);
                startActivity(intent);
            } else {
                showWarning("Anda tidak dapat mengakses halaman ini!");
            }
        });

        viewBinding.cvRating.setOnClickListener(view -> {
            if ("SS".equalsIgnoreCase(userRole)) {
                Intent intent = new Intent(this, RatingTokoActivity.class);
                startActivity(intent);
            } else {
                showWarning("Anda tidak dapat mengakses halaman ini!");
            }
        });

        viewBinding.cvSales.setOnClickListener(view -> {
            if ("SS".equalsIgnoreCase(userRole)) {
                Intent intent = new Intent(this, SalesPerformanceActivity.class);
                startActivity(intent);
            } else {
                showWarning("Anda tidak dapat mengakses halaman ini!");
            }
        });

        viewBinding.cvFollowUp.setOnClickListener(view -> {
            if ("SS".equalsIgnoreCase(userRole)) {
                Intent intent = new Intent(this, FollowUpIssueActivity.class);
                startActivity(intent);
            } else {
                showWarning("Anda tidak dapat mengakses halaman ini!");
            }
        });
    }

    private void showWarning(String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Peringatan")
                .setMessage(errorMessage)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}