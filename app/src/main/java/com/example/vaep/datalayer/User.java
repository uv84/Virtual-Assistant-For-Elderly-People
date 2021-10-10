package com.example.vaep.datalayer;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    public String firstName;
    public String lastName;
    public String age;
    public String emailID;
    public boolean userPresent;
}