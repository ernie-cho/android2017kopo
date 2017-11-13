package com.example.kopo.intent_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kopo on 2017-08-07.
 */

public class drawActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw);

        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        for(int i = 0; i < 9 ; i++){
            voteCount[i] =0;
        }

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,
                R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};
        final String imgName [] = {"독서하는 소녀", "눈물", "모나리자", "소녀",
                "차차", "줄리엣", "모자소녀", "탱크탑", "샤갈"};

        for(int i = 0; i<imageId.length; i++){
            final int index; //주의! 꼭 필요함.
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + "표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });
    }
}
