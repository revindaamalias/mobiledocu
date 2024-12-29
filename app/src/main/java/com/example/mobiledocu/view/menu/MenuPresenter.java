package com.example.mobiledocu.view.menu;

import android.content.Context;

import com.example.mobiledocu.database.DBHelper;
import com.example.mobiledocu.view.manualguide.ManualGuideView;

public class MenuPresenter {
    private MenuView menuView;
    private Context context;
    private DBHelper dbHelper;

    public MenuPresenter(Context context, MenuView menuView) {
        this.context = context;
        this.menuView = menuView;
        dbHelper = new DBHelper(context);
    }

    public void logout() {
        dbHelper.deleteAllData();
        menuView.onSuccesLogout();
    }

    public String getUserRole() {
        return dbHelper.getUserRole();
    }
}
