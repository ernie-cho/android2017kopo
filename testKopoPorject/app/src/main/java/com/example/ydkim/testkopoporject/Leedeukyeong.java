package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 504ST-13 on 2017-08-23.
 */

public class Leedeukyeong extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leedeukyeong);

        // Before btn
        Button btnBefore = (Button)findViewById(R.id.btnBefore);
        btnBefore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), kimjihyunActivity.class);
                finish();               // 이 페이지 닫고
                startActivity(intent);  // 이전 페이지 열기
            }
        });

        // Next btn
        Button btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), namsgActivity.class);
                finish();               // 이 페이지 닫고
                startActivity(intent);  // 다음 페이지 열기
            }
        });




    }
}