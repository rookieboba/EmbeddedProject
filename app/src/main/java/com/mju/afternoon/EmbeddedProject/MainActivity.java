package com.mju.afternoon.EmbeddedProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void pressloginbutton(View view) {
        Intent intent1 = new Intent(this, Signup.class);
        startActivity(intent1);
    }

    public void presssignupbutton(View view) {
        Intent intent2 = new Intent(this, Signup.class);
        startActivity(intent2);
    }

}
