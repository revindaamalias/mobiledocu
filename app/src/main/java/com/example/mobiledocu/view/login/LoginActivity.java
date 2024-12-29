package com.example.mobiledocu.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.mobiledocu.view.manualguide.ManualGuideActivity;
import com.example.mobiledocu.databinding.ActivityLoginBinding;
import com.example.mobiledocu.view.menu.MenuActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ActivityLoginBinding viewBinding;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        presenter = new LoginPresenter(this, this);

        initFunction();
    }

    private void initFunction() {

        viewBinding.btnLogin.setOnClickListener(view -> {
            if (presenter.validation(viewBinding.etNik, viewBinding.etPassword)) {
                presenter.doLogin(viewBinding.etNik);
            }
        });

        presenter.isUserLogin();
    }

    @Override
    public void showWarningMessage(String errorMessage) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Peringatan")
                    .setMessage(errorMessage)
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

            AlertDialog dialog = builder.create();
            dialog.show();
    }

    @Override
    public void onSuccessLogin() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
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
}