package com.example.epharma_inf1030_h22_g3.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.epharma_inf1030_h22_g3.models.Medicament;

import java.util.List;

@Dao
public interface MedicamentDAO {

    @Query("SELECT * FROM Medicament")
    LiveData<List<Medicament>> getLiveAll();

    @Query("SELECT * FROM Medicament WHERE needUpdate")
    List<Medicament> getNewItems();

    @Query("SELECT * FROM Medicament WHERE drugnumber = :drugnumber")
    LiveData<Medicament> getLive(String drugnumber);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Medicament... Medicaments);

    @Delete()
    void delete(Medicament... Medicaments);

    @Query("SELECT * FROM Medicament")
    List<Medicament> getAll();


}
