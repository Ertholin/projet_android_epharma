package com.example.epharma_inf1030_h22_g3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Handler;
import android.os.Looper;

import androidx.multidex.MultiDexApplication;

import com.example.epharma_inf1030_h22_g3.database.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EphApp extends MultiDexApplication {

    public static final String CHANNEL_HIGH = "Notification_op_app";
    private boolean serviceBound;
    private ExecutorService diskIOExecutor = Executors.newSingleThreadExecutor();

    private AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = AppDatabase.instance(this);

    }

    public AppDatabase getDb(){
        return db;
    }

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public  void postDB(Runnable dbTask){
        executor.submit(dbTask);
    }

    private void initChannel() {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        NotificationChannel channel = new NotificationChannel(CHANNEL_HIGH,
                "Canal de notification de openApp",
                NotificationManager.IMPORTANCE_HIGH);
        channel.enableVibration(true);
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        channel.setVibrationPattern(new long[]{200, 100});
        channel.setSound(RingtoneManager
                        .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION),
                Notification.AUDIO_ATTRIBUTES_DEFAULT);

        notificationManager.createNotificationChannel(channel);

    }

    public  void fileIOTask(Runnable ioTask){
        diskIOExecutor.submit(ioTask);
    }

    public void mainTask(Runnable mainTask){
        if(mainTask !=null) {
            new Handler(Looper.getMainLooper()).post(mainTask);
        }
    }

}
