package com.example.dell2.androidexamfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import collector.BaseActivity;

/**
 * Created by dell2 on 2017/6/19.
 */

public class WY_test4_activity extends BaseActivity implements View.OnClickListener{
    private TextView titleName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_wy_test4);
        init();
    }
    public void init(){
        titleName=(TextView)findViewById(R.id.title_name);
        titleName.setText("WY_test4");
    }
    public void onClick(View view){
        switch (view.getId()){
            default:
                break;
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,WY_test4_activity.class);
        context.startActivity(intent);
    }
}
