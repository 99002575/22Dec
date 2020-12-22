package com.example.finaltodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaltodo.Adapters.Adap;
import com.example.finaltodo.Fragments.ThirdScreen;
import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.Repo.DataFragmentRepo;
import com.example.finaltodo.ViewModel.FragmentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {
    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Datamodel> taskDescList;
    FloatingActionButton add_note;
    FragmentViewModel viewm;
    DataFragmentRepo repo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        ArrayList<ListFragment> exlist = new ArrayList<>();
//        exlist.add(new ListFragment(R.drawable.s, "Blood Test", "Thrusday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Temprature Check", "Friday @10PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Doc appointment", "Monday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Medicine Purchase", "Thrusday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Get prescription", "Thrusday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Books", "Monday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Sleep", "Friday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Health", "Thrusday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Books", "Thrusday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Sleep", "Friday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Health", "Thrusday @9PM"));
//        exlist.add(new ListFragment(R.drawable.s, "Books", "Monday @9PM"));


        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        rootView.findViewById(R.id.recyclerview);
        mRecyclerview = rootView.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mAdapter = new Adap(taskDescList);
        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setAdapter(mAdapter);

        viewm= ViewModelProviders.of(this.getActivity()).get(FragmentViewModel.class);
        viewm.gettaskLiveData().observe(getActivity(), new Observer<List<Datamodel>>() {
            @Override
            public void onChanged(List<Datamodel> taskDescs) {
                if(taskDescs!=null){
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
        setHasOptionsMenu(true);

        add_note = rootView.findViewById(R.id.add_note);
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                ThirdScreen thirdScreen = new ThirdScreen();
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, thirdScreen).addToBackStack(null).commit();

            }
        });



        //swipe delete

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(1, ItemTouchHelper.LEFT
                |ItemTouchHelper.RIGHT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                        taskDescList.remove(position);
                        mAdapter.notifyItemRemoved(position);
                        break;
                    default:
                        Fragment thirdscreen=new ThirdScreen();
                        FragmentTransaction transaction=getFragmentManager().beginTransaction();
                        transaction.replace(R.id.maincontainer,thirdscreen).addToBackStack(null);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                }

            }

        }).attachToRecyclerView(mRecyclerview);


        return rootView;
        //return inflater.inflate(R.layout.fragment_recycler, container, false);
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


}


