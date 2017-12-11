package com.mju.afternoon.EmbeddedProject;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.kakao.util.helper.Utility.getPackageInfo;

public class MainActivity extends AppCompatActivity {

    private SessionCallback callback;
    private static MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("MJU SHUTTLE BUS");
        getKeyHash(getApplicationContext());
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);

        mp=MediaPlayer.create(this,R.raw.maple);
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
        Session.getCurrentSession().removeCallback(callback);
        mp.stop();
    }

    private class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            redirectSignupActivity();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                com.kakao.util.helper.log.Logger.e(exception);
            }

            Toast.makeText(getApplicationContext(), "세션 연결 실패", Toast.LENGTH_LONG).show();
            //세션 연결 실패시 로그인 화면 다시 불러옴
            setContentView(R.layout.activity_login);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void redirectSignupActivity() {
        //세션연결 성공시 signup으로 넘긴다.
        final Intent intent = new Intent(this, KakaoSignupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    public static String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String Key_Hash = new String(Base64.encode(md.digest(),0));
                Log.d("Hash Key", Key_Hash);
             //   return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
               //Log.w("Tag", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }

    public void pressloginbutton(View view) {
        EditText inputid = (EditText) findViewById(R.id.userid);
        EditText inputpwd = (EditText) findViewById(R.id.Password);

        if(inputid.length() == 0 || inputpwd.length() == 0) {
            Toast.makeText(getApplicationContext(), "아이디와 패스워드를 입력해주세요.", Toast.LENGTH_LONG).show();
            return;
        }



        Intent intent1 = new Intent(this, MenuActivity.class);
        startActivity(intent1);
    }

    public void presssignupbutton(View view) {
        Intent intent2 = new Intent(this, Signup.class);
        startActivity(intent2);
    }
    public void onClickLogin(View view) {

        Intent login = new Intent(this, FeedReaderContract.class);
        startActivity(login);
    }

}
