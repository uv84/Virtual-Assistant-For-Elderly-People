package com.example.vaep;
/*
* OWNER: Devanshu Srivastava
* PURPOSE: broadcast reciever for showing the notifications on time.
* */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.vaep.datalayer.AppDatabase;
import com.example.vaep.datalayer.Med;


public class AlarmReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        Med med = AppDatabase.getInMemoryDatabase(context).medModel().loadMedByName(intent.getStringExtra("medName").toString());
        /*
         *Calling the notification method to display the notification details
         */

        DisplayNotification displayNotification= new DisplayNotification(context);
        displayNotification.createNotification(med.medName,"Dosage: "+(med.dosage));

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library

    }

}
