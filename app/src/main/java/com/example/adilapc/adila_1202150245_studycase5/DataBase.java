package com.example.adilapc.adila_1202150245_studycase5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adila pc on 25/03/2018.
 */

public class DataBase extends SQLiteOpenHelper { //digunakan untuk membuat public class DataBase extends SQLiteOpenHelper
    private static final String DATABASE_NAME = "inidatabase.db"; //digunakan untuk membuat private static final String DATABASE_NAME = "inidatabase.db";
    private static final int DATABASE_VERSION = 1; //digunakan untuk membuat private static final int DATABASE_VERSION = 1;
    public DataBase(Context context) { //digunakan untuk membuat public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); //digunakan untuk membuat super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //digunakan untuk membuat public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table tb_todo(id_todo integer primary key, todo_nama text null, description text null, piority text null);"; // String sql = "create table tb_todo(id_todo integer primary key, todo_nama text null, description text null, piority text null);";
        Log.d("Data", "onCreate: " + sql); //digunakan untuk Log.d("Data", "onCreate: " + sql);
        sqLiteDatabase.execSQL(sql);//digunakan untuk membuat sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//digunakn untuk membuat public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

