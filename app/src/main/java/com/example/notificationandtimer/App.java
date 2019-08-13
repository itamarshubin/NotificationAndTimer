package com.example.notificationandtimer;


import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANEL_1_ID = "chanel1";
    public static final String CHANEL_2_ID = "chanel2";


    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChanels();

    }

    private void createNotificationChanels(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel chanel1 = new NotificationChannel(
                    CHANEL_1_ID,
                    "chanel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            chanel1.setDescription("This is chanel NO. 1");

            NotificationChannel chanel2 = new NotificationChannel(
                    CHANEL_2_ID,
                    "chanel 1",
                    NotificationManager.IMPORTANCE_LOW
            );
            chanel2.setDescription("This is chanel NO. 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(chanel1);
            manager.createNotificationChannel(chanel2);

        }
    }

}
