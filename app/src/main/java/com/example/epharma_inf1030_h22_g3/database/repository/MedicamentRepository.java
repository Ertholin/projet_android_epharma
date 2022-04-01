package com.example.epharma_inf1030_h22_g3.database.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.epharma_inf1030_h22_g3.EphApp;
import com.example.epharma_inf1030_h22_g3.dao.MedicamentDAO;
import com.example.epharma_inf1030_h22_g3.models.Medicament;

import java.util.List;
import java.util.function.Consumer;

public class MedicamentRepository {

    private MedicamentDAO dao;
    private LiveData<List<Medicament>> medicaments;
    private EphApp app;

    public MedicamentRepository(Application context){
        app = (EphApp) context;
        dao = app.getDb().medicamentDAO();
    }

    public void getAsyncAll(Consumer<List<Medicament>> completion){
        app.postDB(()-> {
            List<Medicament> medicaments = dao.getAll();
            if (completion != null) {
                new Handler(Looper.getMainLooper()).post(()->{
                    completion.accept(medicaments);
                });
            }
        });
    }

    public LiveData<List<Medicament>> liveAll(){
        if(medicaments == null){
            medicaments = dao.getLiveAll();
        }
        return medicaments;
    }

//    public LiveData<Medicament>live(String uuid){
//        return  dao.getLive(uuid);
//    }

    public void insert(Medicament... medicaments) {
        insert(null, medicaments);
    }
    public void insert(Runnable completion, Medicament... medicaments){
        app.postDB(()->{
            dao.insert(medicaments);
            if(completion != null) {
                new Handler(Looper.getMainLooper()).post(completion);
            }
        });
    }

    public void delete(Medicament... medicaments) {
        delete(null, medicaments);
    }
    public void delete(Runnable completion, Medicament... medicaments){
        app.postDB(()->{
            dao.delete(medicaments);

            if(completion != null) {
                new Handler(Looper.getMainLooper())
                        .post(completion);
            }

        });

    }

    public List<Medicament> getAsyncNewItems(Consumer<List<Medicament>> completion) {
        app.postDB(()->{
            final List<Medicament> data = dao.getNewItems();
            if(completion != null) {
                new Handler(Looper.getMainLooper()).post(()->{
                    completion.accept(data);
                });
            }
        } );
        return null;
    }





}
