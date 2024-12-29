package com.example.mobiledocu.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mobiledocu.model.UserLogin;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mobiledocu.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryUser = "CREATE TABLE IF NOT EXISTS USER (" +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME VARCHAR2(500), " +
                " NIK VARCHAR2(10), " +
                " ROLE VARCHAR2(2))";

        db.execSQL(queryUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(db);
    }

    public void insertDataUser(UserLogin user){
        SQLiteDatabase db = getWritableDatabase();

        String queryInsert = "INSERT INTO USER (NAME, NIK, ROLE) VALUES (?, ?, ?)";
        String[] args = {
                user.getName(),
                user.getNik(),
                user.getRole()
        };
        db.execSQL(queryInsert, args);
    }

    public boolean isUserExist(){
        boolean isExist = false;
        SQLiteDatabase db = getWritableDatabase();

        String querySelect = "SELECT COUNT(ID) FROM USER";
        Cursor cursor = db.rawQuery(querySelect, null);

        try{
            while (cursor.moveToNext()){
                int i = cursor.getInt(0);
                if (i > 0) {
                    isExist = true;
                }
            }
        } catch (Exception e) {
            Log.d("LOGIN", "userExist: " + e.getMessage());
        }

        return isExist;
    }
    public String getUserRole(){
        String userRole = "";
        SQLiteDatabase db = getWritableDatabase();

        String querySelect = "SELECT * FROM USER";
        Cursor cursor = db.rawQuery(querySelect, null);

        try{
            while (cursor.moveToNext()){
                userRole = cursor.getString(3);
            }
        } catch (Exception e) {
            Log.d("LOGIN", "userExist: " + e.getMessage());
        }

        return userRole;
    }

    public void deleteAllData() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM USER");
    }
}
