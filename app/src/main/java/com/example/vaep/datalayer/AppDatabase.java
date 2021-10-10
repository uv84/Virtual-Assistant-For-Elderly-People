package com.example.vaep.datalayer;


//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.RoomDatabase;
//import android.arch.persistence.room.TypeConverters;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import com.example.vaep.Converter;

@Database(entities = {Med.class,User.class}, version = 1)
@TypeConverters(Converter.class) //https://developer.android.com/reference/android/arch/persistence/room/TypeConverter

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract MedDao medModel();

    public abstract UserDao userModel();


    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Remainder")
                            // To simplify the codelab, allow queries on the main thread.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

}
