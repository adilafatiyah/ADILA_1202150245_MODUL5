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

public class Tambah_list_Activity extends AppCompatActivity {

    DataBase db;
    Cursor cursor;
    EditText editText_Nama,editText_description,editText_piority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_tambah_list_);
        db = new DataBase(this);

        editText_Nama =(EditText)findViewById(R.id.list_todo);
        editText_description =(EditText)findViewById(R.id.editText_deskripsi);
        editText_piority =(EditText)findViewById(R.id.editText_prioritas);

    }

    public void tambah_todo(View view) {
        String nama=editText_Nama.getText().toString();
        String descrip = editText_description.getText().toString();
        String piority = editText_piority.getText().toString();
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL("INSERT INTO tb_todo(todo_nama,description,piority) VALUES ('"+nama+"','"+descrip+"','"+piority+"')");
        Toast.makeText(this,"Data Tersimpan",Toast.LENGTH_SHORT).show();
    }
    void save_shared(String nama_file,String nama_variable,String values){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(nama_variable,values);
        editor.commit();
    }
    void get_pref(String nama_file, String nama_variable){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // 0 - for private mode
        pref.getString(nama_file,null);

    }
}
