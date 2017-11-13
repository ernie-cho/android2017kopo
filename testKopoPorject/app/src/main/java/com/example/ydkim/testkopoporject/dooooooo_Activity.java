package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by admin on 2017-08-23.
 */

public class dooooooo_Activity extends Activity {

    Animation flowAnim;
    TextView dooooooo_txt;
    Button btn_backward;
    Button btn_foreward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.dooooooo);

        dooooooo_txt = (TextView) findViewById(R.id.dooooooo_txt);
        dooooooo_txt.setText("양두원입니다.");
        flowAnim = AnimationUtils.loadAnimation(this, R.anim.flow);

        dooooooo_txt.startAnimation(flowAnim);

        btn_backward = (Button) findViewById(R.id.btn_backward);
        btn_foreward = (Button) findViewById(R.id.btn_foreward);

        btn_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), choyoungdo_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_foreward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GwangWon_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
