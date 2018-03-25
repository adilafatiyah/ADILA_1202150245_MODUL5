package com.example.adilapc.adila_1202150245_studycase5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {//digunakann untuk

    private List<DataModel> dataModels;//digunakan untuk

    public class MyViewHolder extends RecyclerView.ViewHolder {//digunakan untuk
        public TextView title, year, genre;//digunakan untuk

        public MyViewHolder(View view) {//digunakan untuk
            super(view);//digunakan untuk
            title = (TextView) view.findViewById(R.id.title);//digunakan untuk
            genre = (TextView) view.findViewById(R.id.genre);//digunakan untuk
            year = (TextView) view.findViewById(R.id.year);//digunakan untuk
        }
    }


    public RecycleAdapter(List<DataModel> moviesList) {//digunakan untuk
        this.dataModels = moviesList;//digunakan untuk
    }//digunakan untuk

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//digunakan untuk
        View itemView = LayoutInflater.from(parent.getContext())//digunakan untuk
                .inflate(R.layout.list_row, parent, false);//digunakan untuk

        return new MyViewHolder(itemView);//digunakan untuk
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//digunakan untuk
        DataModel dataModel = dataModels.get(position);//digunakan untuk
        holder.title.setText(dataModel.getTodo());//digunakan untuk
        holder.genre.setText(dataModel.getDeskripsi());//digunakan untuk
        holder.year.setText(dataModel.getPioriy());//digunakan untuk
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }//digunakan untuk
}
