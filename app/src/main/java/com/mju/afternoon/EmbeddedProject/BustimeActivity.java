package com.mju.afternoon.EmbeddedProject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BustimeActivity extends AppCompatActivity {
//    private EditText et = null;
//    private String urlstr = "http://www.mju.ac.kr/mbs/mjukr/subview.jsp?id=mjukr_010902010000\n";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bustime);
        //et = (EditText) findViewById(R.id.editText);
    }

//    public void startParsing(View view) {
//        new ParseTask().execute(urlstr);
//    }
//
//    class ParseTask extends AsyncTask<String, Void, String> {
//
//
//        @Override
//        protected void onPreExecute() {et.setText("잠시만 기다려주세요..");}
//        @Override
//        protected void onPostExecute(String result) {et.setText(result);}
//
//        @Override
//        protected String doInBackground(String... params) {
//            String result;
//
//            try {
//                URL url = new URL(params[0]);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                if (conn == null) return "openConnection";
//                conn.setReadTimeout(10000);
//                conn.setConnectTimeout(15000);
//                conn.setRequestMethod("GET");
//                conn.setDoInput(true);
//                conn.setUseCaches(false);
//                if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                    return " NOT HTTP_OK";
//                }
//
//                StringBuilder sb = new StringBuilder();
//                InputStream is = conn.getInputStream();
//
//                try {
//                    XmlPullParser parser = Xml.newPullParser();
//                    parser.setInput(is, "UTF-8");
//
//                    int eventType = parser.getEventType();
//                    while (eventType != XmlPullParser.END_DOCUMENT) {
//                        if (eventType == XmlPullParser.START_TAG) sb.append("Start Tag : "+parser.getName()+"\n");
//                        else if (eventType == XmlPullParser.END_TAG) sb.append("End Tag: "+parser.getName()+"\n");
//                        else if (eventType == XmlPullParser.TEXT) sb.append("Text: "+parser.getName()+"\n");
//                        eventType = parser.next();
//                    }
//                } catch (XmlPullParserException e) {
//                    return "Error parsing";
//                }
//                    is.close();
//                    conn.disconnect();
//                    result = sb.toString();
//            } catch (IOException e) {
//                return "Error.... something wrong";
//            }
//
//            return result;
//        }
}

