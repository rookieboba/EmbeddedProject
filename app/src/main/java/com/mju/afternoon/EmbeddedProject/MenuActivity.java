package com.mju.afternoon.EmbeddedProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
            case R.id.Chat:

            case R.id.Bustime:
                //버스 시간표 확인을 누르면 xmlparsing을 통해 셔틀버스 시간표 출력
                Intent busTime = new Intent(this, BustimeActivity.class);
                startActivity(busTime);

            default: return super.onOptionsItemSelected(item);

        }

    }




}
