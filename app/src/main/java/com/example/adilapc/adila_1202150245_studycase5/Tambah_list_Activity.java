package com.example.adilapc.adila_1202150245_studycase5;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by adila pc on 25/03/2018.
 */

public class Tambah_list_Activity extends AppCompatActivity {//digunakan untuk public class Tambah_list_Activity extends AppCompatActivity {

    DataBase db;//digunakan untuk DataBase db;
    Cursor cursor;//digunakan untuk Cursor cursor;
    EditText editText_Nama,editText_description,editText_piority;//digunakan untuk  EditText editText_Nama,editText_description,editText_piority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk  super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_tambah_list_);//digunakan untuk
        db = new DataBase(this);//digunakan untuk db = new DataBase(this);

        editText_Nama =(EditText)findViewById(R.id.list_todo);//digunakan untuk editText_Nama =(EditText)findViewById(R.id.list_todo);
        editText_description =(EditText)findViewById(R.id.editText_deskripsi);//digunakan untuk
        editText_piority =(EditText)findViewById(R.id.editText_prioritas);//digunakan untuk

    }

    public void tambah_todo(View view) {//digunakan untuk public void tambah_todo(View view) {
        String nama=editText_Nama.getText().toString();//digunakan untuk String nama=editText_Nama.getText().toString();
        String descrip = editText_description.getText().toString();//digunakan untuk  String descrip = editText_description.getText().toString();
        String piority = editText_piority.getText().toString();//digunakan untuk String piority = editText_piority.getText().toString();
        SQLiteDatabase database = db.getWritableDatabase();//digunakan untuk SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL("INSERT INTO tb_todo(todo_nama,description,piority) VALUES ('"+nama+"','"+descrip+"','"+piority+"')");//digunakan untuk database.execSQL("INSERT INTO tb_todo(todo_nama,description,piority) VALUES ('"+nama+"','"+descrip+"','"+piority+"')");
        Toast.makeText(this,"Data Tersimpan",Toast.LENGTH_SHORT).show();//digunakan untuk  Toast.makeText(this,"Data Tersimpan",Toast.LENGTH_SHORT).show();
    }
    void save_shared(String nama_file,String nama_variable,String values){//digunakan untuk  void save_shared(String nama_file,String nama_variable,String values){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // digunakan untuk  SharedPreferences pref = getSharedPreferences(nama_file, 0);
        SharedPreferences.Editor editor = pref.edit();//digunakan untuk SharedPreferences.Editor editor = pref.edit();
        editor.putString(nama_variable,values);//digunakan untuk editor.putString(nama_variable,values);
        editor.commit();//digunakan untuk editor.commit();
    }
    void get_pref(String nama_file, String nama_variable){//digunakan untuk void get_pref(String nama_file, String nama_variable){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // digunakan untuk SharedPreferences pref = getSharedPreferences(nama_file, 0);
        pref.getString(nama_file,null);//digunakan untuk pref.getString(nama_file,null);

    }
}
