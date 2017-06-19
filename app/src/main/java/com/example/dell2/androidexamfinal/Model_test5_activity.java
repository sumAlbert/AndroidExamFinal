package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import broadcast.Test5_BroadcastReceiver;
import collector.BaseActivity;

/**
 * Created by wangyan on 2017/6/19.
 */

public class Model_test5_activity extends BaseActivity implements View.OnClickListener{
    private LinearLayout test5_LL_1;
    private Test5_BroadcastReceiver test5_broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_model_test5);
        init();
    }
    public void init(){
//        -------过滤器拦截广播，提交给接收器处理
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.broadcast.Test5");
        test5_broadcastReceiver=new Test5_BroadcastReceiver();
        registerReceiver(test5_broadcastReceiver,intentFilter);
//        ------
        LinearLayout test5_LL_1=(LinearLayout)findViewById(R.id.test5_LL_1);
        test5_LL_1.setOnClickListener(this);
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,Model_test5_activity.class);
        context.startActivity(intent);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.test5_LL_1:
//                com.example.broadcast.Test5 可以改变test5值（or其他）
//                发送
                Intent intent=new Intent("com.example.broadcast.Test5");
                sendBroadcast(intent);
                break;
            default:
                break;
        }
    }
}
