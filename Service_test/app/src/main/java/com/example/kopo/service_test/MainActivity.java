package com.example.kopo.service_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MusicPlayService.class);

        Button startBtn = null;
        Button stopBtn = null;

        startBtn = (Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startService(intent);
                Toast startToast = Toast.makeText(MainActivity.this, "자장가", Toast.LENGTH_SHORT);
                startToast.show();
                finish();
            }

        });

        stopBtn = (Button)findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stopService(intent);
                Toast stopToast = Toast.makeText(MainActivity.this, "재생 종료", Toast.LENGTH_SHORT);
                stopToast.show();
            }
        });

    }
}
