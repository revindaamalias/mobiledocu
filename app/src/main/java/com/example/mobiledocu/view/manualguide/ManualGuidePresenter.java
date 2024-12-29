package com.example.mobiledocu.view.manualguide;

import android.content.Context;

import com.example.mobiledocu.database.DBHelper;

public class ManualGuidePresenter {

    private ManualGuideView manualGuideView;
    private Context context;
    private DBHelper dbHelper;

    public ManualGuidePresenter(Context context, ManualGuideView manualGuideView) {
        this.context = context;
        this.manualGuideView = manualGuideView;
        dbHelper = new DBHelper(context);
    }

    public String getUserRole() {
        return dbHelper.getUserRole();
    }
}
