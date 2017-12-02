package com.mju.afternoon.EmbeddedProject;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by sungbin on 2017-12-01.
 */

public final class Constants {
    public static final HashMap<String ,LatLng> ZONES =new HashMap<String,LatLng>();
    static {
        ZONES.put("ㅁㅈㄷ",new LatLng(37.222253,127.186292));
    }

}
