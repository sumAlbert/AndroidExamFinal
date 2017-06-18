package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell2.androidexamfinal.R;

import collector.BaseActivity;

/**
 * Created by dell2 on 2017/6/19.
 */

public class ZQ_activity extends BaseActivity implements View.OnClickListener{
    private TextView titleName;
    private LinearLayout test1_zq;
    private LinearLayout test2_zq;
    private LinearLayout test3_zq;
    private LinearLayout test4_zq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_zq);
        init();
    }
    public void init(){
        test1_zq=(LinearLayout)findViewById(R.id.test1_zq);
        test2_zq=(LinearLayout)findViewById(R.id.test2_zq);
        test3_zq=(LinearLayout)findViewById(R.id.test3_zq);
        test4_zq=(LinearLayout)findViewById(R.id.test4_zq);
        titleName=(TextView)findViewById(R.id.title_name);
        test1_zq.setOnClickListener(this);
        test2_zq.setOnClickListener(this);
        test3_zq.setOnClickListener(this);
        test4_zq.setOnClickListener(this);
        titleName.setText("ZQ");
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.test1_zq:
                ZQ_test1_activity.actionStart(ZQ_activity.this);
                break;
            case R.id.test2_zq:
                ZQ_test2_activity.actionStart(ZQ_activity.this);
                break;
            case R.id.test3_zq:
                ZQ_test3_activity.actionStart(ZQ_activity.this);
                break;
            case R.id.test4_zq:
                ZQ_test4_activity.actionStart(ZQ_activity.this);
                break;
            default:
                break;
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,ZQ_activity.class);
        context.startActivity(intent);
    }
}
