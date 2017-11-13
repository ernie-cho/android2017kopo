package com.example.kopo.intent_example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.kopo.intent_example.R.id.btnDec;
import static com.example.kopo.intent_example.R.id.btnInc;

public class MainActivity extends AppCompatActivity {
    private TimerTask mTask;
    private Timer mTimer;
    RatingBar rating1, rating2, rating3;
    Button btnIncc, btnDecc, drawBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //증가
        ////////////////////////////////////////
        mTask = new TimerTask() {
            @Override
            public void run() {
                rating1.setRating(rating1.getRating()+rating1.getStepSize());
                rating2.setRating(rating1.getRating()+rating2.getStepSize());
                rating3.setRating(rating1.getRating()+rating3.getStepSize());
            }
        };

        mTimer = new Timer();

        //mTimer.schedule(mTask, 5000);
        mTimer.schedule(mTask, 2000, 1000);

        ///////////////////////////////////////

        rating1 = (RatingBar) findViewById(R.id.ratingBar1);
        rating2 = (RatingBar) findViewById(R.id.ratingBar2);
        rating3 = (RatingBar) findViewById(R.id.ratingBar3);
        btnIncc = (Button) findViewById(btnInc);
        btnDecc = (Button) findViewById(btnDec);
        drawBtn1 = (Button) findViewById(R.id.drawBtn);
        //증가 버튼 눌렀을때 실행
        btnIncc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                rating1.setRating(rating1.getRating()+rating1.getStepSize());
                rating2.setRating(rating1.getRating()+rating2.getStepSize());
                rating3.setRating(rating1.getRating()+rating3.getStepSize());
            }
        });
        //감소 버튼 눌렀을때 실행
        btnDecc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                rating1.setRating(rating1.getRating()-rating1.getStepSize());
                rating2.setRating(rating1.getRating()-rating2.getStepSize());
                rating3.setRating(rating1.getRating()-rating3.getStepSize());
            }
        });

        drawBtn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),drawActivity.class);
                startActivity(intent);
            }
        });


    }
}
