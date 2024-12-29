package com.example.mobiledocu.view.login;

import android.content.Context;

import com.example.mobiledocu.database.DBHelper;
import com.example.mobiledocu.model.UserLogin;
import com.google.android.material.textfield.TextInputEditText;

public class LoginPresenter {

    private Context context;
    private LoginView mvpView;
    private DBHelper dbHelper;

    public LoginPresenter(Context context, LoginView view) {
        this.mvpView = view;
        dbHelper = new DBHelper(context);
    }

    public boolean validation(TextInputEditText etNik, TextInputEditText etPassword) {
        if (etNik.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {
            mvpView.showWarningMessage("NIK atau Password Harus Diisi!");
            return false;
        }

        return true;
    }

    public void doLogin(TextInputEditText etNik) {
        // Digunakan untuk nembak service login

        if (etNik.getText().toString().equalsIgnoreCase("118887")) {
            UserLogin user = new UserLogin();
            user.setName("Revinda Amalia");
            user.setNik(etNik.getText().toString());
            user.setRole("SS");

            dbHelper.insertDataUser(user);
            mvpView.onSuccessLogin();
        } else {
            UserLogin user = new UserLogin();
            user.setName("User Lain");
            user.setNik(etNik.getText().toString());
            user.setRole("TL");

            dbHelper.insertDataUser(user);
            mvpView.onSuccessLogin();
        }
    }

    public void isUserLogin() {
        if (dbHelper.isUserExist()) {
            mvpView.onSuccessLogin();
        }
    }
}
