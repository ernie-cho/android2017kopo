package com.example.kopo.only4u;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by kopo on 2017-08-04.
 */

public class searchActivity extends ActionBarActivity implements OnCheckedChangeListener {

    private TextView tv;
    private CheckBox cb1, cb2, cb3, cb4, cb5;
    private CheckBox cb6, cb7, cb8, cb9, cb10;
    private CheckBox cb11, cb12, cb13, cb14, cb15;
    String savedResult = "";
    int savedCnt =0;
    String[] sendURL = {"","","",""}; //url저장용 배열
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //searchLayout가져오기
        final LinearLayout mylayout = (LinearLayout) findViewById(R.id.searchlayout);

        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb6 = (CheckBox) findViewById(R.id.checkBox6);
        cb7 = (CheckBox) findViewById(R.id.checkBox7);
        cb8 = (CheckBox) findViewById(R.id.checkBox8);
        cb9 = (CheckBox) findViewById(R.id.checkBox9);
        cb10 = (CheckBox) findViewById(R.id.checkBox10);
        cb11 = (CheckBox) findViewById(R.id.checkBox11);
        cb12 = (CheckBox) findViewById(R.id.checkBox12);
        cb13 = (CheckBox) findViewById(R.id.checkBox13);
        cb14 = (CheckBox) findViewById(R.id.checkBox14);
        cb15 = (CheckBox) findViewById(R.id.checkBox15);
        tv = (TextView) findViewById(R.id.textView2);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);
        cb6.setOnCheckedChangeListener(this);
        cb7.setOnCheckedChangeListener(this);
        cb8.setOnCheckedChangeListener(this);
        cb9.setOnCheckedChangeListener(this);
        cb10.setOnCheckedChangeListener(this);
        cb11.setOnCheckedChangeListener(this);
        cb12.setOnCheckedChangeListener(this);
        cb13.setOnCheckedChangeListener(this);
        cb14.setOnCheckedChangeListener(this);
        cb15.setOnCheckedChangeListener(this);

        cb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb1);
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb2);
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb3);
            }
        });
        cb4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb4);
            }
        });
        cb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb5);
            }
        });
        cb6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb6);
            }
        });
        cb7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb7);
            }
        });
        cb8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb8);
            }
        });
        cb9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb9);
            }
        });
        cb10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb10);
            }
        });
        cb11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb11);
            }
        });
        cb12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb12);
            }
        });
        cb13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb13);
            }
        });
        cb14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb14);
            }
        });
        cb15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mylayout.setBackgroundResource(R.drawable.cb15);
            }
        });



    }

    //추천영상에 들어갈 arrayList 선언
    ArrayList<String> recommandList = new ArrayList<String>();
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 체크박스를 클릭해서 상태가 바꾸었을 경우 호출되는 콜백 메서드

        String result = ""; // 문자열 초기화는 빈문자열로 하자

