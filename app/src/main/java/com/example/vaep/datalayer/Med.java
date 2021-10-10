package com.example.vaep.datalayer;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Med {

    @PrimaryKey(autoGenerate = true)@NonNull
    public int id;
    public int tagDaily; //this flag is for tagging daily meds.
    public String medName;
    public String dosage;
    public String imagePath;
    public String startDate;
    public String endDate;
    public ArrayList<ArrayList<String>> timeObject = new ArrayList<ArrayList<String>>();
    public Med() {
    }

    public Med(int id, int tagDaily, String medName, String dosage, String imagePath, String startDate, String endDate, ArrayList<ArrayList<String>> arrTimeItem){
        this.id = id;
        this.tagDaily = tagDaily;
        this.medName= medName;
        this.dosage= dosage;
        this.imagePath= imagePath;
        this.startDate= startDate;
        this.endDate= endDate;
        this.timeObject.addAll(arrTimeItem);
    };
}
