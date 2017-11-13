package com.example.ydkim.testkopoporject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by KOPOCTC on 2017-08-23.
 */

public class Ohjihye extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ohjihye);

        Button btnBefore = (Button)findViewById(R.id.btnBefore);
        btnBefore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), namsgActivity.class);
                finish();
                startActivity(intent);

            }
        });

        Button btnFin = (Button)findViewById(R.id.btnFin);
        btnFin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });










    }
}
