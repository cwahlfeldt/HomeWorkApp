package com.chriswahlfeldt.homeworkapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class MyReminder{

    // const's
    final static private long ONE_SECOND = 1000;
    final static private long TWENTY_SECONDS = ONE_SECOND * 20;

    // private vars
    private AlarmManager alrmMang;
    private PendingIntent pi;
    private BroadcastReceiver br;

    public MyReminder() {
        // do not use;
    }

    // constructor
    public MyReminder(Context context) {


    }

//    private void setup(Context context) {
//        br = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context c, Intent i) {
//                Toast.makeText(c, "Rise and Shine!", Toast.LENGTH_LONG).show();
//            }
//        };
//        registerReceiver(br, new IntentFilter("com.chriswahlfeldt.homeworkapp"));
//        pi = PendingIntent.getBroadcast( context, 0, new Intent("com.chriswahlfeldt.homeworkapp"),
//                0 );
//        alrmMang = (AlarmManager)(context.getSystemService(Context.ALARM_SERVICE));
//    }

}