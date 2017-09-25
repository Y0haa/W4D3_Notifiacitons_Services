package com.Example.notificationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button openActivityBtn;
    private Intent playMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openActivityBtn = (Button) findViewById(R.id.btnNotificationActivity);


/*
        openActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NotificationGenerator.openActivityNotification(getApplicationContext());
                Intent intent = new Intent(view.getContext(), MyService.class);
                startService(intent);

            }
        });
*/
//        openBigContent.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                NotificationGenerator.customBigNotification(view.getContext());
//            }
//        });
    }
//          On Clicks in activity to set up buttons
    public void myclicks(View view) {

        switch (view.getId()){


            case R.id.playContentbig:

                NotificationGenerator.customBigNotification(view.getContext());

                playMusic = new Intent(this, MyService.class);
                playMusic.putExtra("data","play");

                startService(playMusic);

                break;

            case R.id.StopContentbig:

                Intent playMusic = new Intent (this, MyService.class);
                playMusic.putExtra("data","stop");

                stopService(playMusic);

                break;

            case R.id.pauseContentbig:

                playMusic = new Intent(this, MyService.class);
                playMusic.putExtra("data","pause");

                startService(playMusic);

                break;

        }
    }
}
