package com.example.mobiledocu.view.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.mobiledocu.BuildConfig;
import com.example.mobiledocu.R;
import com.example.mobiledocu.databinding.ActivityMainBinding;
import com.example.mobiledocu.databinding.ActivityMenuBinding;
import com.example.mobiledocu.view.checkstock.CheckStockActivity;
import com.example.mobiledocu.view.faq.FaqActivity;
import com.example.mobiledocu.view.login.LoginActivity;
import com.example.mobiledocu.view.manualguide.ManualGuideActivity;
import com.example.mobiledocu.view.manualguide.ManualGuidePresenter;

public class MenuActivity extends AppCompatActivity implements MenuView {

    private ActivityMenuBinding viewBinding;
    private MenuPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        presenter = new MenuPresenter(this, this);
        viewBinding.toolbarTitle.setText("Menu");
        viewBinding.tvVersion1.setText(BuildConfig.VERSION_NAME);

        String userRole = presenter.getUserRole();

        viewBinding.cvManual.setOnClickListener(view -> {
            if ("SS".equalsIgnoreCase(userRole)) {
                Intent intent = new Intent(this, ManualGuideActivity.class);
                startActivity(intent);
            } else {
                showWarning("Anda tidak dapat mengakses halaman ini!");
            }
        });

        viewBinding.cvFaq.setOnClickListener(view -> {
            if ("SS".equalsIgnoreCase(userRole)) {
                Intent intent = new Intent(this, FaqActivity.class);
                startActivity(intent);
            } else {
                showWarning("Anda tidak dapat mengakses halaman ini!");
            }
        });

        viewBinding.btnLogout.setOnClickListener(view -> {
            presenter.logout();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Peringatan")
                .setMessage("Apakah anda yakin ingin keluar dari aplikasi?")
                .setPositiveButton("Ya", (dialog, which) -> {
                    dialog.dismiss();
                    Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                    homeIntent.addCategory(Intent.CATEGORY_HOME);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(homeIntent);
                    finish();
                })
                .setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onSuccesLogout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}