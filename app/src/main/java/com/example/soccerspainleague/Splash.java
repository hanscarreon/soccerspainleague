package com.example.soccerspainleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.soccerspainleague.service.DataController;

public class Splash extends AppCompatActivity {

    CountDownTimer countDownTimer;
    DataController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        controller = new DataController(this);
        controller.clearContents();
        controller.getLeagueSpain();
        controller.getTeamsSpain();
        controller.getGamesSpain();
        controller.getLiveSpain();


        getData();

//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(Splash.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 4000);
    }

    public void getData(){
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(controller.retrieveLeagues() != null && controller.retrieveGames() != null && controller.retrieveTeams() != null){
                    Intent intent = new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    getData();
                }
            }
        }.start();
    }
}