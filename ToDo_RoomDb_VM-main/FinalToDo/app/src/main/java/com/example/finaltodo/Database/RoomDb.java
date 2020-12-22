package com.example.finaltodo.Database;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.Model.DatamodelDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



    @Database(entities = {Datamodel.class}, version = 1, exportSchema = false)
    public abstract class RoomDb extends RoomDatabase {
        public abstract DatamodelDao ddao();

        private static volatile RoomDb INSTANCE;
        private static final int NUMBER_OF_THREADS = 4;
        public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        public static RoomDb getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (RoomDb.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                                context.getApplicationContext(),
                                RoomDb.class,
                                "todo_database"
                        ).build();
                    }
                }
            }
            return INSTANCE;
        }
    }

