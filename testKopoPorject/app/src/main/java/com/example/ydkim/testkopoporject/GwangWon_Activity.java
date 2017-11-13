package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by JK on 2017-08-23.
 */


public class GwangWon_Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gwangwon);

        Animation flowAnim;
        TextView Gtext;

        // 텍스트뷰
        Gtext = (TextView) findViewById(R.id.Gtext);
        Gtext.setText("손광원");
        flowAnim = AnimationUtils.loadAnimation(this, R.anim.flow);

        Gtext.startAnimation(flowAnim);

        Button GBACKbtn = (Button) findViewById(R.id.GBACKbtn);
        GBACKbtn.setOnClickListener(new View.OnClickListener() {
            public void  onClick(View v) {
                // 토스트 메세지
                Toast.makeText(getApplicationContext(), "양두원", Toast.LENGTH_LONG).show();
                // 액티비티 전환
                Intent intent = new Intent(getApplicationContext(), dooooooo_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        Button GNEXTbtn = (Button) findViewById(R.id.GNEXTbtn);
        GNEXTbtn.setOnClickListener(new View.OnClickListener() {
            public void  onClick(View v) {
                // 토스트 메세지
                Toast.makeText(getApplicationContext(), "양준우", Toast.LENGTH_LONG).show();
                // 액티비티 전환
                Intent intent = new Intent(getApplicationContext(), junwooActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}