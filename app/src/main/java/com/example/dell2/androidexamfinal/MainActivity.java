package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import collector.BaseActivity;

/**
 * Created by dell2 on 2017/6/19.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout WY;
    private LinearLayout ZQ;
    private LinearLayout MO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        WY=(LinearLayout)findViewById(R.id.WY);
        ZQ=(LinearLayout)findViewById(R.id.ZQ);
        MO=(LinearLayout)findViewById(R.id.MO);
        WY.setOnClickListener(this);
        ZQ.setOnClickListener(this);
        MO.setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.WY:
                WY_activity.actionStart(MainActivity.this);
                break;
            case R.id.ZQ:
                ZQ_activity.actionStart(MainActivity.this);
                break;
            case R.id.MO:
                model_activity.actionStart(MainActivity.this);
                break;
            default:
                break;
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,model_activity.class);
        context.startActivity(intent);
    }
}
