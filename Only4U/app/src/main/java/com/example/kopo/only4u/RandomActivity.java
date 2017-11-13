package com.example.kopo.only4u;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

public class RandomActivity extends AppCompatActivity {
    private TextView tv;
    String saveName;
    //url용 글자 받을 배열
    String[] getName ={"","","",""} ;
    ////////////////////
  //  public final static String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    //public final static String VIDEO_URL = "http://sports.news.naver.com/esports/vod/index.nhn?uCategory=esports&category=lol&id=335827&redirect=true";
    VideoView videoView1;
    VideoView videoView2;
    VideoView videoView3;
    VideoView videoView4;

    ///////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        tv = (TextView) findViewById(R.id.resultView);
        Intent it=getIntent();      //인텐트 받기 선언

        //이전에 보냈던 it_check의 값을 받아 str에 저장
        String str= it.getStringExtra("it_check");
       int cntNum= it.getIntExtra("no_check", 0);
        //ArrayList<String> str1= it.getStringArrayListExtra("checked");
        //for문으로 url용 글자 받기
        for(int i = 0; i < 4; i++ ){
            getName[i] = it.getStringExtra("checked"+i);
            Log.d("line", "ffffffffffffffffffff");
            Log.d("line", getName[i]);
        }
        String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
        String VIDEO_URL2 ="http://www.ithinknext.com/mydata/board/files/F201308021823010.mp4";
        String VIDEO_URL3 ="https://googlechrome.github.io/samples/muted-autoplay/chrome-clip.mp4";
        String VIDEO_URL4 ="http://www.html5videoplayer.net/videos/toystory.mp4";
        tv.setText(str + "\n중 랜덤 영상");
        Log.d("알림", str);
        // 선택된 값을 배열에 정제하여 저장
        String[] parseStr;
        parseStr = str.split(",");
      // int ArrayLength = parseStr.length;
        int ArrayLength = cntNum;
        //Log.d("알림0", parseStr[0]);
       // Log.d("알림1", parseStr[1]);
       // Log.d("알림2", parseStr[ArrayLength-1]);
        //랜덤 숫자생성
        Random ranNum =  new Random();
        //배열 크기를 최대로한 랜덤 숫자 생성
        int selectedNum =0;
        //if(ArrayLength == 1) {
        //    selectedNum = ranNum.nextInt(ArrayLength+1);
       // }else {
            selectedNum = ranNum.nextInt(ArrayLength);
       // }


        saveName = parseStr[selectedNum];
        Log.d("알림선택", parseStr[selectedNum]);
        //Thread 일을 다른데 시켜놓고, 자기는 본인 일을 한다.
        //안드로이드 정책상 Thread 만들지 않으면, 오류가 난다.

        Button tBtn = (Button)findViewById(R.id.randomBtn);
        tBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                AsyncTask.execute(new Runnable() {
                    @Override

                    public void run() {
                        try{

                            // All your networking logic
                            // should be here
                            //create URL
                            //URL githubEndpoint = new URL("https://dapi.kakao.com/v2/search/vclip?query="+saveName+" 노래");
                            URL githubEndpoint = new URL("https://dapi.kakao.com/v2/search/vclip?query="+saveName+" 음악");
                            //create connection
                            HttpsURLConnection myConnection = (HttpsURLConnection)githubEndpoint.openConnection();
                            //myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");
                            //myConnection.setRequestProperty("Accept", "application/vnd.github.v3+json");
                            //myConnection.setRequestProperty("Contact-Me", "hathibelagal@example.com");
                            myConnection.setRequestProperty("Authorization", "KakaoAK f0c29957965d3d28d940362b9c15fa61");

                            if(myConnection.getResponseCode() == 200){
                                //Success

                                InputStream responseBody = myConnection.getInputStream();
                                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                                //JSON 분석
                                JsonReader jsonReader = new JsonReader(responseBodyReader);
                                jsonReader.beginObject(); //start processing the JSON object
                                while (jsonReader.hasNext()){ //Loop through all keys
                                    String key = jsonReader.nextName(); //Fetch the next key
                                    /*if(key.equals("organization_url")){ //Check if desired key
                                        //Fetch the value as a String
                                        String value = jsonReader.nextString();
                                        Log.d("TEST", value);
                                        break; //Break out of the loop
                                    }else {
                                        jsonReader.skipValue(); //Skip values of other keys
                                    }*/
                                    Log.d("REST",key);
                                    if(key.equals("documents")) {
                                        jsonReader.beginArray();
                                        jsonReader.beginObject();
                                    } else if(key.equals("title")) {
                                        String value = jsonReader.nextString();
                                        Log.d("REST",value);
                                    }else if(key.equals("url")) {
                                        String url = jsonReader.nextString();
                                        Log.d("REST",url);
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                        startActivity(intent);
                                    }else {
                                        jsonReader.skipValue();
                                    }
                                    // jsonReader.skipValue(); //Skip values of other keys
                                }
                                jsonReader.close();
                                myConnection.disconnect();
                            }else {
                                //Error handling code goes here
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        //-------------여기서 video view 시작
        videoView1 = (VideoView) findViewById(R.id.videoView33);
        MediaController controller1 = new MediaController(RandomActivity.this);
        videoView1.setMediaController(controller1);
        videoView1.requestFocus();
        videoView1.setVideoURI(Uri.parse(VIDEO_URL));

        videoView2 = (VideoView) findViewById(R.id.videoView44);
        MediaController controller2 = new MediaController(RandomActivity.this);
        videoView2.setMediaController(controller2);
        videoView2.requestFocus();
        videoView2.setVideoURI(Uri.parse(VIDEO_URL2));

        videoView3 = (VideoView) findViewById(R.id.videoView55);
        MediaController controller3 = new MediaController(RandomActivity.this);
        videoView3.setMediaController(controller3);
        videoView3.requestFocus();
        videoView3.setVideoURI(Uri.parse(VIDEO_URL3));

        videoView4 = (VideoView) findViewById(R.id.videoView66);
        MediaController controller4 = new MediaController(RandomActivity.this);
        videoView4.setMediaController(controller4);
        videoView4.requestFocus();
        videoView4.setVideoURI(Uri.parse(VIDEO_URL4));




    }
}
//web의 장점을 최대한 활용 할 수 있는 네트워크 기반의 아키텍쳐