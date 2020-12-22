package com.example.finaltodo.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface DatamodelDao {
    @Insert
    void insert(Datamodel data);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * FROM task_table ORDER BY categoryCount ASC")
    LiveData<List<Datamodel>> getTasks();

    @Update
    void update(Datamodel data);
}

