package com.mju.afternoon.EmbeddedProject;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

/*NotificationEx*/
public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        int id;
        Bundle extras = getIntent().getExtras();
        id = extras.getInt("noID");
        TextView tv = (TextView)findViewById(R.id.textView2);
        String s = "ID :  "+id;
        tv.setText(s);
        NotificationManager noManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        noManager.cancel(id);
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
