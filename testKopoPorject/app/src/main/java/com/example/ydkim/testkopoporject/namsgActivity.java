package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 10 on 2017-08-23.
 */

public class namsgActivity  extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namsg);

        Button front = (Button) findViewById(R.id.btnStart);
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),
                        Leedeukyeong.class);
                startActivity(intent1);
                finish(); //2017-08-28 ACTIVITY 종료
            }
        });

        Button back = (Button) findViewById(R.id.btnStop);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),
                        Ohjihye.class);
                startActivity(intent1);
                finish(); //2017-08-28 ACTIVITY 종료
            }
        });
    }

}
