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

public class WY_activity extends BaseActivity implements View.OnClickListener{
    private LinearLayout test1_wy;
    private LinearLayout test2_wy;
    private LinearLayout test3_wy;
    private LinearLayout test4_wy;
    private TextView titleName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_wy);
        init();
    }
    public void init(){
        test1_wy=(LinearLayout)findViewById(R.id.test1_wy);
        test2_wy=(LinearLayout)findViewById(R.id.test2_wy);
        test3_wy=(LinearLayout)findViewById(R.id.test3_wy);
        test4_wy=(LinearLayout)findViewById(R.id.test4_wy);
        titleName=(TextView)findViewById(R.id.title_name);
        test1_wy.setOnClickListener(this);
        test2_wy.setOnClickListener(this);
        test3_wy.setOnClickListener(this);
        test4_wy.setOnClickListener(this);
        titleName.setText("WY");
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.test1_wy:
                WY_test1_activity.actionStart(WY_activity.this);
                break;
            case R.id.test2_wy:
                WY_test2_activity.actionStart(WY_activity.this);
                break;
            case R.id.test3_wy:
                WY_test3_activity.actionStart(WY_activity.this);
                break;
            case R.id.test4_wy:
                WY_test4_activity.actionStart(WY_activity.this);
                break;
            default:
                break;
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,WY_activity.class);
        context.startActivity(intent);
    }
}
