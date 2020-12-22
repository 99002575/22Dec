package com.example.finaltodo.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaltodo.Fragments.ThirdScreen;
import com.example.finaltodo.ListFragment;
import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.R;

import java.util.ArrayList;
import java.util.List;

public class Adap extends RecyclerView.Adapter<Adap.exViewHolder> {
    public CardView cardView;

    private List<Datamodel> dataholder;


    @NonNull
    @Override
    public exViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listfragment,parent,false);
        return new exViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull exViewHolder holder, int position) {
        if(position==1)
            ((CardView) holder.itemView).setCardBackgroundColor(Color.BLUE);
//        else if(position==2)
//            holder.cardView.setBackgroundColor(Color.parseColor("#amberColorCode"));


        holder.mimageView.setImageResource(dataholder.get(position).getImage());
        holder.mTextView1.setText(dataholder.get(position).gettask());
        holder.mTextView2.setText(dataholder.get(position).getDescription());



        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                buttonView.setSelected(isChecked);

            }
        });





        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity=(AppCompatActivity)v.getContext();
                ThirdScreen blankFragment=new ThirdScreen();
                System.out.println("Card Clicked");
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,blankFragment).addToBackStack(null).commit();
                System.out.println("Card Clicked");
                //write a method to pass the item name
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }


    public static class exViewHolder extends RecyclerView.ViewHolder{
        public ImageView mimageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public CheckBox checkBox;

        public exViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageView=itemView.findViewById(R.id.imageview);
            mTextView1=itemView.findViewById(R.id.textView);
            mTextView2=itemView.findViewById(R.id.textView2);
            checkBox = itemView.findViewById(R.id.checkBox);


        }


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        //public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card);
            //checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
    public void onBindViewHolder(ViewHolder holder, int position) {

    }
    public Adap(List<Datamodel> taskList){
        dataholder=taskList;
    }

    public void setTaskDesc(List<Datamodel> taskDesc){
        this.dataholder=taskDesc;
        notifyDataSetChanged();
    }
}

