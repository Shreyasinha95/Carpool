package com.team43.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2500);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    Intent openMainActivity = new Intent("com.team43.carpool.SIGNIN");
                    startActivity(openMainActivity);
                }
            }
        };
        timer.start();
    }
}
