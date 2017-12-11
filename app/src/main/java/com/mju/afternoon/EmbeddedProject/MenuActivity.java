package com.mju.afternoon.EmbeddedProject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kakao.auth.Session;

public class MenuActivity extends AppCompatActivity {

    private static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mp= MediaPlayer.create(this,R.raw.maple2);
        mp.setLooping(true);
        mp.start();
    }
    protected void onUserLeaveHint(){
        mp.pause();
        super.onUserLeaveHint();
    }
    public void onResume(){
        mp.start();
        super.onResume();
    }

    public void onBackPressed(){
        mp.stop();
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewMap:
                //Menu에 있는 MapView 를 누르면 네이버 지도 열기
                Intent Mapview = new Intent(this, NavermapActivity.class);
                startActivity(Mapview);
                break;

            case R.id.Weather:
                //날씨 확인을 누르면 WebView를 통해 기상청 사이트 출력
                Intent Weather = new Intent(this, WebViewActivity.class);
                startActivity(Weather);
                break;

            case R.id.Bustime:
                //버스 시간표 확인을 누르면 셔틀버스 시간표 출력
                Intent busTime = new Intent(this, BustimeActivity.class);
                startActivity(busTime);
                break;

        }

        return super.onOptionsItemSelected(item);

    }




}
