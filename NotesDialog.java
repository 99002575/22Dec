package com.example.finaltodo.Dialogs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.R;
import com.example.finaltodo.ViewModel.FragmentViewModel;

public class NotesDialog extends DialogFragment {
    Button save,cancel;
    FragmentViewModel viewm;
    String value;
    EditText add_note;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.note,container,false);
        save=view.findViewById(R.id.button);
        cancel=view.findViewById(R.id.button2);
        add_note=view.findViewById(R.id.add_note);
        viewm= ViewModelProviders.of(this.getActivity()).get(FragmentViewModel.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("test","onClick");
                Toast.makeText(getActivity(), "Note Added", Toast.LENGTH_SHORT).show();
                value = add_note.getText().toString();
                Toast.makeText(getActivity(),value, Toast.LENGTH_SHORT).show();
//                viewm.insert(value);
                Datamodel dm= new Datamodel(value);

                viewm.insert(dm);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout note= view.findViewById(R.id.note);
                note.setVisibility(view.GONE);
            }
        });
        return view;
    }
}
