package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapt.Model_Test3_Adapt;
import collector.BaseActivity;
import entity.Touch;

/**
 * Created by wangyan on 2017/6/19.
 */
//访问通讯录
//整体
public class Model_test3_activity extends BaseActivity {
//    activity_model_test3.xml
    private ListView test3_ListView;
//    touch为实体类 touchlist放了一堆touch
    private List<Touch> touchList=new ArrayList<>();
//    adapt 适配器
    private Model_Test3_Adapt test3_adapt;
//    初始化
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_model_test3);
        init();
    }
    public void init(){
//        装内容到数组touchlist
        getTouchs();
//        listview整体布局
        ListView test3_ListView=(ListView)findViewById(R.id.test3_ListView);
//        里面内容的布局activity_model_test3_listview
//        把内容装进每一个单个项
        test3_adapt=new Model_Test3_Adapt(Model_test3_activity.this,R.layout.activity_model_test3_listview,touchList);
//        把很多项的内容放在listview
        test3_ListView.setAdapter(test3_adapt);
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,Model_test3_activity.class);
        context.startActivity(intent);
    }
//    给适配器的array组装数据
    public void getTouchs(){
//        指针 便利通讯录
        Cursor cursor=null;
        try{
//            取通讯录数据
            cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
//           指针移动
            while(cursor.moveToNext()){
                String displayName=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String displayTel=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Touch touch=new Touch();
                touch.setName(displayName);
                touch.setTel(displayTel);
                touchList.add(touch);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            if(cursor!=null)
                cursor.close();
        }
    }
}
