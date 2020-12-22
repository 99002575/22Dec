package com.example.finaltodo.Repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.finaltodo.Database.RoomDb;
import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.Model.DatamodelDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataFragmentRepo {
//    private ArrayList<Datamodel> dataholder;
//    private HashMap<String, Datamodel> objDetails;
//    String data;
//
//
//    public void setCategory(String s){
//        Log.e("function ","yes");
//        data = s;
////    Datamodel d= new Datamodel();
////    dataholder=new ArrayList<>();
////    d.setCategory(s);
////    dataholder.add(d);
////    return dataholder;
//    }
//
//    public ArrayList<Datamodel> getDatamodel() {
//        Log.e("function ","kiran");
//        if (dataholder == null) {
//            dataholder = new ArrayList<>();
//            Datamodel dm1 =  new Datamodel();
//            dm1.setCategory(data);
//            dm1.setCategoryCount("3");
//            dataholder.add(dm1);
//
//
//            Datamodel dm2 =  new Datamodel();
//            dm2.setCategory("Health");
//            dm2.setCategoryCount("2");
//            dataholder.add(dm2);
//
//            Datamodel dm3 =  new Datamodel();
//            dm3.setCategory("Health");
//            dm3.setCategoryCount("0");
//            dataholder.add(dm3);
//        }
//        return dataholder;
//    }

    private DatamodelDao ddao;
    private LiveData<List<Datamodel>> taskLiveData;

    public DataFragmentRepo(Application application){
        RoomDb db= RoomDb.getDatabase(application);
        ddao=db.ddao();
        taskLiveData=ddao.getTasks();
    }
    public void insert (Datamodel task){
        RoomDb.databaseWriteExecutor.execute(() -> {
            ddao.insert(task);
            Log.e("Testrepo","Repo");
        });
    }
    public void update(Datamodel task) {
        RoomDb.databaseWriteExecutor.execute(() -> {
            ddao.update(task);
        });
    }
    public LiveData<List<Datamodel>> getTaskLiveData(){return taskLiveData;}

}