package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by koposw21 on 2017-08-23.
 */

public class khj extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khj);
        Button A = (Button)findViewById(R.id.front);
        Button B = (Button)findViewById(R.id.next);


        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), junwooActivity.class);
                startActivity(intent);
                finish();
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), kimjihyunActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
