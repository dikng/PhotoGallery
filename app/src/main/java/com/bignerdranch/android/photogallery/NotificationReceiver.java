package com.bignerdranch.android.photogallery;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;

public class NotificationReceiver extends BroadcastReceiver {
    private static final String TAG = " NotificationReceiver";

    @RequiresApi(api = 26)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Received result: " + getResultCode());
        if(getResultCode() != Activity.RESULT_OK){
            //A foreground activity canceled the broadcast
            return;
        }

        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        int requestCode = intent.getIntExtra(PollService.REQUEST_CODE, 0);
        Notification notification = intent.getParcelableExtra(PollService.NOTIFICATION);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = intent.getStringExtra(PollService.CHANNELID);
            String channelName = intent.getStringExtra(PollService.CHANNELNAME);
            NotificationChannel mChannel = new NotificationChannel(channelId, channelName,
                    NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(mChannel);
        }
        Log.i("通知接收器", "进入");
        manager.notify(requestCode, notification);
    }
}
