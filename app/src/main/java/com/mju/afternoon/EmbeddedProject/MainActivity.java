package com.mju.afternoon.EmbeddedProject;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       
        /*myApplication17*/
        mContext = getApplicationContext();
        String[] permissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : permissions) {
                int result = PermissionChecker.checkSelfPermission(this, permission);
                if (result == PermissionChecker.PERMISSION_GRANTED);
                else ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
        if (Build.VERSION.SDK_INT>=23 &&
                ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
            return;
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ll = new MyLocationListener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, ll);
    }

    public void pressloginbutton(View view) {
        Intent intent1 = new Intent(this, com.mju.afternoon.EmbeddedProject.Signup.class);
        startActivity(intent1);
    }

    public void presssignupbutton(View view) {
        Intent intent2 = new Intent(this, Signup.class);
        startActivity(intent2);
    }

    /*GPSGoogleEx21*/
    public void onDestroy() {
        super.onDestroy();
        String[] permissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : permissions) {
                int result = PermissionChecker.checkSelfPermission(this, permission);
                if (result == PermissionChecker.PERMISSION_GRANTED);
                else ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
        if (Build.VERSION.SDK_INT>=23 &&
                ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
            return;
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.removeUpdates(ll);
    }

    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location l) {
            Toast.makeText(mContext, l.getLatitude()+","+l.getLongitude(), Toast.LENGTH_SHORT).show();
        }
        @Override public void onProviderDisabled(String p) {}
        @Override public void onProviderEnabled(String p) {}
        @Override public void onStatusChanged(String p, int s, Bundle e) {}
    }

    /*NOtification*/
    public void sendNotification(View view) {
        // NotificationManager
        NotificationManager noManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // NotificationID, PendingIntent
        Intent noIntent = new Intent(this, com.mju.temp_user.notificationex.NotificationActivity.class);
        noIntent.putExtra("noID", 11);
        PendingIntent pendIntent = PendingIntent.getActivity(this, 0, noIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Notification title")
                .setContentText("Notification text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendIntent)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_SOUND);

        Notification no = builder.build();
        noManager.notify(11, no);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
