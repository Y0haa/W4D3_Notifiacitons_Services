package com.Example.notificationdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Admin on 9/20/2017.
 */

public class MyService extends Service {

    MediaPlayer Song;
    boolean IsSongLoaded = false;

    //      Class extends the service and Method is used to call the play and pause actions in the
    //      notificaiton broadcast

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {

        try {
            if (IsSongLoaded == false) {
                Song = MediaPlayer.create(this, R.raw.music_batman);
                IsSongLoaded = true;
            }

            String a = intent.getStringExtra("data");

            Toast.makeText(this, " reciever " + a, Toast.LENGTH_SHORT).show();

            // Song = MediaPlayer.create(this, R.raw.music_batman);
            Song.start();


            if (a.equals("play")) {
                Song.start();
            } else if (a.equals("pause")) {
                Song.pause();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }


//        try {
//            action = intent.getStringExtra("data");
//        } catch (Exception e) {
//
//        }
//





         return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        try {
            IsSongLoaded = false;
            Song.stop();
            super.onDestroy();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
