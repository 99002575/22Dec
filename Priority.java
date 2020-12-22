package com.example.finaltodo.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.R;
import com.example.finaltodo.ViewModel.FragmentViewModel;

public class Priority extends DialogFragment {
    RadioButton high,low,none;
    FragmentViewModel viewm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.priority,container,false);
        high=view.findViewById(R.id.high);
        low=view.findViewById(R.id.low);
        none=view.findViewById(R.id.none);
        viewm= ViewModelProviders.of(this.getActivity()).get(FragmentViewModel.class);

        Datamodel dm=new Datamodel();

        if(high.isChecked()){dm.setPriority("high");}
        else if(low.isChecked()){dm.setPriority("low");}
        else{dm.setPriority("none");}

        viewm.insert(dm);

        return view;
    }
}