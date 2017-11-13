package com.example.kopo.activity_0803;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kopo on 2017-08-03.
 */

public class ThirdActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);

        Button button = (Button)findViewById(R.id.ThirdButton);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                finish();
            }
        });
    }
}
