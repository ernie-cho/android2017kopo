package com.example.kopo.restapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Thread 일을 다른데 시켜놓고, 자기는 본인 일을 한다.
        //안드로이드 정책상 Thread 만들지 않으면, 오류가 난다.
        Button tBtn = (Button)findViewById(R.id.threadBtn);
        tBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                AsyncTask.execute(new Runnable() {
                    @Override

                    public void run() {
                        try{

                            // All your networking logic
                            // should be here
                            //create URL
                            URL githubEndpoint = new URL("https://dapi.kakao.com/v2/search/vclip?query=해외축구");
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



    }
}
//web의 장점을 최대한 활용 할 수 있는 네트워크 기반의 아키텍쳐