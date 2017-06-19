package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import collector.BaseActivity;
import service.MyService;

/**
 * Created by wangyan on 2017/6/19.
 */

public class Model_test2_activity  extends BaseActivity implements View.OnClickListener{
    private LinearLayout test2_LL_1;
    private LinearLayout test2_LL_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_model_test2);
        init();
    }
    public void init()
    {
        test2_LL_1=(LinearLayout)findViewById(R.id.test2_LL_1);
        test2_LL_2=(LinearLayout)findViewById(R.id.test2_LL_2);
        test2_LL_1.setOnClickListener(this);
        test2_LL_2.setOnClickListener(this);
    }

    public static void actionStart(Context context){
        Intent intent=new Intent(context,Model_test2_activity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.test2_LL_1:
                Intent start=new Intent(this, MyService.class);
//                开始服务
                startService(start);
                break;
            case R.id.test2_LL_2:
                Intent stop=new Intent(this, MyService.class);
//                停止服务
                stopService(stop);
                break;
            default:
                break;
        }

    }
//    public void connectTest(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection=null;
//                BufferedReader reader=null;
//                try {
//                    URL url=new URL("http://172.30.198.53:8080/Test2_ZQ?userID=10152510288&Name=wy");
//                    connection=(HttpURLConnection)url.openConnection();
//                    connection.setRequestMethod("GET");
////                    连接超时
//                    connection.setConnectTimeout(8000);
////                    读取超时
//                    connection.setReadTimeout(8000);
////                    等待输入流
//                    InputStream inputStream=connection.getInputStream();
//                    //下面对获取到的输入流进行读取
//                    reader=new BufferedReader(new InputStreamReader(inputStream));
//                    StringBuilder response=new StringBuilder();
//                    String line;
//                    while((line=reader.readLine())!=null){
//                        response.append(line);
//                    }
//
//                    showResponse(response.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    if(reader!=null){
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if(connection!=null){
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
//    }
//    private void showResponse(final String response){
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    JSONObject jsonObject=new JSONObject(response);
//                    String str=jsonObject.getString("returnName");
//                    Toast.makeText(Model_test2_activity.this,str,Toast.LENGTH_SHORT).show();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
