package com.example.dell2.androidexamfinal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import collector.BaseActivity;
import db.DBHandler;

import db.DbHelp;

import hash.HashName;
import service.MyService;
import service.MyService2;

/**
 * Created by wangyan on 2017/6/19.
 */

//数据库：创建 开始插入  停止插入  展示
//分别对应ll1->ll4
public class ZQ_test3_activity extends BaseActivity implements View.OnClickListener{
    private DbHelp dbHelp;
    private DBHandler dbHandler;
    private LinearLayout test7_LL_1;
    private LinearLayout test7_LL_2;
    private LinearLayout test7_LL_3;
    private LinearLayout test7_LL_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_model_test7);
        init();
    }
    public void init(){
        test7_LL_1=(LinearLayout)findViewById(R.id.test7_LL_1);
        test7_LL_2=(LinearLayout)findViewById(R.id.test7_LL_2);
        test7_LL_3=(LinearLayout)findViewById(R.id.test7_LL_3);
        test7_LL_4=(LinearLayout)findViewById(R.id.test7_LL_4);
        test7_LL_1.setOnClickListener(this);
        test7_LL_2.setOnClickListener(this);
        test7_LL_3.setOnClickListener(this);
        test7_LL_4.setOnClickListener(this);
//
        dbHelp=new DbHelp(this,"MyDb_test.db",null,1);
        dbHandler=new DBHandler(new WeakReference<BaseActivity>(this));
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,ZQ_test3_activity.class);
        context.startActivity(intent);
    }
    @Override
    public void onClick(View view) {
        SQLiteDatabase sqLiteDatabase;
        switch (view.getId()){
            case R.id.test7_LL_1:
//                获取可以写的数据库
//                如果没有 就调用dbhelp里面的onCreate
//                如果有 就获得写的权限
                dbHelp.getWritableDatabase();
                break;
            case R.id.test7_LL_2:
                Intent start=new Intent(this, MyService2.class);
//                开始服务
                startService(start);
//                dbHandler.sendEmptyMessageDelayed(DBHandler.DOING,1000);
                break;
            case R.id.test7_LL_3:
                Intent stop=new Intent(this, MyService2.class);
//                开始服务
                stopService(stop);
//                dbHandler.sendEmptyMessage(DBHandler.OVER);
//                Toast.makeText(ZQ_test3_activity.this,"over",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
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
        contentValues.put("log","log:"+HashName.getHashRandom(8));
//        insert此处name为表名
        sqLiteDatabase.insert("MyTable_test",null,contentValues);
//        name表名
        Toast.makeText(ZQ_test3_activity.this,"insert success",Toast.LENGTH_SHORT).show();
    }
    public void displayDb(){
        SQLiteDatabase sqLiteDatabase=dbHelp.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.query("name",null,null,null,null,null,null);
//        name表名
        if(cursor.moveToFirst()){
            do{
                String name=cursor.getString(cursor.getColumnIndex("name"));
                Log.d("Test7","Name"+name);
            }while(cursor.moveToNext());
        }
        cursor.close();
    }
    public DBHandler getHandler(){
        return this.dbHandler;
    }
    public String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        return date;
    }
}
