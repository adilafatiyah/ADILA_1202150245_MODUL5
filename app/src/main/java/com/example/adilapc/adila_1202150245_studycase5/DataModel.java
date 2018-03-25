package com.example.adilapc.adila_1202150245_studycase5;

/**
 * Created by adila pc on 25/03/2018.
 */

public class DataModel { //digunakan untuk membuat public class DataModel {
    String Todo; //digunakan untuk membuat String
    String Deskripsi; //String Deskripsi;
    String pioriy; //String pioriy;
    DataModel(String Todo,String Deskripsi,String pioriy){//digunakan untuk membuat
        this.Todo=Todo;
        this.Deskripsi=Deskripsi;
        this.pioriy=pioriy;
    }

    public String getDeskripsi() {
        return Deskripsi;
    } //digunakan untuk get

    public String getPioriy() {
        return pioriy;
    }//digunakan untuk get

    public String getTodo() {
        return Todo;
    }


}
