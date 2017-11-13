package com.example.kopo.service_test;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by kopo on 2017-08-21.
 */

public class MusicPlayService extends Service{
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public  void onCreate(){
        android.util.Log.i("서비스 테스트", "onCreate()");
        super.onCreate();
    }

    @Override
    public  void onDestroy(){
        super.onDestroy();
        mp.stop();
        Log.d("Music", "Stopped!!!!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("Music", "Start!!!!");
        mp = MediaPlayer.create(this, R.raw.sleep);
        mp.setLooping(true);
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

}
