package com.example.vaep.datalayer;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface MedDao {
    @Query("select * from med")
    List<com.example.vaep.datalayer.Med> loadAllMeds();

    @Query("select * from med where id = :id")
    com.example.vaep.datalayer.Med loadMedById(int id);

    @Query("select * from med where medName = :medname")
    com.example.vaep.datalayer.Med loadMedByName(String medname);

    @Insert(onConflict = IGNORE)
    void insertMeds(com.example.vaep.datalayer.Med med);

    @Query("DELETE FROM med")
    void deleteAll();

    @Query("select * from med where startDate = :StartDate")
    List<com.example.vaep.datalayer.Med> loadMedByDate(String StartDate);

    @Query("select * from med where tagDaily = :tagDaily")
    List<com.example.vaep.datalayer.Med> loadMedByTag(int tagDaily);

}