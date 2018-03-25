package com.example.adilapc.adila_1202150245_studycase5;

/**
 * Created by adila pc on 25/03/2018.
 */

public class DataModel {
    String Todo;
    String Deskripsi;
    String pioriy;
    DataModel(String Todo,String Deskripsi,String pioriy){
        this.Todo=Todo;
        this.Deskripsi=Deskripsi;
        this.pioriy=pioriy;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public String getPioriy() {
        return pioriy;
    }

    public String getTodo() {
        return Todo;
    }


}
