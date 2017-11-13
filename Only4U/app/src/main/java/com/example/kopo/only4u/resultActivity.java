package com.example.kopo.only4u;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by kopo on 2017-08-04.
 */

public class resultActivity extends Activity {
    private TextView tv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv = (TextView) findViewById(R.id.resultView);
        Intent it=getIntent();      //인텐트 받기 선언

        //이전에 보냈던 it_check의 값을 받아 str에 저장
        String str= it.getStringExtra("it_check");
        tv.setText(str + "\n관련 영상");

    }
}
