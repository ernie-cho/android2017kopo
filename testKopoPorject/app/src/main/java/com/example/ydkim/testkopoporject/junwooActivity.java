package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by s on 2017-08-23.
 */

public class junwooActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.junwoo);
        Button preBtn = (Button)findViewById(R.id.preNext);
        Button nextBtn = (Button)findViewById(R.id.next);
        preBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),GwangWon_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),khj.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
