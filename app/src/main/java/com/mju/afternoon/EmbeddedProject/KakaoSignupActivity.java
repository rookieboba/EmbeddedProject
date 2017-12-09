package com.mju.afternoon.EmbeddedProject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kakao.auth.ErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;

/**
 * Created by Kim Myoung jae on 2017-12-08.
 */

public class KakaoSignupActivity extends Activity {
    //Main으로 넘길지, 가입 페이지를 그릴지 판단하기 위해 호출되는 액티비티
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestMe();
    }

    protected void requestMe() {
        // 유저의 정보를 받아옴
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                String msg = "fail to get user info. =" + errorResult;
                Logger.d(msg);
                Log.v("fail", "fail");

                ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());
                if(result == ErrorCode.CLIENT_ERROR_CODE) {
                    finish();
                } else {
                    redirectLoginActivity();
                }
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                redirectLoginActivity();
            }

            @Override
            public void onNotSignedUp() { //카톡 회원이 아닐 경우
                redirectLoginActivity();
            }

            @Override
            public void onSuccess(UserProfile result) {
                Logger.d("UserProfile : " + result);
                Log.v("user", result.toString());
                redirectNextActivity(); // 로그인 성공시 다음 액티비티로
            }
        });
    }

    private void redirectNextActivity() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }

    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