//        if(isChecked) tv.setText("체크했음");
//        else tv.setText("체크안했슴");
        int countSelect =0;
        // 혹은 3항연산자
        //tx.setText(isChecked?"체크했슴":"체크안했뜸");

        if (cb1.isChecked()) {
            result += cb1.getText().toString() + ",";
            countSelect++;
        }
        if (cb2.isChecked()) {
            result += cb2.getText().toString() + ",";
            countSelect++;
        }
        if (cb3.isChecked()) {
            result += cb3.getText().toString() + ",";
            countSelect++;
        }
        if (cb4.isChecked()) {
            result += cb4.getText().toString() + ",";
            countSelect++;
        }
        if (cb5.isChecked()) {
            result += cb5.getText().toString() + ",";
            countSelect++;
        }
        if (cb6.isChecked()) {
            result += cb6.getText().toString() + ",";
            countSelect++;
        }
        if (cb7.isChecked()) {
            result += cb7.getText().toString() + ",";
            countSelect++;
        }
        if (cb8.isChecked()) {
            result += cb8.getText().toString() + ",";
            countSelect++;
        }
        if (cb9.isChecked()) {
            result += cb9.getText().toString() + ",";
            countSelect++;
        }
        if (cb10.isChecked()) {
            result += cb10.getText().toString() + ",";
            countSelect++;
        }
        if (cb11.isChecked()) {
            result += cb11.getText().toString() + ",";
            countSelect++;
        }
        if (cb12.isChecked()) {
            result += cb12.getText().toString() + ",";
            countSelect++;
        }
        if (cb13.isChecked()) {
            result += cb13.getText().toString() + ",";
            countSelect++;
        }
        if (cb14.isChecked()) {
            result += cb14.getText().toString() + ",";
            countSelect++;
        }
        if (cb15.isChecked()) {
            result += cb15.getText().toString() + ",";
            countSelect++;
        }
        savedCnt = countSelect;
        tv.setText("체크항목: "+ countSelect+"개 선택 " + result + "중 추천");
        //체크된 값을 배열에 값을 저장
        String[] selectedName=result.split(",");
        for(int i=0; i<selectedName.length; i++) {
            recommandList.add(selectedName[i]);
        }
        Log.d("선택1번", recommandList.get(0));
        //Log.d("선택2번", recommandList.get(1));
        Log.d("숫자", String.valueOf(savedCnt));

       //검색 버튼
        Button sBtn = (Button) findViewById(R.id.searchBtn);
        savedResult = result;
        sBtn.setOnClickListener(new View.OnClickListener() {

            Intent intent = new Intent(getApplicationContext(), RandomActivity.class);
            public void onClick(View v) {

                intent.putExtra("it_check", savedResult);
                intent.putExtra("no_check", savedCnt);
                //선택된 데이터를 url로 받아온다.
                //변수 선언
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        URL fourUrl = null;
                        HttpsURLConnection urlConnection = null;
                        BufferedInputStream buf = null;
//String test = null;
                        try {
                            //웹서버 URL 지정
                            if(savedCnt == 1){ //선택된 값이 1개일 때
                                fourUrl =  new URL ("https://dapi.kakao.com/v2/search/vclip?query="+recommandList.get(0)+"&size=4");
                            }else if(savedCnt == 2){ //선택된 값이 2개 일때
                                fourUrl = new URL("https://dapi.kakao.com/v2/search/vclip?query="+recommandList.get(0)+" "+recommandList.get(1)+"&size=4");
                            }else if(savedCnt >= 3){ //선택된 값이 3개 이상 일때
                                fourUrl = new URL("https://dapi.kakao.com/v2/search/vclip?query="+recommandList.get(0)+" "+recommandList.get(1)+" "+recommandList.get(2)+"&size=4");
                            }


                            //URL 접속
                            Log.d("line:","0번 통과");
                            Log.d("1111111111111", recommandList.get(0));
                            urlConnection = (HttpsURLConnection) fourUrl.openConnection();
                            Log.d("line:","1번 통과");
                            urlConnection.setRequestProperty("Authorization", "KakaoAK f0c29957965d3d28d940362b9c15fa61");
                            //데이터를 버퍼에 기록
                            Log.d("line:","2번 통과");
                            //JSON 분석
                            BufferedReader bufreader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
                            Log.d("line:","3번 통과");
                    /*fourUrl = new URL(test);
                    Log.d("테스트2222222", test);
                    */
                            String line = null;
                            String page = "";

                            //버퍼의 웹문서 소스를 줄단위로 읽어(line), Page에 저장함
                            while((line = bufreader.readLine())!=null){
                                Log.d("line:",line);
                                page+=line;
                            }
                            Log.d("line:","4번 통과");
                            //읽어들인 JSON포맷의 데이터를 JSON객체로 변환
                            JSONObject json = new JSONObject(page);
                            Log.d("line:","5번 통과");
                            //documents 에 해당하는 배열을 할당
                            JSONArray jArr = json.getJSONArray("documents");
                            Log.d("line:","6번 통과");
                            //배열의 크기만큼 반복하면서, name과 address의 값을 추출함
                            for (int i=0; i<jArr.length(); i++){

                                //i번째 배열 할당
                                json = jArr.getJSONObject(i);

                                //ksNo,korName의 값을 추출함
                                String saveURL = json.getString("thumbnail");
                                Log.d("line", saveURL );

                                //배열에 URL 4개 저장
                                sendURL[i] = saveURL;
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        for(int i =0; i<4; i++){
                            Log.d("line", sendURL[i]);
                        }

                        //만들어진 4개의 url을 보내준다
                        //intent.putExtra("checked", recommandList);
                        for(int i = 0; i < sendURL.length; i++ ){
                            intent.putExtra("checked"+i, sendURL[i]);
                        }
                        Log.d("line:","7번 통과");
                        startActivity(intent);
                    }
                });


            }
        });
    }



}


//출처: http://es1015.tistory.com/19 [개발 / 폰꾸미기]