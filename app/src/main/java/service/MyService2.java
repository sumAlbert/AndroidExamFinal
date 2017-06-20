package service;

import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.dell2.androidexamfinal.ZQ_test3_activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import db.DbHelp;
import hash.HashName;

/**
 * Created by dell2 on 2017/6/19.
 */

public class MyService2 extends Service {
    private DbHelp dbHelp;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dbHelp=new DbHelp(MyService2.this,"MyDb_test.db",null,1);
            insertDb();
            Toast.makeText(MyService2.this,"insert success",Toast.LENGTH_SHORT).show();
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
                handler.obtainMessage(1,"123").sendToTarget();
            }
        },0,5000);
        Log.d("service","execute");
        return super.onStartCommand(intent, flags, startId);
    }
    public void connectTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                insertDb();
                handler.obtainMessage(1,"123").sendToTarget();
            }
        }).start();
    }
    public void insertDb(){
//      获得一个拥有写的权限的数据库
        SQLiteDatabase sqLiteDatabase=dbHelp.getWritableDatabase();
//      存储key-value对 提供给数据库操作
        ContentValues contentValues=new ContentValues();
//        name 就是key hash...为value  （name为属性 key）
//        contentValues.put("name", HashName.getHashRandom(8));
        String str=getDate();
        contentValues.put("createTime",str);
        contentValues.put("log","log:"+ HashName.getHashRandom(8));
//        insert此处name为表名
        sqLiteDatabase.insert("MyTable_test",null,contentValues);
//        name表名
    }
    public String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        return date;
    }
}