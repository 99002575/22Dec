package com.example.finaltodo.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.R;
import com.example.finaltodo.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    List<Datamodel> dataholder;





    public myadapter() {

     this.dataholder= new ArrayList<Datamodel>();
        Log.e(" testing","  constructor  ");
//        Log.e("arry tetting",""+dataholder.size());
    }

    @NonNull

    @Override
    public myadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {
        holder.text_view_categorycount.setText(dataholder.get(position).getCategoryCount());
        Log.e(" testing","    "+dataholder.get(position).getCategory()+"   ");

        holder.text_view_title.setText(dataholder.get(position).getCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                RecyclerFragment blankFragment = new RecyclerFragment();
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, blankFragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }


    class myviewholder extends RecyclerView.ViewHolder {

        TextView text_view_categorycount, text_view_title;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            text_view_title = itemView.findViewById(R.id.text_view_title);
            text_view_categorycount = itemView.findViewById(R.id.text_view_task);


        }
    }
    public void setTask(List<Datamodel> task){
        this.dataholder = task;

        notifyDataSetChanged();
    }
}