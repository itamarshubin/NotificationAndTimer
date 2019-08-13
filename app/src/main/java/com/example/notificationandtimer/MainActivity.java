package com.example.notificationandtimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMassage;
    private EditText editTextTime;

    private long mTimeLeftInMillis;
    private long mEndTime;
    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMassage = findViewById(R.id.edit_text_massage);
        editTextTime = findViewById(R.id.edit_text_Timer);
    }

    public void sendOnChanel1(View v){
        if (editTextTime.getText().equals(""))
            mTimeLeftInMillis=0;
        else
        mTimeLeftInMillis = Integer.valueOf(editTextTime.getText().toString()).intValue();
        mTimeLeftInMillis *=1000;
        Log.d("thetime","massage"+mTimeLeftInMillis);
        startTimer();



    }
   /* public void sendOnChanel2(View v){
        String title = editTextTitle.getText().toString();
        String massage = editTextMassage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this,App.CHANEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(massage)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(2,notification);

    }*/

   private void startTimer(){
       mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

      mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
          @Override
          public void onTick(long millisUntilFinished) {
              mTimeLeftInMillis=millisUntilFinished;


          }

          @Override
          public void onFinish() {
            
              String title = editTextTitle.getText().toString();
              String massage = editTextMassage.getText().toString();
              Notification notification = new NotificationCompat.Builder(MainActivity.this,App.CHANEL_1_ID)
                      .setSmallIcon(R.drawable.ic_work)
                      .setContentTitle(title)
                      .setContentText(massage)
                      .setPriority(NotificationCompat.PRIORITY_HIGH)
                      .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                      .build();

              notificationManager.notify(1,notification);
          }
      }.start();
      editTextTime.setText("");


   }
}
