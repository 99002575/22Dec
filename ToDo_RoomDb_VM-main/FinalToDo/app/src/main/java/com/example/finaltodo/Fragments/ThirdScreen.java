package com.example.finaltodo.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.finaltodo.Adapters.Adapterarr;
import com.example.finaltodo.Dialogs.DatePick;
import com.example.finaltodo.Dialogs.NotesDialog;
import com.example.finaltodo.Dialogs.Priority;
import com.example.finaltodo.Dialogs.Repeat;
import com.example.finaltodo.R;
import com.example.finaltodo.RecyclerFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.media.CamcorderProfile.get;

public class ThirdScreen extends Fragment {
    public ThirdScreen(){}
    Spinner spinner;
    Menu menu;
    MenuItem menuDoneItem;
    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        String mField[] = {"Notes", "Due Date", "Reminder", "Repeat", "Priority"};
        String msubField;
        // [] = {"Tap to add notes", "thursday, 10 Dec@12pm", "Remind e when due", "Does not repeat", "None"};
        int images[] = {R.drawable.ic_baseline_notes_24, R.drawable.ic_baseline_access_alarm_24, R.drawable.ic_baseline_notifications_24, R.drawable.ic_baseline_refresh_24, R.drawable.ic_baseline_flag_24};
        //mField= String.valueOf(get(R.id.task_title));

        ListView listView = (ListView) view.findViewById(R.id.listview);
        Adapterarr myadapter = new Adapterarr(this, mField, msubField, images);
        //back navigation
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment recyclerFragment=new RecyclerFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.maincontainer,recyclerFragment).addToBackStack(null);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(getActivity(), "you clicked on 1st item", Toast.LENGTH_SHORT).show();
                        NotesDialog n=new NotesDialog();
                        n.show(getFragmentManager(),"note");
                        msubField=String.valueOf(R.id.add_note);
                        break;
                    case 1:
                        Toast.makeText(getActivity(), "you click on 2nd item", Toast.LENGTH_SHORT).show();
                        DatePick datePicker = new DatePick();//date picker needs fix
                        datePicker.show(getFragmentManager(), "date picker");

                        //implement timepciker
                        break;
                    case 2:
                        Toast.makeText(getActivity(), "you click on 3rd item", Toast.LENGTH_SHORT).show();
                        //implement when to remind
                        break;
                    case 3:
                        Toast.makeText(getActivity(), "you click on 4th item", Toast.LENGTH_SHORT).show();
                        Repeat r=new Repeat();
                        r.show(getFragmentManager(),"repeat");
                        break;
                    case 4:
                        Toast.makeText(getActivity(), "you click on 5th item", Toast.LENGTH_SHORT).show();
                        Priority p=new Priority();
                        p.show(getFragmentManager(),"priority");
                        break;
                }
            }
        });

        return view;


    }


}

