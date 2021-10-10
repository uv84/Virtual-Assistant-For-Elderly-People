package com.example.vaep;

import java.util.ArrayList;

public class MedicineSchedule {
    static private ArrayList<ArrayList<String>> weekSchedule;

    static private String name;
    static private String dosage;
    static private String startDate;
    static private String endDate;
    static private String path;
    static private int isDaily;

    public MedicineSchedule() {
        weekSchedule = new ArrayList<ArrayList<String>>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setIsDaily(int isDaily) {
        this.isDaily = isDaily;
    }

    public void setDrugBoxImagePath(String path) {
        this.path = path;
    }

    public String getName() {
        return this.name;
    }

    public String getDosage() {
        return this.dosage;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public int getIsDaily() {
        return this.isDaily;
    }

    public String getDrugBoxImagePath() {
        return this.path;
    }

    public ArrayList<ArrayList<String>> getWeekSchedule() {
        return this.weekSchedule;
    }
}
