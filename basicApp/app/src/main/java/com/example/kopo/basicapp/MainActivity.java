package com.example.kopo.basicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button number_1;
        number_1 = (Button)findViewById(R.id.number_1);
        number_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "1",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button number_2;
        number_2 = (Button)findViewById(R.id.number_2);
        number_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "2",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button number_3;
        number_3 = (Button)findViewById(R.id.number_3);
        number_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "3",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button number_4;
        number_4 = (Button)findViewById(R.id.number_4);
        number_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "4",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button number_5;
        number_5 = (Button)findViewById(R.id.number_5);
        number_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "5",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button number_6;
        number_6 = (Button)findViewById(R.id.number_6);
        number_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "6",
                        Toast.LENGTH_SHORT).show();
            }
        });
        /*
        Button number_7;
        number_7 = (Button)findViewById(R.id.number_7);
        number_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "7",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button number_8;
        number_8 = (Button)findViewById(R.id.number_8);
        number_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "8",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button number_9;
        number_9 = (Button)findViewById(R.id.number_9);
        number_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "9",
                        Toast.LENGTH_SHORT).show();
            }
        });*/



    }
}
