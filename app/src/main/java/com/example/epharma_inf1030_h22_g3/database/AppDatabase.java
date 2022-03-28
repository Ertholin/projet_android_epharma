package com.example.epharma_inf1030_h22_g3.database;

import android.content.Context;

import androidx.annotation.RawRes;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.epharma_inf1030_h22_g3.R;
import com.example.epharma_inf1030_h22_g3.dao.MedicamentDAO;
import com.example.epharma_inf1030_h22_g3.database.converters.LocalDateTimeTypeConverter;
import com.example.epharma_inf1030_h22_g3.models.Medicament;
import com.example.epharma_inf1030_h22_g3.models.User;

import java.io.InputStream;
import java.util.concurrent.Executors;

@Database(entities =
        {User.class,
                Medicament.class},
        version = 1, exportSchema = false)
@TypeConverters({LocalDateTimeTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String dbName = "dbEphama";

    private static AppDatabase instance;
    public abstract MedicamentDAO medicamentDAO();

    public static synchronized AppDatabase instance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, dbName)
                    .addCallback(new Callback() {
                        public void onCreate(SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadExecutor()
                                    .execute(() -> iniSchema(db, context));
                        }
                    }).build();
        }
        return instance;
    }

    private static void iniSchema(SupportSQLiteDatabase db, Context context) {
        try {
            loadSQLRaw(db, context, R.raw.drug);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadSQLRaw(SupportSQLiteDatabase helper, Context context, @RawRes int sqlRaw) {
        new Thread(() -> {
            try {
                InputStream is = context.getResources().openRawResource(sqlRaw);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                String sql = new String(buffer, "UTF-8");
                helper.execSQL(sql);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }


}

