package com.example.finaltodo.Fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaltodo.Adapters.myadapter;
import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.R;
import com.example.finaltodo.Repo.DataFragmentRepo;
import com.example.finaltodo.ViewModel.FragmentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Datafragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> dataholder;
    FloatingActionButton add;
    FragmentViewModel viewm;
    DataFragmentRepo repo;
   // private myadapter myadap = new myadapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_datafragment, container, false);
        setHasOptionsMenu(true);

        add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogue_Fragment mydialog = new Dialogue_Fragment();
                mydialog.show(getFragmentManager(), "Dialogue_Fragment");
                //call the category count increase fn
            }
        });


        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        dataholder = new ArrayList<String>();
//        String da1 = "Health";
//        dataholder.add(da1);
//        datamodel da2 = new datamodel("Songs");
//        dataholder.add(da2);
//        datamodel da4 = new datamodel("Books");
//        dataholder.add(da4);
//        datamodel da5 = new datamodel("Drives");
//        dataholder.add(da5);
//        datamodel da6 = new datamodel("Bdy");
//        dataholder.add(da6);
//        datamodel da7 = new datamodel("Party");
//        dataholder.add(da7);
//     recyclerView.setAdapter(new myadapter(dataholder));



        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        boolean showMessage = false;

        String message = "You click ";


        if (itemId == R.id.share) {
            showMessage = true;
            message += "share";
        } else if (itemId == R.id.delete) {
            showMessage = true;
            message += "delete";
        }

        if (showMessage) {
            AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
            alertDialog.setMessage(message);
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myadapter myadap = new myadapter();
        viewm= ViewModelProviders.of(this.getActivity()).get(FragmentViewModel.class);
        recyclerView.setAdapter(myadap);

        viewm.gettaskLiveData().observe(getActivity(), new Observer<List<Datamodel>>() {
            @Override
            public void onChanged(List<Datamodel> tasks) {
                if (tasks != null) {
                    myadap.setTask(tasks);
                }
            }
        });

//        get variables needed to display
//    }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };
}

