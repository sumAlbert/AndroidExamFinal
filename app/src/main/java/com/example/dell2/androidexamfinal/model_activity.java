package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import collector.BaseActivity;

/**
 * Created by dell2 on 2017/6/19.
 */

public class model_activity extends BaseActivity implements View.OnClickListener{
    private LinearLayout test1_mo;
    private LinearLayout test2_mo;
    private LinearLayout test3_mo;
    private LinearLayout test4_mo;
    private LinearLayout test5_mo;
    private LinearLayout test6_mo;
    private LinearLayout test7_mo;
    private LinearLayout test8_mo;
    private TextView titleName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_model);
        init();
    }
    public void init(){
        test1_mo=(LinearLayout)findViewById(R.id.test1_mo);
        test2_mo=(LinearLayout)findViewById(R.id.test2_mo);
        test3_mo=(LinearLayout)findViewById(R.id.test3_mo);
        test4_mo=(LinearLayout)findViewById(R.id.test4_mo);
        test5_mo=(LinearLayout)findViewById(R.id.test5_mo);
        test6_mo=(LinearLayout)findViewById(R.id.test6_mo);
        test7_mo=(LinearLayout)findViewById(R.id.test7_mo);
        test8_mo=(LinearLayout)findViewById(R.id.test8_mo);
        titleName=(TextView)findViewById(R.id.title_name);
        test1_mo.setOnClickListener(this);
        test2_mo.setOnClickListener(this);
        test3_mo.setOnClickListener(this);
        test4_mo.setOnClickListener(this);
        test5_mo.setOnClickListener(this);
        test6_mo.setOnClickListener(this);
        test7_mo.setOnClickListener(this);
        test8_mo.setOnClickListener(this);
        titleName.setText("MO");
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.test1_mo:
                model_test1_activity.actionStart(model_activity.this);
                break;
            case R.id.test3_mo:
                Model_test3_activity.actionStart(model_activity.this);
                break;
            case R.id.test4_mo:
                Model_test4_activity.actionStart(model_activity.this);
                break;
            case R.id.test5_mo:
                Model_test5_activity.actionStart(model_activity.this);
                break;
            case R.id.test6_mo:
                model_test6_activity.actionStart(model_activity.this);
                break;
            case R.id.test7_mo:
                Model_test7_activity.actionStart(model_activity.this);
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
