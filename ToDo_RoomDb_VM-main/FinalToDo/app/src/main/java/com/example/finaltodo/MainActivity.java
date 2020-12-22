package com.example.finaltodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finaltodo.Fragments.Datafragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, new Datafragment()).commit();

    }
}