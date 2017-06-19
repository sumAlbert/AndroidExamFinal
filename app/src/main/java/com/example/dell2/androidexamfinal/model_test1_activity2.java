package com.example.dell2.androidexamfinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import collector.BaseActivity;

/**
 * Created by wangyan on 2017/6/19.
 */

public class model_test1_activity2 extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_test12);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String sex=intent.getStringExtra("sex");
        String hobby=intent.getStringExtra("hobby");
        String blood=intent.getStringExtra("blood");
        Log.d("SecondActivity","name:"+name);//log
        Log.d("SecondActivity","sex:"+sex);
        Log.d("SecondActivity","hobby:"+hobby);
        Log.d("SecondActivity","blood:"+blood);
    }
}
