package com.example.admin.contentproviderassigment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public static final String Database_Name = "DB";
    public static final int Database_Version = 2;
    public static final String Table_Name = "CelebritiesTBL";
    public static final String TAG = "SQLDATABASESQL";
    public static final String Column_Name = "Name";
    public static final String Column_Age = "Age";
    public static final String Column_Description = "Description";
    public static final String Column_ImgID = "ImgID";

    private Database DB;
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        DB = new Database(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
       return DB.getReadableDatabase().query(Table_Name,projection,selection,selectionArgs,null,null,sortOrder);
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
