package com.example.epharma_inf1030_h22_g3.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.epharma_inf1030_h22_g3.dao.UserDAO;
import com.example.epharma_inf1030_h22_g3.models.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String dbName = "user";

    private static AppDatabase appDatabase;

    public static synchronized AppDatabase getAppDatabase(Context context){

        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }

    public abstract UserDAO userDAO();




}

