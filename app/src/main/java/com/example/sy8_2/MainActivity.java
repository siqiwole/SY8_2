package com.example.sy8_2;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView tv;


    String googleWeatherUrl2 = "http://php.weather.sina.com.cn/xml.php?city=%B1%B1%BE%A9&password=DJOYnieT8234jlsK&day=0";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 定义UI组件
        Button b2 = (Button) findViewById(R.id.Button02);
        tv = (TextView) findViewById(R.id.TextView02);

        // 设置按钮单击监听器
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用HttpCient连接GoogleWeatherAPI
                httpClientConn();

            }
        });

    }

    // 使用HttpCient连接GoogleWeatherAPI
    protected void httpClientConn() {
        //DefaultHttpClient
        DefaultHttpClient httpclient = new DefaultHttpClient();
        //HttpGet
        HttpGet httpget = new HttpGet(googleWeatherUrl2);
        //ResponseHandler
        ResponseHandler responseHandler = new BasicResponseHandler();

        try {
            String content = httpclient.execute(httpget, responseHandler);
            Toast.makeText(getApplicationContext(), "连接Google Weather API成功!",Toast.LENGTH_SHORT).show();
            //设置TextView
            tv.setText(content);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "连接Google Weather API失败", Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }
        httpclient.getConnectionManager().shutdown();
    }
}