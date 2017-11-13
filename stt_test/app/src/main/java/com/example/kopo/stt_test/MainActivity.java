package com.example.kopo.stt_test;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);    //intent 생성
        i.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());    //호출한 패키지
        //한국어 버튼
        Button sBtn = (Button)findViewById(R.id.sttBtn);
        sBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");                   //음성인식 언어 설정-한국어
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "한국어.");                   //사용자에게 보여 줄 글자
                startActivityForResult(i, 1000);
            }
        });
        Button engBtn = (Button)findViewById(R.id.enBtn);
        engBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");                   //음성인식 언어 설정-영어
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "영어.");                     //사용자에게 보여 줄 글자
                startActivityForResult(i, 1000);
            }
        });
        Button japBtn = (Button)findViewById(R.id.jpBtn);
        japBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "jp-JR");                   //음성인식 언어 설정-일어
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "일어.");                     //사용자에게 보여 줄 글자
                startActivityForResult(i, 1000);
            }
        });
        Button fraBtn = (Button)findViewById(R.id.frBtn);
        fraBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "fr-FR");                   //음성인식 언어 설정-프랑스어
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "프랑스어.");                 //사용자에게 보여 줄 글자
                startActivityForResult(i, 1000);
            }
        });
    }
    private ArrayList<String> mResult;
    private String mSelectedString;

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( resultCode == RESULT_OK && requestCode == 1000){
            String key = RecognizerIntent.EXTRA_RESULTS;
            mResult = data.getStringArrayListExtra(key);        //인식된 데이터 list 받아옴.
            String[] result = new String[mResult.size()];       //배열생성. 다이얼로그에서 출력하기 위해
            mResult.toArray(result);                            //list 배열로 변환

            //첫번째 표시되는것으로 바로 띄우기
            mSelectedString = mResult.get(0);
            Log.d("VoiceApp", mSelectedString);
            //발음하는대로 체크해보기
            if(mSelectedString.toLowerCase().equals("internet")){
                Toast.makeText(getApplicationContext(), "발음 굿!!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "발음을 제대로 해보세요!!", Toast.LENGTH_LONG).show();
            }
            //1개 선택하는 다이얼 로그 생성
            /*AlertDialog ad = new AlertDialog.Builder(this).setTitle("선택하세요.")
                    .setSingleChoiceItems(result, -1, new DialogInterface.OnClickListener(){
                        @Override public void onClick(DialogInterface dialog, int which){
                            mSelectedString = mResult.get(which);           //선택하면 해당 글자 저장
                        }
                    })
                    .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            Log.d("VoiceApp", mSelectedString);
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            //취소버튼 눌렀을 때
                        }
                    }).create();
            ad.show();*/
        }
    }
}
