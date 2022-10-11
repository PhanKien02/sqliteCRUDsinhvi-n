package com.example.crudsinhvien.SQLite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHepper extends SQLiteOpenHelper {
    public  static  final  String nameDB= "sinhvien";
    public  static  final int DB_Version =1;
    public DBHepper(@Nullable Context context) {
        super(context, nameDB,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String sql= "Create table SinhVien(id text primary key,name text not null,"+
                    "lop text not null)";
            db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                String sql ="Drop table if Exists SinhVien";
                db.execSQL(sql);
                onCreate(db);
    }
}
