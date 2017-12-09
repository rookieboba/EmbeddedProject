package com.mju.afternoon.EmbeddedProject;

import android.app.Activity;
import android.app.Application;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

/**
 * Created by Kim Myoung jae on 2017-12-08.
 */

public class ApplicationController extends Application{
    private static ApplicationController instance = null; //인스턴스 객체 선언
    private static volatile Activity currentActivity = null;

    //매번 객체를 생성하지 않고 다른 액티비티에서 사용가능하게 끔 static으로 선언
    public static ApplicationController getInstance() {return instance;}

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationController.instance = this; //인스턴스 초기화
        KakaoSDK.init(new KaKaoSDKAdapter());

    }

    public static Activity getCurrentActivity() {return  currentActivity;}

    public static void setCurrentActivity(Activity currentActivity) {
        ApplicationController.currentActivity = currentActivity;
    }

    //앱 종료시 객체 초기화
    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
