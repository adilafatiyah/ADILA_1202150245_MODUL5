package com.example.adilapc.adila_1202150245_studycase5;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

import static android.graphics.Paint.Align.LEFT;
import static android.support.v7.widget.helper.ItemTouchHelper.*;


public class Data  extends Callback  { //digunakan untuk membuat public class Data  extends Callback
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) { //digunakan untuk membuat public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder)
        return makeMovementFlags(0, ItemTouchHelper.LEFT | RIGHT); //digunakan untuk membuat return makeMovementFlags(0, ItemTouchHelper.LEFT | RIGHT);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) { //digunakan untuk public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
        return false; //digunakan untuk mengembalikan sungsi salah return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) { //digunakan untuk membuat public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)

    }
}
