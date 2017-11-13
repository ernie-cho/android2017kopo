package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kopo on 2017-08-23.
 */

public class choyoungdo_Activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choyoungdo);

        //뒤로 가기 버튼
        Button bBtn = (Button)findViewById(R.id.backBtn);
        bBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // go to MainActivity modified by cyd..
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //modified by cyd..
                finish();
            }
        });
        //다음 버튼
        Button nBtn = (Button)findViewById(R.id.nextBtn);
        nBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),dooooooo_Activity.class);
                startActivity(intent);
                //modified by cyd..
                finish();
            }
        });

    }

}
