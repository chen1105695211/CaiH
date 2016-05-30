package com.caih.caih;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AutoLayoutActivity {

    Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            if(msg.what==111){
                startActivity(new Intent(SplashActivity.this,StartActivity.class));
                timer.cancel();
                finish();
            }
        }
    };
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendMessage(handler.obtainMessage(111));
            }
        }, 2000, 2000);



    }
}
