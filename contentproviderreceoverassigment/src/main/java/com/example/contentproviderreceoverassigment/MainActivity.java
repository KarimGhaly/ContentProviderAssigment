package com.example.contentproviderreceoverassigment;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainTAG";
    public static final String Column_Name = "Name";
    public static final String Column_Age = "Age";
    public static final String Column_Description = "Description";
    public static final String Column_ImgID = "ImgID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getCelb(View view) {
        List<Celebritie> celbList = new ArrayList<>();
        Uri ContentURI =Uri.parse("content://com.example.admin.contentproviderassigment.provider");
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContentURI,null,null,null,null);
        while (cursor.moveToNext())
        {
            String Name = cursor.getString(cursor.getColumnIndex(Column_Name));
            int Age = cursor.getInt(cursor.getColumnIndex(Column_Age));
            String Desc = cursor.getString(cursor.getColumnIndex(Column_Description));
            int ImgID = cursor.getInt(cursor.getColumnIndex(Column_ImgID));
            Celebritie celebritie = new Celebritie(Name,Age, ImgID,Desc);
            celbList.add(celebritie);
        }
        SetRecyclerView(celbList);

    }
    public void SetRecyclerView(List<Celebritie> celebrities)
    {
        RecyclerView rvList = (RecyclerView) findViewById(R.id.RvList);
        RVAdapter rvAdapter = new RVAdapter(MainActivity.this ,celebrities);
        rvList.setAdapter(rvAdapter);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setItemAnimator(itemAnimator);
    }
}
