package com.example.adilapc.adila_1202150245_studycase5;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by adila pc on 25/03/2018.
 */

public class SettingActivity extends AppCompatActivity {//digunakan untuk

    AlertDialog alertDialog1;//digunakan untuk
    int count=3;//digunakan untuk
    String color="#ffff";//digunakan untuk
    CharSequence[] values = {" Red "," Blue"," Green ","White"};//digunakan untuk

    TextView text_color;//digunakan untuk
    LinearLayout linearLayout;//digunakan untuk

    @Override
    protected void onCreate(Bundle savedInstanceState) {//digunakan untuk
        super.onCreate(savedInstanceState);//digunakan untuk
        setContentView(R.layout.activity_setting);//digunakan untuk
        text_color =(TextView)findViewById(R.id.color_text);//digunakan untuk
       linearLayout =(LinearLayout)findViewById(R.id.Background_setting);//digunakan untuk
         linearLayout.setBackgroundColor(Color.parseColor(get_pref("color","color")));//digunakan untuk
    }


    public void Setting_color(View view) {//digunakan untuk


        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);//digunakan untuk

        builder.setTitle("Shape Color");//digunakan untuk


        builder.setSingleChoiceItems(values, count, new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int item) {//digunakan untuk

                switch(item)//digunakan untuk
                {
                    case 0://digunakan untuk
                        count=0;//digunakan untuk
                        save_shared("color","color","#f44242");//digunakan untuk
                        Toast.makeText(SettingActivity.this, "First Item Clicked", Toast.LENGTH_LONG).show();//digunakan untuk
                        linearLayout.setBackgroundColor(Color.parseColor("#f44242"));//digunakan untuk
                        text_color.setText("Red");//digunakan untuk
                        break;//digunakan untuk
                    case 1://digunakan untuk
                        count=1;//digunakan untuk
                        save_shared("color","color","#425cf4");//digunakan untuk
                        Toast.makeText(SettingActivity.this, "Second Item Clicked", Toast.LENGTH_LONG).show();//digunakan untuk
                        text_color.setText("Blue");//digunakan untuk
                        linearLayout.setBackgroundColor(Color.parseColor("#425cf4"));//digunakan untuk
                        break;//digunakan untuk
                    case 2://digunakan untuk
                        count=2;//digunakan untuk
                        save_shared("color","color","#44f441");//digunakan untuk
                        Toast.makeText(SettingActivity.this, "Third Item Clicked", Toast.LENGTH_LONG).show();//digunakan untuk
                        text_color.setText("Green");//digunakan untuk
                        linearLayout.setBackgroundColor(Color.parseColor("#44f441"));//digunakan untuk
                        break;//digunakan untuk

                    case 3://digunakan untuk
                        count=3;//digunakan untuk
                        save_shared("color","color","#ffffff");//digunakan untuk
                        Toast.makeText(SettingActivity.this, "Third Item Clicked", Toast.LENGTH_LONG).show();//digunakan untuk
                        text_color.setText("White");//digunakan untuk
                        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));//digunakan untuk
                        break;//digunakan untuk
                }
                alertDialog1.dismiss();//digunakan untuk
            }

        });//digunakan untuk

        alertDialog1 = builder.create();//digunakan untuk
        alertDialog1.show();//digunakan untuk
    }
    String get_pref(String nama_file, String nama_variable){//digunakan untuk
        SharedPreferences pref = getSharedPreferences(nama_file, 0); //
        String nilai=pref.getString(nama_file,null);//digunakan untuk
        return nilai;//digunakan untuk

    }void save_shared(String nama_file,String nama_variable,String values){//digunakan untuk
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // 0 - for private mode//digunakan untuk
        SharedPreferences.Editor editor = pref.edit();//digunakan untuk
        editor.putString(nama_variable,values);//digunakan untuk
        editor.commit();//digunakan untuk
    }

}
