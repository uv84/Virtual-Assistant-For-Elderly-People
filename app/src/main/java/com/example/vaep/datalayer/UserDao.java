package com.example.vaep.datalayer;

//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface UserDao {
    @Query("select * from user")
    List<User> loadAllUsers();

    @Query("select userPresent from user")
    boolean userPresent();

    @Insert(onConflict = IGNORE)
    Long insertUser(User user);

    @Query("DELETE FROM user")
    int deleteUser();
}
