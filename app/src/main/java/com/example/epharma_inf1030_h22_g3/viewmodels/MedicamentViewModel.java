package com.example.epharma_inf1030_h22_g3.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.epharma_inf1030_h22_g3.database.repository.MedicamentRepository;
import com.example.epharma_inf1030_h22_g3.models.Medicament;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

public class MedicamentViewModel extends AndroidViewModel {
    private MedicamentRepository repo;
    private LiveData<List<Medicament>> medicaments;
    private Medicament currentMedicament;

    public MedicamentViewModel(Application application) {
        super(application);
        repo = new MedicamentRepository(application);
    }

    public LiveData<List<Medicament>> liveAll(){
        if(medicaments == null){
            medicaments = repo.liveAll();
        }
        return medicaments;
    }

    public void getAsyncAll(Consumer<List<Medicament>> callback){
        repo.getAsyncAll(callback);
    }


    public void save(Medicament medicament, Runnable completion){
        repo.insert(completion, medicament);
        medicament.setUpdated(LocalDateTime.now());
        medicament.setNeedUpdate(true);
    }

    public Medicament getCurrentMedicament(){
        return currentMedicament;
    }

    public void newMedicament(){
        this.currentMedicament = new Medicament();
        currentMedicament.setDci("");
        currentMedicament.setDosage("");
        currentMedicament.setForm("");
    }

    public void setCurrentMedicament(Medicament currentMedicament){
        this.currentMedicament = currentMedicament;
    }
}
