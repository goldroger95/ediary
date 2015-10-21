package com.example.devanksriram.ediary;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

public class MyGcmListenerService extends GcmListenerService {
    public MyGcmListenerService() {
    }
    @Override
    public void onMessageReceived(String from,Bundle data){
        String date=data.getString("message");//gets a date when student is absent
        Log.d('From',"From : " + from );
        Log.d('Date',"Date: "+ date);
        //add the date to sqlite database
        //restart calender view activity
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
