package com.Example.notificationdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by delaroy on 6/4/17.
 */
public class NotificationBroadcast extends BroadcastReceiver {
    private Intent playMusic;


    //  Create the broadcast reciver that will decide on what action to take when an action is made
    //  this is visualy denoted by the addtion of a toast to show the action taken
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Implemented 1", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onReceive: ");
      //  Intent boundIntent= new Intent(context, MyService.class);
        if (intent.getAction().equals(NotificationGenerator.NOTIFY_PLAY)) {
            playMusic = new Intent(context, MyService.class);
            playMusic.putExtra("data","play");

            context.startService(playMusic);
            Toast.makeText(context, "NOTIFY_PLAY", Toast.LENGTH_SHORT).show();

        } else if (intent.getAction().equals(NotificationGenerator.NOTIFY_PAUSE)) {

            playMusic = new Intent(context, MyService.class);
            playMusic.putExtra("data","pause");

            context.startService(playMusic);

            Toast.makeText(context, "NOTIFY_PAUSE", Toast.LENGTH_LONG).show();
//        } else if (intent.getAction().equals(NotificationGenerator.NOTIFY_NEXT)) {
//            Toast.makeText(context, "NOTIFY_NEXT", Toast.LENGTH_LONG).show();
//        } else if (intent.getAction().equals(NotificationGenerator.NOTIFY_DELETE)) {
//            Toast.makeText(context, "NOTIFY_DELETE", Toast.LENGTH_LONG).show();
       } else if (intent.getAction().equals(NotificationGenerator.NOTIFY_PREVIOUS)) {

            Intent playMusic = new Intent (context, MyService.class);
            playMusic.putExtra("data","stop");

            context.stopService(playMusic);

            Toast.makeText(context, "NOTIFY_STOP", Toast.LENGTH_LONG).show();
        }



        switch (intent.getAction()){
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

                if (isAirplaneModeOn)
                    Toast.makeText(context, "Airoplane mode on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Airoplane mode off", Toast.LENGTH_SHORT).show();
                break;

            case Intent.ACTION_POWER_CONNECTED:


                    Toast.makeText(context, "PowerConnected on", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_POWER_DISCONNECTED:

                    Toast.makeText(context, "PowerDisconnected yes", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_BATTERY_LOW:

                    Toast.makeText(context, "Battery is Low", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_SCREEN_ON:

                    Toast.makeText(context, "Screen is On", Toast.LENGTH_SHORT).show();
                 break;


        }


    }
}
