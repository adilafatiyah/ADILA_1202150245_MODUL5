package com.example.adilapc.adila_1202150245_studycase5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity { //digunakan untuk public class MainActivity extends AppCompatActivity {

    DataBase db; //digunakan untuk DataBase db;
    Cursor cursor; //digunakan untuk Cursor cursor;
    ListView listView; //digunakan untuk ListView listView;
    ArrayList <String> todo = new ArrayList<String>(); //digunakan untuk ArrayList <String>tod=newArrayList<String>();
    ArrayList <String> disdrip = new ArrayList<String>(); //digunakan untuk ArrayList <String> disdrip = new ArrayList<String>();
    ArrayList <String> piroty = new ArrayList<String>();//digunakan untuk ArrayList <String> piroty = new ArrayList<String>();

    LinearLayout linearLayout;//digunakan untuk
    RecyclerView recyclerView;//digunakan untuk RecyclerView recyclerView;
    List<DataModel> data = new ArrayList<>();//digunakan untuk  List<DataModel> data = new ArrayList<>();
    RecycleAdapter adapter;//digunakan untuk RecycleAdapter adapter;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //digunakan untuk public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){ //digunakan untuk switch (item.getItemId()){
            case R.id.setting_menu: //digunakan untuk  case R.id.setting_menu:
                Intent i = new Intent(MainActivity.this,SettingActivity.class);//digunakan untuk Intent i = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(i);//digunakan untuk startActivity(i);

                break;//digunakan untuk break;
        }
        return true;//digunakan untuk  return true;
    }


    @Override
    protected void onResume() {//digunakan untuk  protected void onResume() {
        super.onResume();//digunakan untuk super.onResume();
        list();//digunakan untuk list();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//digunakan untuk public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuiFalter = getMenuInflater();//digunakan untuk MenuInflater menuiFalter = getMenuInflater();
        menuiFalter.inflate(R.menu.menu_toolbar,menu);//digunakan untuk menuiFalter.inflate(R.menu.menu_toolbar,menu);
        return  true;//digunakan untuk return  true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//digunakan untuk super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//digunakan untuk setContentView(R.layout.activity_main);

        db= new DataBase(this);//digunakan untuk db= new DataBase(this);
        refres_list();//digunakan untuk refres_list();

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_main);//digunakan untuk Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);//digunakan untuk

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_tambah);//digunakan untuk
        fab.setOnClickListener(new View.OnClickListener() {//digunakan untuk fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //digunakan untuk  public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Tambah_list_Activity.class );//digunakan untuk Intent i = new Intent(MainActivity.this,Tambah_list_Activity.class );
                startActivity(i);//digunakan untuk startActivity(i);
            }
        });

        list();//digunakan untuk list();




    }
    void list(){//digunakan untuk void list(){
        Data swipeController = new Data();//digunakan untuk Data swipeController = new Data();
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);//digunakan untuk ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);//digunakan untuk itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);//digunakan untuk recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        adapter  = new RecycleAdapter(data);//digunakan untuk adapter  = new RecycleAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());//digunakan untuk RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);//digunakan untuk recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));//digunakan untuk recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());//digunakan untuk recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);//digunakan untuk recyclerView.setAdapter(adapter);



        // listView = (ListView)findViewById(R.id.list_view);
        // listView.
        // listView.setAdapter(new ListAdapter(this,todo,disdrip,piroty));



    }
    void refres_list(){//digunakan untuk void refres_list(){
        SQLiteDatabase database = db.getReadableDatabase();//digunakan untuk  SQLiteDatabase database = db.getReadableDatabase();
        cursor =database.rawQuery("SELECT * FROM tb_todo",null);//digunakan untuk cursor =database.rawQuery("SELECT * FROM tb_todo",null);

        if(cursor!=null){//digunakan untuk if(cursor!=null){
            if(cursor.moveToFirst()){//digunakan untuk if(cursor.moveToFirst()){
                do {//digunakan untuk  do {


                    String nama_todo = cursor.getString(cursor.getColumnIndex("todo_nama"));//digunakan untuk String nama_todo = cursor.getString(cursor.getColumnIndex("todo_nama"));
                    String Descrip = cursor.getString(cursor.getColumnIndex("description"));//digunakan untuk  String Descrip = cursor.getString(cursor.getColumnIndex("description"));
                    String piority = cursor.getString(cursor.getColumnIndex("piority"));//digunakan untuk String piority = cursor.getString(cursor.getColumnIndex("piority"));
                    todo.add(nama_todo);//digunakan untuk tod.add(nama_todo);
                    DataModel dat = new DataModel(nama_todo,Descrip,piority);//digunakan untuk DataModel dat = new DataModel(nama_todo,Descrip,piority);
                    data.add(dat);//digunakan untuk data.add(dat);

                    disdrip.add(Descrip);//digunakan untuk disdrip.add(Descrip);
                    piroty.add(piority);//digunakan untuk piroty.add(piority);
                }while (cursor.moveToNext());//digunakan untuk }while (cursor.moveToNext());





            }


        }



    }


    String get_pref(String nama_file, String nama_variable){//digunakan untuk String get_pref(String nama_file, String nama_variable){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); //digunakan untuk SharedPreferences pref = getSharedPreferences(nama_file, 0);
        String nilai=pref.getString(nama_file,null);//digunakan untuk String nilai=pref.getString(nama_file,null);
        return nilai;//digunakan untuk return nilai;
    }

    @Override
    protected void onPause() {//digunakan untuk protected void onPause() {
        super.onPause();//digunakan untuk  super.onPause();

    }
}
