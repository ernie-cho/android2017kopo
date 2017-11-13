package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 501ST01 on 2017-08-23.
 */

public class kimjihyunActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kimjihyun);

        // khj->kimjihyun 액티비티 전환
        Button button_festival = (Button)findViewById(R.id.kimjihyun_front_button);
        button_festival.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "액티비티 전환", Toast.LENGTH_LONG).show();

                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(),khj .class);
                startActivity(intent);
                finish();
            }
        });


        // kimjihyun->leedeukyeong 액티비티 전환
        Button button_next = (Button)findViewById(R.id.kimjihyun_next_button);
        button_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "액티비티 전환", Toast.LENGTH_LONG).show();

                // 액티비티 전환 코드
                Intent intent = new Intent(getApplicationContext(),Leedeukyeong .class);
                startActivity(intent);
                finish();
            }
        });
    }
}
