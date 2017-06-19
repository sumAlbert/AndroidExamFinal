package service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.dell2.androidexamfinal.Model_test2_activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dell2 on 2017/6/19.
 */

public class MyService extends Service {
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MyService.this,(String)msg.obj,Toast.LENGTH_SHORT).show();
        }
    };
    private Timer timer=new Timer();
    private MyBinder myBinder;
    class MyBinder extends Binder{

    }
    //
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
//    初始化
    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("service","create");
    }
//    销毁
    @Override
    public void onDestroy(){
        super.onDestroy();
        timer.cancel();
        Log.d("service","destroy");
    }
//    开始请求
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                connectTest();
            }
        },0,5000);
        Log.d("service","execute");
        return super.onStartCommand(intent, flags, startId);
    }
    public void connectTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                BufferedReader reader=null;
                try {
//                    ！！！！！修改
                    URL url=new URL("http://172.30.198.53:8080/Test2_ZQ?userID=10152510288&Name=wy");
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
//                    连接超时
                    connection.setConnectTimeout(8000);
//                    读取超时
                    connection.setReadTimeout(8000);
//                    等待输入流
                    InputStream inputStream=connection.getInputStream();
                    //下面对获取到的输入流进行读取
                    reader=new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    handler.obtainMessage(1,response.toString()).sendToTarget();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
}