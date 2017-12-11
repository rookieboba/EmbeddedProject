package com.mju.afternoon.EmbeddedProject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private SQLiteDatabase userDB;
    public static final String CONTENT_NAME = "name";
    public static final String CONTENT_ID = "id";
    public static final String CONTENT_PASSWORD = "password";
    public static final String CONTENT_REPASSWORD="repassword";
    public static final String CONTENT_PHONENUMBER = "phonenumber";
    Cursor uCursor;
    private static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        com.mju.afternoon.EmbeddedProject.FeedReaderDbHelper userDbHelper = new com.mju.afternoon.EmbeddedProject.FeedReaderDbHelper(this);
        userDB = userDbHelper.getWritableDatabase();
        userDbHelper.onCreate(userDB);


        mp= MediaPlayer.create(this,R.raw.maple3);
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

    public void InsertDB(View view) {
        EditText name = (EditText) findViewById(R.id.inputname);
        EditText id = (EditText) findViewById(R.id.inputid);
        EditText pwd = (EditText) findViewById(R.id.inputpwd);
        EditText repwd = (EditText) findViewById(R.id.signup_input_password_confirm);
        EditText phonenumber = (EditText) findViewById(R.id.signup_input_phone);

        ContentValues v = new ContentValues();
        v.put(CONTENT_NAME, name.getText().toString());
        v.put(CONTENT_ID, id.getText().toString());
        v.put(CONTENT_PASSWORD, pwd.getText().toString());
        v.put(CONTENT_REPASSWORD, repwd.getText().toString());
        v.put(CONTENT_PHONENUMBER , phonenumber.getText().toString());

        userDB.insert("userdb", null, v);

        Toast.makeText(getApplicationContext(), "Insert ok", Toast.LENGTH_LONG).show();

        //회원가입 버튼을 누른 후 다시 로그인 화면으로 이동.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
