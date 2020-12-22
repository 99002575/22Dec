package com.example.finaltodo.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.R;
import com.example.finaltodo.ViewModel.FragmentViewModel;

public class Repeat extends DialogFragment {
    RadioButton day,week,month,year;
    FragmentViewModel viewm;

    public Repeat(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.repeat,container,false);
        day=view.findViewById(R.id.day);
        week=view.findViewById(R.id.week);
        month=view.findViewById(R.id.month);
        year=view.findViewById(R.id.year);
        viewm= ViewModelProviders.of(this.getActivity()).get(FragmentViewModel.class);
        Datamodel dm=new Datamodel();
        if(day.isChecked()){dm.setRepeat("daily");}
        else if(week.isChecked()){dm.setRepeat("weekly");}
        else if(year.isChecked()){dm.setRepeat("yearly");}
        else{dm.setRepeat("monthly");}
        viewm.insert(dm);
        return view;
    }
}
