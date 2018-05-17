package com.my.opera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//似乎没有music页面
public class MusicActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(MusicActivity.this,MusicServer.class);
        super.onCreate(savedInstanceState);
        startService(intent);
        //manu();
    }

    protected void onStop(){
        Intent intent = new Intent(MusicActivity.this,MusicServer.class);
        stopService(intent);
        super.onStop();

    }
}
