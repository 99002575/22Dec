package com.example.finaltodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    private int Img;
    private String Text1;
    private String Text2;
    public ListFragment(int img, String text1, String text2){
        Img=img;
        Text1=text1;
        Text2=text2;
    }
    public int getImg(){
        return Img;
    }
    public String getText1(){
        return Text1;
    }
    public String getText2(){
        return Text2;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listfragment, container, false);
    }
}
