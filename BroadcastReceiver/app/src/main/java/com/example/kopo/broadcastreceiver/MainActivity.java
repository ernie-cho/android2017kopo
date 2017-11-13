package com.example.kopo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivBattery;
    EditText edtBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배터리 상태 체크");

        ivBattery = (ImageView) findViewById(R.id.ivBattery);
        edtBattery = (EditText) findViewById(R.id.edtBattery);
    }

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                edtBattery.setText("현재 충전량 : " + remain + " %\n");

                if(remain >= 95) ivBattery.setImageResource(R.drawable.bar5);
                else if(remain >= 80) ivBattery.setImageResource(R.drawable.bar4);
                else if(remain >= 50) ivBattery.setImageResource(R.drawable.bar3);
                else if(remain >= 30) ivBattery.setImageResource(R.drawable.bar2);
                else if(remain >= 10) ivBattery.setImageResource(R.drawable.bar1);
                else ivBattery.setImageResource(R.drawable.empty);

                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch (plug){
                    case 0:
                        edtBattery.append("전원 연결 : 안됨");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        edtBattery.append("전원 연결 : 어탭터 연결됨");
                        ivBattery.setImageResource(R.drawable.loading);
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        edtBattery.append("전원 연결 : USB 연결됨");
                        ivBattery.setImageResource(R.drawable.polarity);
                        break;
                }
            }
        }
    };

    @Override
    protected void onPause(){
        super.onPause();
        unregisterReceiver(br);
    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, iFilter);
    }


}
